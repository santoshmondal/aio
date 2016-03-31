/**
 * http://usejsdoc.org/
 */
var nonblock ={};

nonblock.APP_NAME = "Non Blocking Programming...";

nonblock.testp=function(){
	setTimeout(function(){
		return {"msg" : "Waited 5 Seconds"};
	}, 5000);
};

nonblock.testp1 = function(callback) {
	setTimeout(function(){
		callback(null, "NODE1");
	}, 1000);
}

nonblock.testp2 = function(callback) {
	setTimeout(function(){
		callback(null, "NODE2");
	}, 2000);
}


module.exports = nonblock;