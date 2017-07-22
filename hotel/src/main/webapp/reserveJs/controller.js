reserveApp.controller("step1Ctrl",['$scope','$http','$location',function($scope,$http,$location){
		
		
		
		//初始化select的选项
		$scope.optionNumber = [];
		$scope.init = function(){
		
		for(var i=1;i<=10;i++){
			var s  = { number : i}
			$scope.optionNumber.push(s);
		}
	     }
		//初始化房间数量为1
		$scope.list = [1];
		
		/*判断选择的房间数量*/
		
		$scope.selectRoom = function(roomNumber){
			console.log(roomNumber);
			var num = roomNumber.number;
			$scope.list = [];
			for(var i=1;i<=num;i++){
				$scope.list.push(i);
			}
		}
		//获取预订的房间人的姓名
		$scope.names = [];
		$scope.saveRoom = function(username){
			console.log(username);
			$scope.names.push(username);
			console.log($scope.names);
			
		}
		
		//获得预订电话和到店时间
		$scope.step1Reserve = function(vo){
			console.log($scope.names);
			console.log(vo);
			$location.url("/step2");
		};
		
        $scope.init();
	
}]);

reserveApp.controller('step2Ctrl',['$scope','$http',function($scope,$http){
	     
	   
}]);


