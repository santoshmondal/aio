const PI = Math.PI;

// exports.area = (r) =>  PI * r * r;
// exports.circumference = (r) => 2 * PI * r;

module.exports = {
	area1 : function(r) {
		return PI * r * r;
	}, 
	circumference1 : function(r) {
		return 2 * PI * r;
	}
};


module.exports.area2 = function(r) {
	return PI * r * r;
};

module.exports.circumference2 =  function(r) {
	return 2 * PI * r;
};
