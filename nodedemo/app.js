var first = require('./my_modules/first');
var second = require("./my_modules/second");
var circle = require("./my_modules/circle");
var circle2 = require('./my_modules/circle2.js');



// MODULE_FIRST
first.first();
console.log(first.first1());

// MODULE_SECOND
second.method2();
console.log(second.method21());

// MODULE CIRCLE
console.log(circle.area1(2));
console.log(circle.area2(3));

// MODULE circle2
console.log(circle2.test(4));
console.log(circle2.test1(5));

