/**
 * http://usejsdoc.org/
 */
var express = require('express');
var app = new express();

var r1 = express.Router();
r1.get('/', function (req, res, next) {
	console.log("r1");
  next();
});

var r2 = express.Router();
r2.get('/', function (req, res, next) {
	console.log("r2");
  next();
}, function(req, res){
	console.log("r3");
	res.send("hello world");
});



app.use(r1, r2);
app.listen(3000);