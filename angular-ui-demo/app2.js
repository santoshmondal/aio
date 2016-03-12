var express = require('express');
var multer = require('multer');
var bodyParser = require('body-parser');
var fs = require('fs');

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

 
 
var Grid = require('gridfs-stream');
Grid.mongo = mongoose.mongo;

var app = express();
var upload = multer({ dest: 'uploads/' });

app.post("/uploads", upload.single('pic'), function(req, res,next) {
	console.log(req.body);
	console.log(req.file);
	
	console.log();
	var dirname = require('path').dirname(__filename);
    var path = req.file.path;
	
	var reqjson = req.body;
	var reqfile = req.file;
	
	mongoose.connect('mongodb://127.0.0.1/test1');
	var conn = mongoose.connection;
	conn.once('open', function () {
	    console.log('open');
	    var gfs = Grid(conn.db);
	    var writestream = gfs.createWriteStream({
	        'filename': reqfile.originalname,
	        "metadata" : reqfile
	        
	    });
	    
	    console.log(dirname + "/" + path);
	    fs.createReadStream(dirname + "/" + path).pipe(writestream);
	 
	    writestream.on('close', function (file) {
	        console.log(file.filename + 'Written To DB');
	    });
	});
	
	console.log(reqfile);
	res.json(reqfile);
});


app.listen(4000, function(){
	console.log("hello world Test!!!");
});
