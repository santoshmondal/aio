/**
 * http://usejsdoc.org/
 */
var express=require('express');
var mongoose=require('mongoose');

var routedbs=require('./sampledbs/routedbs');


mongoose.connect('mongodb://localhost/test1');



var app = express();
app.use(express.static('public'));



// Middleware APIS
app.use('/rest', routedbs);


app.listen(3000, function(){
	console.log("Started...!!");
});