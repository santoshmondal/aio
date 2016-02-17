/**
 * http://usejsdoc.org/
 */
var express = require('express');

var app = new express();

var cookieParser = require('cookie-parser');

//load the cookie-parsing middleware
app.use(cookieParser());


app.use(function(req, res, next){
	console.log("Middleware...");
	req.reqtime = Date.now();
	
	next();
});


app.get("/", function(req, res){
	var result = "Hello World";
	result += req.reqtime;
	
	res.send(result);
});


app.get('/user/:id', function (req, res, next) {
  console.log('ID:', req.params.id);
  next();
}, function (req, res, next) {
	console.log('ID1:', req.params.id);
  res.send('User Info');
 next();
});

// handler for the /user/:id path, which prints the user ID
app.get('/user/:id', function (req, res, next) {
	console.log('ID2:', req.params.id);
  res.end(req.params.id);
});

app.listen(3000);