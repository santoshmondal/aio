/**
 * http://usejsdoc.org/
 */
var express=require('express');
var mongoose = require('mongoose');

var blogschema=require('./blogs');
var router = express.Router();

// Models
var Blog = mongoose.model('Blog');
var Comment = mongoose.model('Comment');


router.get("/blog", function(req, res){
	var blog = new Blog({'title':'Hello Universe!!'});
	blog.save();
	
	res.json(blog);
});


router.get("/comment", function(req, res){
	var comment = new Comment({'_id':'1', 'comment':'Hello Universe, comment!!'});
	comment.save();
	
	res.json(comment);
});


module.exports = router;