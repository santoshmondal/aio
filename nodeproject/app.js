/**
 * http://usejsdoc.org/
 */
var express = require('express');
var mongoose = require('mongoose');



var app = express();
app.use(express.static('public'));

// db connect
mongoose.connect('mongodb://localhost/test');


// respond with "hello world" when a GET request is made to the homepage
app.get('/abc', function(req, res) {
  res.send('hello world');
});


app.get("/dbref", function(req, res){
	var Cat = mongoose.model('Cat', { name: String });

	var kitty = new Cat({ name: 'Zildjian' });
	kitty.save(function (err) {
	  if (err) {
		  console.log('meow');
		  res.send('meow error');
	  } else {
		  res.send('bhaw bhaw success');
	  }
	});
	
	

});


app.listen(3000, function () {
	console.log(__dirname);
	console.log('Example app listening on port 3000!');
});