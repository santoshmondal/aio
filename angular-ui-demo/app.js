/**
 * http://usejsdoc.org/
 */
var express = require('express');
var router = express.Router();
var jwt = require('jsonwebtoken');

var ejwt = require('express-jwt');

var mod1 = require('./samples/mod1');


var app = express();
app.use(express.static('public'));

app.locals.secret = 'PUBLIC_SECRET_KEY';


// token validation
app.use(ejwt({secret: app.locals.secret, userProperty: 'payload'}).unless({
	"path":['/login']
}));


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


app.use("/login",function(req, res){
	var today = new Date();
	var exp = new Date(today);
	exp.setDate(today.getDate() + 60);
	
	var jwtoken = jwt.sign({
		  '_id': 'skm128',
		  'username': 'India',
		  'exp': parseInt(exp.getTime() / 1000),
		}, app.locals.secret);
	res.json(jwtoken);
});

app.use("/mod1", mod1);


app.use(router);

app.listen(3000, function () {
	console.log('Example app listening on port 3000!!');
});
