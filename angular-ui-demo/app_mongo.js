/**
 * http://usejsdoc.org/
 */
var mongodb = require('mongodb');


// Monogd Database 
var mongoClient = mongodb.MongoClient;
var url = "mongodb://localhost/test";


mongoClient.connect(url, function(err, db){
	if(err) {
		return err;
	}
	
	console.log("Connected successfully!!");
	db.close();
});


function insert() {
	mongoClient.connect(url, function(err, db) {
		var mjson = {
				"_id" : "1",
				"name" : "sanam teri kasam",
				"artist": 'mawra'	
		};
		
		db.collection('users').insert(mjson, function(err, result){
			if(err !== null) {
				console.log(err);
			}
			console.log(result);
			db.close();
		});
	});
}


function update() {
	mongoClient.connect(url, function(err, db) {
		var qjson = {'_id' : '1'};
		var ujson = {
				"$set" : {
					"awards" : 'oscar'
				},
				$currentDate: { "lastModified": true }
		};
		
		db.collection('users').update(qjson, ujson, function(err, result){
			console.log(err);
			console.log(result);
			db.close();
		});
	});
}



update();