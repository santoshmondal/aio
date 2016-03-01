/**
 * http://usejsdoc.org/
 */
var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var blogSchema = new Schema({
  title:  String,
  author: String,
  body:   String
});

var commentSchema = new Schema({
	  '_id' : String,
	  comment:  String,
	  author: String,
	  body:   String
});

mongoose.model('Blog', blogSchema);
mongoose.model('Comment', commentSchema);


