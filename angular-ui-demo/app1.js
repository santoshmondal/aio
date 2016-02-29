/**
 * http://usejsdoc.org/
 */
var express = require('express');
var router = express.Router();
var passport = require('passport');
var bodyParser = require('body-parser');



// custom
require('./samples/passport');
var mod1 = require('./samples/mod1');


// Intialize express instance
var app = express();


// middleware initializaion
app.use(express.static('public'));
app.use(bodyParser.json()); 
app.use(bodyParser.urlencoded({ extended: true })); 
app.use(passport.initialize());
app.use(router);


// All Apis
app.post("/login",function(req, res, next){
	console.log(req.body);
	if(!req.body.uname || !req.body.pname){
	    return res.status(400).json({message: 'Please fill out all fields'});
	 }
	
	passport.authenticate('local', function(err, user, info){
	    if(err) { 
	    	return next(err);
	    }

	    if(user) {
	    	return res.json(user);
	    } else {
	    	return res.status(401).json(info);
	    }
	 })(req, res, next);
});




app.use("/mod1", mod1);

app.listen(3000, function () {
	console.log('Example app listening on port 3000!!');
});
