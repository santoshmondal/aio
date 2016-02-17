var express = require('express');
var admin = new express();


admin.get('/', function (req, res) {
	  console.log(admin.mountpath); // /admin
	  res.send('Admin / Homepage');
});

admin.get('/abc', function (req, res) {
	  console.log(admin.mountpath); // /admin
	  res.send('Admin abc Homepage');
});

admin.get('/abc/bcd', function (req, res) {
	  console.log(admin.mountpath); // /admin
	  res.send('Admin abc/bcd Homepage');
});


var cb0 = function (req, res, next) {
	  console.log('CB0');
	  next();
}

var cb1 = function (req, res, next) {
  console.log('CB1');
  next();
}

var cb2 = function (req, res) {
  res.send('Hello from C!');
}

admin.get('/example/c', [cb0, cb1, cb2]);

module.exports.admin = admin;