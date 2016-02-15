/**
 * http://usejsdoc.org/
 */
var path = require("path");

var webpath = "desktop//test/aa/bb/c.json";

var nwebpath = path.normalize(webpath);
console.log(nwebpath);
