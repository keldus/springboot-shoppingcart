(function(){
	var app = angular.module('shopping', []);

	var shoppingController = function($scope, $http){
		$http.get('/api/v1/items').then(function(response) {
	    	console.log(response.data)
	      	$scope.items = response.data;
	    })
	}  

	app.controller('shoppingController', shoppingController)
}());