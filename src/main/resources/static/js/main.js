(function(){
	var app = angular.module('shopping', ['ngRoute']);

	app.config(function($routeProvider) {
	    $routeProvider
	    .when("/", {
	        templateUrl : "catalog.html",
	        controller : "catalogCtrl"
	    })
	    .when("/items/:id", {
	        templateUrl : "item.html",
	        controller : "itemCtrl"
	    })
	    .when("/cart", {
	        templateUrl : "cart.html",
	        controller : "cartCtrl"
	    })
	});

	app.controller("catalogCtrl", function ($scope, $http) {
		$http.get('/api/v1/items').then(function(response) {
	      	$scope.items = response.data;
	    })
	});

	app.controller("itemCtrl", function ($scope, $routeParams, $http) {
		$http.get('/api/v1/items/'+$routeParams.id).then(function(response) {
	      	$scope.item = response.data;
	    })
	});

	app.controller("cartCtrl", function ($scope, $http) {
		$http.get('/api/v1/cart').then(function(response) {
	      	$scope.items = response.data;
	    })
	});
}());