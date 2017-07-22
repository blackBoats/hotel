UserApp.service('userService',['$rootScope','$http',function($rootScope,$http){
	
	var service = {
		//登录
		customer: {},
		rooms: {},
		rooms1: {},
		rooms2: {},
		rooms3: {},
		rooms4: {},
		rooms5: {},
		logout: function(){
			return $http.get('customer/logout');
		},
		init: function(){
			return $http.get('/customer/init');
		},
		initImage: function(){
			return $http.get('/image/listAll');
		},
		initRoom: function(){
			return $http.get('/findByUnStatus');
		}
	}
	return service;
}]);
UserApp.service('indexService',['$rootScope','$http',function($rootScope,$http){
	
	var service = {
		goReview: function(){
			return $http.get("http://localhost:8080/review");
		}
	}
	return service;
}]);
UserApp.service('reviewService',['$rootScope','$http',function($rootScope,$http){
	
	var service = {
		onSave: function(review){
			return $http.post("/review/save",review);
		}
	}
	return service;
}]);
UserApp.service('reserveService',['$rootScope','$http',function($rootScope,$http){
	
	var service = {
		onReserve: function(order){
			return $http.post("/order/create",order);
		},
		getCheckCode: function(phoneNumber){
			return $http.get("/customer/checkCode/"+phoneNumber);
		},
		validCheckCode: function(checkCode){
			return $http.get("/customer/valid/"+checkCode);
		}
	}
	return service;
}]);
UserApp.service('updateCustomerService',['$rootScope','$http',function($rootScope,$http){
	
	var service = {
		
	}
	return service;
}]);
UserApp.service('detailOrderService',['$rootScope','$http',function($rootScope,$http){
	
	var service = {
		findOrderByPhone: function(phoneNumber){
			return $http.get('/order/findOrderByPhone/'+phoneNumber);
		}
	}
	return service;
}]);