(function(){
	var app = angular.module('shopping', []);

	var shoppingController = function($http){
		$http.get('/catalog').then(function(response) {
	    	console.log(response.data)
	      	self.catalog = response.data;
	    })
	}  

	app.controller('shoppingController', shoppingController)
}());