var app = angular.module("app",[]);
app.controller("roomController",['$scope','$http',function($scope,$http){
	  
	  $http.get("http://localhost:8080/json/room.json").success(function(data){
//	  	$scope.items = data;
	  	
	  	$scope.items = data.rooms;
	  }).error(function(error){
	  	alert("错了？"+error);
	  });
	  $scope.reserve = function(item){
	  	console.log(item);	
	  }
	  

	  
}]);
app.controller('aadd',['$scope',function($scope){
	$scope.datee1 = new Date().format("yyyy-mm-dd");
	console.log($scope.datee1);
	var date = new Date(); 
	console.log(date);
	$scope.login = function(){
        var dd = document.getElementById("dt").value;
        console.log(dd);
       
	      var dts = document.getElementById("dts").value;
	       console.log(dts);
	};
}]);
