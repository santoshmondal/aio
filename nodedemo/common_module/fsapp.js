/**
 * http://usejsdoc.org/
 */
var fs = require("fs");

fs.writeFileSync("fsdemo.txt", "Some dummy text");

fs.writeFile("test.txt", "testt", function(err, data){
	console.log(err);
	console.log(data);
});