var backApp = angular.module('backApp',['ngRoute'])
    .config(['$routeProvider',function($routeProvider){
    	$routeProvider
    	.when('/order', {
    		templateUrl: 'order',
    		controller: 'orderCtrl'
    	})
    	.when('/addOrder', {
    		templateUrl: 'addOrder',
    		controller: 'addOrderCtrl'
    	})	
    	.when('/showOrder', {
    		templateUrl: 'showOrder',
    		controller: 'showOrderCtrl'
    	})
    	.when('/user', {
    		templateUrl: 'user',
    		controller: 'userCtrl'
    	})
    	.when('/updateUser', {
    		templateUrl: 'updateUser',
    		controller: 'updateUserCtrl'
    	})
    	.when('/image', {
    		templateUrl: 'imageing',
    		controller: 'imageCtrl'
    	})
    	.when('/updateImage', {
    		templateUrl: 'updateImage',
    		controller: 'updateImageCtrl'
    	})
    	.when('/addImage', {
    		templateUrl: 'addImage',
    		controller: 'addImageCtrl'
    	})
    	.when('/room', {
    		templateUrl: 'room',
    		controller: 'roomCtrl'
    	})
    	.when('/updateRoom', {
    		templateUrl: 'updateRoom',
    		controller: 'updateRoomCtrl'
    	})
    	.when('/addRoom', {
    		templateUrl: 'addRoom',
    		controller: 'addRoomCtrl'
    	})
    	.when('/employee',{
    		templateUrl: 'employee',
    		controller:  'employeeCtrl'
    	})
    	.when('/addEmployee',{
    		templateUrl: 'addEmployee',
    		controller: 'addEmployeeCtrl'
    	})
    	.when('/updateEmployee',{
    		templateUrl: 'updateEmployee',
    		controller: 'updateEmployeeCtrl'
    	})
    	.when('/account',{
    		templateUrl: 'account',
    		controller: 'accountCtrl'
    	})
    	.when('/addAccount',{
    		templateUrl: 'addAccount',
    		controller: 'addAccountCtrl'
    	})
    	.when('/updateAccount',{
    		templateUrl: 'updateAccount',
    		controller: 'updateAccountCtrl'
    	})
    	.when('/question', {
    		templateUrl: 'question',
    		controller: 'questionCtrl'
    	})
    	.when('/review', {
    		templateUrl: 'backReview',
    		controller: 'reviewCtrl'
    	})
    	.when('/select', {
    		templateUrl: '/select',
    		controller: 'selectCtrl'
    	})
    	.otherwise({
    		redirectTo: '/room'
    	});
    }]);