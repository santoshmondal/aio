/**
 * 
 */
var express = require('express');
var app = new express();
var admin = new express();


app.get("/", function(req, res) {
	console.log("Main resource served!!");
	res.send("Main resource served!!");
});

admin.get('/', function (req, res) {
	  console.log(admin.mountpath); // /admin
	  res.send('Admin Homepage');
});

admin.get('/abc', function (req, res) {
	  console.log(admin.mountpath); // /admin
	  res.send('Admin ABC Homepage');
});

app.use('/admin', admin); // mount the sub app

app.listen("3000", function() {
	console.log("server started");
});