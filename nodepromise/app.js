/**
 * http://usejsdoc.org/
 */
var async = require('async');
var express = require('express');
var nonblock = require('./nonblock');

var app = express();

var router = express.Router();
app.use(router);



router.get("/promise", function(req, res) {
	res.json({"APP" : nonblock.APP_NAME});
});

router.get("/promise1", function(req, res) {
	console.log("PROMISE");
	async.series({
	    one: function(callback){
	    	nonblock.testp1(callback);
	    },
	    two: function(callback){
	    	nonblock.testp2(callback);
	    }
	},
	function(err, results) {
		res.json(results);
	});
});



app.listen(3000, function(){
	console.log("Application started!!");
});
