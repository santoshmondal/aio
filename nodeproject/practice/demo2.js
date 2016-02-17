/**
 * http://usejsdoc.org/
 */
var express = require('express');
var app = express();

var MongoClient = require('mongodb').MongoClient;

app.get("/", function(req, res) {

	var sresult = null;
	MongoClient.connect('mongodb://localhost:27017/test', function(err, db) {
		if (err) {
			throw err;
		}
		db.collection('cats').find().toArray(function(err, result) {
			if (err) {
				throw err;
			}
			sresult = result;
			console.log(result);
			console.log(sresult);
			res.send(result);
		});
	});

	
});

app.listen(3000);