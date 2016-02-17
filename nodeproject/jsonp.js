/**
 * http://usejsdoc.org/
 */
var express = require('express');
var app = express();

// serving public content
app.use(express.static("public"));
express.static(__dirname + '/public')

app.get("/test", function(req, res) {
	console.log("test called...");
	res.jsonp({ "userid": 'sky128' });
	res.end();
});


app.listen(3000);