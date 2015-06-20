package com.rediff.build.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

import com.rediff.pojo.CourierFlat;
import com.rediff.pojo.CourierShowFlat;

public class LargeCsvWrite {

	private static final CacheManager instance = CacheManager.getInstance();
	private static final String PREFIX = "CSF_";

	public static void main(String[] args) {
		largeCsvWrite();
	}

	public static void largeCsvWrite() {
		long sTime = System.currentTimeMillis();
		CSVWriter writer = null;
		try {
			String csvFilename = "/home/santoshm/rediff/temp/sample.csv";
			writer = new CSVWriter(new FileWriter(csvFilename));

			// List<CourierShowFlat> csfList = new ArrayList<CourierShowFlat>();
			List<String> csfListIds = new ArrayList<String>();
			for (int i = 0; i < 1000000; i++) {
				CourierShowFlat csf = new CourierShowFlat();

				CourierFlat cBase = new CourierFlat();
				cBase.setLogisticprovider("logistics" + i);
				cBase.setAirwaybillnumber("airwaybill" + i);
				cBase.setDeliverystatus("delivered" + i);

				List<CourierFlat> cEventList = new ArrayList<CourierFlat>();
				for (int j = 0; j < 5; j++) {
					CourierFlat cEvent = new CourierFlat();
					cEvent.setLogisticprovider("logistics" + j);
					cEvent.setAirwaybillnumber("airwaybill" + j);
					cEvent.setDeliverystatus("delivered" + j);

					cEventList.add(cEvent);
				}

				csf.setCourier(cBase);
				csf.setEvents(cEventList);

				// csfList.add(csf);
				String key = PREFIX + i;
				csfListIds.add(key);
				instance.save(key, csf);
			}

			System.out.println("OBJECT CREATED :: TT :: " + (System.currentTimeMillis() - sTime) / 1000.0 + " secs");

			// WRITE STARTS
			/*for (CourierShowFlat csf : csfList) {

				CourierFlat cBase = csf.getCourier();
				List<CourierFlat> cEvents = csf.getEvents();

				List<String> iRowList = new ArrayList<String>();
				iRowList.add(cBase.getLogisticprovider());
				iRowList.add(cBase.getAirwaybillnumber());

				for (CourierFlat cEvent : cEvents) {
					iRowList.add(cEvent.getLogisticprovider());
					iRowList.add(cEvent.getAirwaybillnumber());
				}

				String[] iRow = iRowList.toArray(new String[iRowList.size()]);
				writer.writeNext(iRow);
			}*/

			for (String csfId : csfListIds) {
				CourierShowFlat csf = (CourierShowFlat) instance.get(csfId);
				if (csf != null) {
					CourierFlat cBase = csf.getCourier();
					List<CourierFlat> cEvents = csf.getEvents();

					List<String> iRowList = new ArrayList<String>();
					iRowList.add(cBase.getLogisticprovider());
					iRowList.add(cBase.getAirwaybillnumber());

					for (CourierFlat cEvent : cEvents) {
						iRowList.add(cEvent.getLogisticprovider());
						iRowList.add(cEvent.getAirwaybillnumber());
					}

					String[] iRow = iRowList.toArray(new String[iRowList.size()]);
					writer.writeNext(iRow);
				}

			}

			System.out.println("CSV WRITE :: TT :: " + (System.currentTimeMillis() - sTime) / 1000.0 + " secs");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
