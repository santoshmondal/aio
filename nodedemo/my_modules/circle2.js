const PI = Math.PI;

exports.area = (r) =>  PI * r * r;
exports.circumference = (r) => 2 * PI * r;


exports.test = function(r){
	return PI * r * r;
}

exports.test1 = (r) => {
	return PI * r * r;
}