/**
 * http://usejsdoc.org/
 */
var express = require('express');
var birds = require('./birds');
var cow = require('./cow');

var app = new express();

app.use("/birds", birds);
app.use("/cow", cow);

// start the server
app.listen(3000);