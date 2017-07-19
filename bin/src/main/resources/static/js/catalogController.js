(function(){
	var app = angular.module('shopping');

	var catalogController = function($http){
		var self = this;
	    $http.get('/catalog').then(function(response) {
	    	console.log(response.data)
	      	self.catalog = response.data;
	    })
	}  

	app.controller('catalogController', catalogController)
}());