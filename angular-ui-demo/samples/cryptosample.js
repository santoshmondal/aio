/**
 * http://usejsdoc.org/
 */
var crypto = require('crypto');

var password = "india";

var buf = crypto.randomBytes(16);
var salt = buf.toString('hex');
console.log('Have %d bytes of random data: %s', buf.length, buf);
console.log('To String: %s', salt);


var passkey =  crypto.pbkdf2Sync(password, salt, 100, 64);
var passkeyhash1 = passkey.toString();
var passkeyhash2 = passkey.toString();
console.log("The password key : %s ", passkeyhash1);


