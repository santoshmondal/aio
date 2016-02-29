/**
 * http://usejsdoc.org/
 */
var crypto = require('crypto');
var jwt = require('jsonwebtoken');


var password = "india";

var buf = crypto.randomBytes(16);
var salt = buf.toString('hex');
console.log('Have %d bytes of random data: %s', buf.length, buf);
console.log('To String: %s', salt);


var passkey =  crypto.pbkdf2Sync(password, salt, 100, 64);
var passkeyhash1 = passkey.toString('hex');
var passkeyhash2 = passkey.toString('hex');
console.log("The password key : %s ", passkeyhash1);

if(passkeyhash1 === passkeyhash2) {
	console.log("Equals");
}

// base64
var buffer = new Buffer("SECRET").toString('base64');
console.log(buffer);
console.log(new Buffer(buffer, 'base64').toString('ascii'));


//set expiration to 60 days
var today = new Date();
var exp = new Date(today);
exp.setDate(today.getDate() + 60);

var jwtoken = jwt.sign({
				  _id: 'skm128',
				  username: 'India',
				  exp: parseInt(exp.getTime() / 1000),
				}, 'PUBLIC_SECRET_KEY');
console.log(jwtoken);