/**
 * http://usejsdoc.org/
 */
var express = require('express');
var mongoose = require('mongoose');



var app = express();
app.use(express.static('public'));

// db connect
mongoose.connect('mongodb://localhost/test');


app.use(function(req, res, next){
	console.log("FILTER 1");
	app.set("filter1", req.originalUrl);
	next();
});

app.use(function(req, res, next){
	console.log("FILTER 2");
	app.set("filter2", req.baseUrl);
	next();
});

// respond with "hello world" when a GET request is made to the homepage
app.get('/abc', function(req, res) {
	  var resp = {
			  		"title" : "hello world",
			  		"filter1" : app.get("filter1"),
			  		"filter2" : app.get("filter2")
	  };
	  res.send(resp);
});


app.get("/dbref", function(req, res){
	var Cat = mongoose.model('Cat', { name: String });

	var kitty = new Cat({ name: 'Zildjian' });
	kitty.save(function (err) {
	  if (err) {
		  console.log('meow');
		  res.send('meow error');
	  } else {
		  var resp = {
			  		"title" : "hello world",
			  		"filter1" : app.get("filter1"),
			  		"filter2" : app.get("filter2")
		  };
		  res.send(resp);
	  }
	});
});


app.listen(3000, function () {
	console.log(__dirname);
	console.log('Example app listening on port 3000!');
});