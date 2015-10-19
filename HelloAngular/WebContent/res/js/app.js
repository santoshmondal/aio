// APPLICATION JS FILE
var app = angular.module("app", []);

app.controller("firstController", function($scope){
	$scope.name = "ANGULAR";
	$scope.ref = "JavaScript";
});


app.controller("secondController", function($scope){
	$scope.person = {
		"name" : "TOPICS",
		"fname" : "GURUS"
	};
});