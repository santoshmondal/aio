/**
 * 
 */
var express = require('express');
var admin = require('./admin');
var app = new express();

app.use("/", function(req, res, next){
	console.log("filtersss");
	next();
});

app.get("/", function(req, res) {
	console.log("Main resource served!!");
	res.send("Main resource served!!");
});

app.use("/admin", admin.admin);

app.listen("3000", function() {
	console.log("server started");
});