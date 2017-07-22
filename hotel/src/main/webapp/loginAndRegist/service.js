app.service('customerService',['$rootScope','$http',function($rootScope,$http){
	var service = {}
	 
}]);
app.service('registService',['$rootScope','$http',function($rootScope,$http){
	
	 var service = {
	 	onSave: function(customer){
	 		return $http.post('customer/registing',customer);
	 	},
	 	onLogin: function(customer){
	 		return $http.post('customer/logining',customer);
	 	}
	 }
	 return service;
}]);
