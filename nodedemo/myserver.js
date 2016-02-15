/**
 * http://usejsdoc.org/
 */
var http = require('http');

var requestListener = function(req, res) {
	res.writeHead("200", {"Context-Type":"text/plain"});
	res.write("request server :: " + new Date());
	res.end();
};

http.createServer(requestListener).listen("8081");
