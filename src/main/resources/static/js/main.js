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
	    });
	    $scope.addToCart = function(item){
	    	$http.post('/api/v1/cart/add/'+item.id).then(function(response) {
		      	if(response.data){
		      		alert("Item added to cart!");
		      	}else{
					alert("Item failed to add to cart!");
		      	}
		    })
	    }
	});

	app.controller("itemCtrl", function ($scope, $routeParams, $http) {
		$http.get('/api/v1/items/'+$routeParams.id).then(function(response) {
	      	$scope.item = response.data;
	    });
	    $scope.addToCart = function(item){
	    	$http.post('/api/v1/cart/add/'+item.id).then(function(response) {
		      	if(response.data){
		      		alert("Item added to cart!");
		      	}else{
					alert("Item failed to add to cart!");
		      	}
		    })
	    }
	});

	app.controller("cartCtrl", function ($scope, $http) {
		$http.get('/api/v1/cart').then(function(response) {
	      	$scope.cart = response.data;
	      	$scope.total = 0.00;
	      	jQuery.each(response.data, function(key,value){
	      		$scope.total += value.item.price;
	      	})
	    })

	    $scope.change = function(item) {
	    	$http.put('/api/v1/cart/update', item).then(function(response) {
		      	if(response.data){
		      		alert("Quantity update successful!");
		      	}else{
					alert("Quantity update failed!");
		      	}
		    })
	    };

	    $scope.removeFromCart = function(item){
	    	$http.delete('/api/v1/cart/remove/'+item.id, item).then(function(response) {
		      	if(response.data){
		      		$scope.total = Math.round($scope.total - item.item.price* 100) / 100;
		      		$("#cartItem-"+item.id).remove();
		      		alert("Item removed!");
		      	}else{
					alert("Item removal failed!");
		      	}
		    })
	    }
	});
}());