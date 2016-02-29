/**
 * http://usejsdoc.org/
 */
var express = require('express');
var router = express.Router();

var app = express();
app.use(express.static('public'));

router.param("id", function(req,res,next,id){
	console.log("ADMEO PARAM");
	next();
});

router.get("/ademo/:id", function(req, res, next){
	var obj = {"vr" : "coming soon"};
	console.log("this method satisfied");
	next();
});

router.get("/ademo/:id", function(req, res){
	var obj = {"vr" : "coming soon"};
	console.log("this method also satisfied!!");
	res.send(obj);
});


app.use(router);

app.listen(3000, function () {
	console.log('Example app listening on port 3000!!');
});
