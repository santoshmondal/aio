/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rediff.build.csv;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.OperationTimeoutException;

import org.apache.log4j.Logger;

public class CacheManager {

	private static final Logger log = Logger.getLogger(CacheManager.class);
	private ArrayBlockingQueue<MemcachedClient> memcachedClients = null;
	private final int ttl = 0;
	private final int MEMCACHE_STRING_MODE = 0;
	private final long MEMCACHE_TIME_TO_LOCATE = 10000;
	private final int MEMCACHE_CLIENT_TO_SERVER_CONNECTIONS = 51;
	private static final String MEMCACHED_SERVERS = "localhost:11211";

	private static CacheManager cm = null;

	public static synchronized CacheManager getInstance() {

		if (null == cm) {
			cm = new CacheManager();
		}
		return cm;
	}

	private CacheManager() {
		try {
			memcachedClients = new ArrayBlockingQueue<MemcachedClient>(MEMCACHE_CLIENT_TO_SERVER_CONNECTIONS);
			int maxConnections = MEMCACHE_CLIENT_TO_SERVER_CONNECTIONS - 1;
			log.debug("CacheManager | maxConnections " + maxConnections);
			for (int i = 0; i <= maxConnections; i++) {
				MemcachedClient client = new MemcachedClient(AddrUtil.getAddresses(MEMCACHED_SERVERS));
				memcachedClients.offer(client);
			}
		} catch (IOException ex) {
			log.error("SpyCacheManager() --> Exception occured while initializing SpyCacheManager object.\n", ex);
		}

	}

	/**
	 *
	 * This method let us to remove an object from the cache for the specific
	 * key.
	 *
	 * @param key
	 * @return
	 */
	public Boolean delete(String key) {

		Boolean ret = Boolean.TRUE;
		MemcachedClient client = getClient();
		if (null != client) {
			log.info("delete() --> Key: " + key);
			try {
				client.delete(key);
			} catch (OperationTimeoutException ex) {
				log.error("delete() --> OperationTimeoutException occured while calling delete() method.\n");
			} finally {
				releaseClient(client);
			}
		}

		return ret;
	}

	/**
	 * Non in use.
	 *
	 * @param context
	 * @param mode
	 * @deprecated
	 */
	@Deprecated
	public Boolean deleteAllForContext(String context, int mode) {

		log.info("deleteAllForContext(): Context key: " + context);
		Boolean ret = Boolean.TRUE;
		MemcachedClient client = getClient();
		if (null != client) {

			String contextKey = null;
			if (mode == MEMCACHE_STRING_MODE) {
				contextKey = "/" + context + "/";
			} else {
				contextKey = context;
			}
			String value = null;

			try {
				value = (String) client.get(contextKey);
				log.info("deleteAllForContext(): " + context + " & Value: " + value);
				if (null != value && !value.equals("")) {
					String[] keys = value.split(":");
					for (String key : keys) {
						log.info("deleteAllForContext(): Key: " + key);
						client.delete(key);
					}
					client.delete(contextKey);
				}
			} catch (OperationTimeoutException ex) {
				log.error("deleteAllForContext() --> OperationTimeoutException " + "occured while calling deleteAllForContext() method.\n");
			} finally {
				releaseClient(client);
			}
		}
		return ret;
	}

	/**
	 * This method let us help to mark all the cache data to be in soft delete
	 * format. Still, all the key remains in the cache, they begin to delete
	 * from the cache as the newer keys begin to jump in the cache.
	 *
	 * @retun <code>Boolean</code>
	 */
	public Boolean flushAll() {

		MemcachedClient client = getClient();
		Boolean ret = Boolean.FALSE;

		if (null != client) {
			try {
				Future<Boolean> fs = client.flush();
				try {
					ret = fs.get();
				} catch (InterruptedException ex) {
					log.error("flushAll() --> InterruptedException occured while flushing cache all objects.\n", ex);
				} catch (ExecutionException ex) {
					log.error("flushAll() --> ExecutionException occured while flushing cache all objects.\n", ex);
				}
			} catch (OperationTimeoutException ex) {
				log.error("flushAll() --> OperationTimeoutException occured while flushing cache all objects.\n");
			} finally {
				releaseClient(client);
			}
		}

		return ret;
	}

	/**
	 *
	 * This method get object from cache servers and returns it
	 *
	 * NOTE: If there is no data found in cache servers then, it returns null
	 * value.
	 *
	 * @param key
	 * @return
	 */
	public Object get(String key) {

		log.info("get() --> Getting value for key: " + key);
		MemcachedClient client = getClient();
		Object o = null;
		if (null != client) {
			Future<Object> f = client.asyncGet(key);
			try {
				o = f.get(MEMCACHE_TIME_TO_LOCATE, TimeUnit.MILLISECONDS);
			} catch (OperationTimeoutException ex) {
				log.error("get() --> OperationTimeoutException occured while calling get() method.");
			} catch (Exception ex) {
				log.error("get() --> GenericException occured while calling get() method. Message: " + ex.getMessage() + "\n", ex);
			} finally {
				releaseClient(client);
			}
		}

		return o;
	}

	/**
	 * This method helps to get the cache client from the array of the cache
	 * client.
	 *
	 * @return <code>MemcachedClient</code>
	 */
	public MemcachedClient getClient() {

		MemcachedClient client = null;
		try {
			client = memcachedClients.poll(MEMCACHE_TIME_TO_LOCATE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			log.error("Exception while acquireing memcache connection", e);
		}

		return client;
	}

	/**
	 *
	 * This method get all objects from cache servers and returns a map object
	 * which holds cache key and corresponding object as an entry.
	 *
	 * NOTE: If there is no data found in cache servers then, it returns map
	 * with no entries
	 *
	 * @param keys
	 *            cache keys
	 * @return
	 */
	public Map<String, Object> getMulti(String[] keys) {

		if (null != keys && keys.length > 0) {
			log.error("getMulti() --> One of the key in array: " + keys[0]);
		}
		MemcachedClient client = getClient();
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != client) {
			Future<Map<String, Object>> f = client.asyncGetBulk(keys);
			try {
				map = null;
				map = f.get(MEMCACHE_TIME_TO_LOCATE, TimeUnit.MILLISECONDS);
			} catch (OperationTimeoutException ex) {
				log.error("getMulti() --> OperationTimeoutException occured while calling getMulti() method.\n");
			} catch (Exception ex) {
				log.error("getMulti() --> GenericException occured while calling getMulti() method. Message: " + ex.getMessage() + "\n", ex);
			} finally {
				releaseClient(client);
			}
		}

		return map;
	}

	/**
	 * This method accepts three param. The first param key is an array of
	 * String. The array could like the below example.
	 *
	 * Example: rediff.user---profiles---60555 rediff.user---collections---60555
	 *
	 * The second parameter is the splitParam '---' on the basis of that each
	 * element in the array will be split. And the target index is the index of
	 * the element where we can fetch the person id.
	 *
	 * This method basically supports to search for multiple keys in the cache.
	 * and while returning the data back to the user it returns the list where
	 * key is the person id (Long value) and value id the actual object fetched
	 * from the cache.
	 *
	 * @param keys
	 *            an array of cache keys
	 * @param splitParam
	 *            parameter on which basis split will happen
	 * @param targetIndex
	 *            index at which numeric id is located after split
	 * @return a map which has primary numeric id as key and cache object as
	 *         value
	 */
	public Map<Long, Object> getMulti(String[] keys, String splitParam, int targetIndex) {

		Map<Long, Object> retMap = new HashMap<Long, Object>();

		Map<String, Object> cacheMap = this.getMulti(keys);
		for (Map.Entry<String, Object> entry : cacheMap.entrySet()) {

			String memcacheKey = entry.getKey();
			Long personId = Long.parseLong(memcacheKey.split(splitParam)[targetIndex]);
			retMap.put(personId, entry.getValue());
		}

		return retMap;
	}

	private void releaseClient(MemcachedClient client) {
		try {
			memcachedClients.offer(client, MEMCACHE_TIME_TO_LOCATE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			log.error("Exception while closing memcache connection ::: ", e);
		}
	}

	/**
	 * This method let us save an object in the cache. The incoming parameter
	 * forms the key and value to be saved in cache. The second parameter
	 * specify the time frame. The object will be 'LIVE' in cache.
	 *
	 * @param key
	 * @param timeToLive
	 * @param object
	 * @return
	 */
	public Boolean save(String key, int timeToLive, Object object) {

		Boolean ret = Boolean.TRUE;

		MemcachedClient client = getClient();
		if (null != client) {
			log.info("save() --> Key: " + key);
			try {
				client.set(key, timeToLive, object);
			} catch (OperationTimeoutException ex) {
				log.error("save() --> OperationTimeoutException occured while calling save() method.\n");
			} finally {
				releaseClient(client);
			}
		}

		return ret;
	}

	/**
	 * This method let us save an object in the cache. The incoming parameter
	 * forms the key and value to be saved in cache.
	 *
	 * @param key
	 *            cache key
	 * @param object
	 *            object which will be stored in cache
	 * @return a boolean value
	 */
	public Boolean save(String key, Object object) {

		Boolean ret = Boolean.TRUE;

		MemcachedClient client = getClient();
		if (null != client) {
			log.info("save() --> Key: " + key);
			try {
				client.set(key, ttl, object);
			} catch (OperationTimeoutException ex) {
				log.error("save() --> OperationTimeoutException occured while calling save() method.\n");
			} finally {
				releaseClient(client);
			}
		}

		return ret;
	}

	public void shutdownClients() {

		Iterator<MemcachedClient> iterator = memcachedClients.iterator();
		if (iterator.hasNext()) {
			MemcachedClient memcachedClient = iterator.next();
			memcachedClient.shutdown();
		}
	}

	public static void main(String[] args) {

		CacheManager instance = getInstance();
		instance.save("key1", "value1");

		for (int i = 0; i < 5; i++) {
			instance = getInstance();
			String gStr = (String) instance.get("key1");
			System.out.println(gStr);
		}
	}
}
