//UserApp.controller("loginCtrl",['$scope','$http','userService',function($scope,$http,userService){
//		
//		$scope.login = function(customer){
//			console.log(customer);
//			userService.onLogin(customer).success(function(data){
//				console.log(data);
//			}).error(function(error){
//				alert("错了？"+error);
//			});
//		}
//}]);
//
//UserApp.controller('registCtrl',['$scope','$http','userService',function($scope,$http,userService){
//	     
//	     $scope.regist = function(customer){
//	     	console.log(customer);
//	     	userService.onRegist(customer).success(function(data){
//	     		console.log(data);
//	     	}).error(function(error){
//	     		alert(error);
//	     	});
//	     }
//}]);

UserApp.controller("mainCtrl",['$scope','$http','$location','userService',function($scope,$http,$location,userService){
	$scope.detailCustomer = function(id){
		$location.path('updateCustomer')
	}
	$scope.detailOrder = function(id){
		$location.path('detailOrder');
	}
	$scope.init = function(){
		userService.init().success(function(data){
			console.log(data);
			$scope.customer = data;
		}).error(function(error){
			console.log(error);
		});
		userService.initImage().success(function(data){
			$scope.images = data;
			$scope.topImage = new Array();
			$scope.mainImage = new Array();
			for(var i=0;i<$scope.images.length;i++){
				if($scope.images[i].level == '1'){
					$scope.firstImage = $scope.images[i];
				}
				if($scope.images[i].level == '2'){
					$scope.topImage.push($scope.images[i]);
				}
				if($scope.mainImage.length<6){
					if($scope.images[$scope.images.length-1-i].level == '3'){
						$scope.mainImage.push($scope.images[$scope.images.length-1-i]);
					}
				}
			}
		}).error(function(error){
			console.log(error);
		});
		userService.initRoom().success(function(data){
			$scope.rooms1 = new Array();
			$scope.rooms2 = new Array();
			$scope.rooms3 = new Array();
			$scope.rooms4 = new Array();
			$scope.rooms5 = new Array();
			for(var i = 0; i<data.length; i++){
				if(data[i].roomType=='经济房'){
					$scope.rooms1.push(data[i]);
				}
				if((data[i].bedType=='单人床')&&(data[i].roomType=='标准房')){
					$scope.rooms2.push(data[i]);
				}
				if((data[i].bedType=='双人床')&&(data[i].roomType=='标准房')){
					$scope.rooms3.push(data[i]);
				}
				if((data[i].bedType=='单人床')&&(data[i].roomType=='商务房')){
					$scope.rooms4.push(data[i]);
				}
				if((data[i].bedType=='双人床')&&(data[i].roomType=='商务房')){
					$scope.rooms5.push(data[i]);
				}
			}
			userService.rooms1 = $scope.rooms1;
			userService.rooms2 = $scope.rooms2;
			userService.rooms3 = $scope.rooms3;
			userService.rooms4 = $scope.rooms4;
			userService.rooms5 = $scope.rooms5;
		}).error(function(error){
			console.log(error);
		})
	}
	$scope.reviewTo = function(){
		console.log("dd");
		$location.path('/review/');
//		indexService.goReview();
	}
	$scope.logout = function(){
		userService.logout().success(function(data){
			console.log(data);
			$scope.init();
		}).error(function(error){
			console.log(error);
		});
	}
	$scope.customer = userService.customer;
//	$scope.customer.password = "ddd";
//	$http.get("http://localhost:8080/json/room.json").success(function(data){
////	  	$scope.items = data;
//	  	
//	  	$scope.items = data.rooms;
//	  }).error(function(error){
//	  	alert("错了？"+error);
//	  });
	  
	  //预订
	  $scope.reserve = function(item){
	  	console.log($location.absUrl());	
	    $location.path("/background#/regist");
	  	
	  }
	  
	  $scope.reserveRoom = function(rooms){
        userService.rooms = rooms;
        $location.path('step1');
	  }
	  $scope.init();
}]);

UserApp.controller('reviewCtrl',['$scope','$http','reviewService','$location',function($scope,$http,reviewService,$location){
    console.log("dd");
    $scope.questions = ['酒店相关','页面问题'];
    $scope.saveReview = function(review){
      var res = verifyCode.validate(document.getElementById("code_input").value);
			if(res){
			reviewService.onSave(review).success(function(){
			console.log("success");
			alert("提交成功");
			$location.path("main");
			}).error(function(error){
				console.log("提交失败");
			})
			}else{
				alert("验证码错误");
			}	
		
	}
}]);
/*UserApp.controller('aadd',['$scope',function($scope){
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
}]);*/

UserApp.controller('reserveStep1Ctrl',['$scope','$http','$filter','userService','reserveService',function($scope,$http,$filter,userService,reserveService){
	//初始化select的选项
		$scope.optionNumber = [];
		$scope.rooms = userService.rooms;
		
		console.log($scope.rooms[0]);
		$scope.totalMoney = $scope.rooms[0].roomPrice;
		$scope.onePrice = $scope.rooms[0].roomPrice;
		$scope.numbers = 1;
		$scope.totalDays = 1;
		$scope.init = function(){
		for(var i=1;i<=5;i++){
			var s  = { number : i}
			$scope.optionNumber.push(s);
			console.log($scope.optionNumber);
		}
	     }
		
		
		//初始化房间数量为1
		$scope.list = [1];
		
		/*判断选择的房间数量*/
		
		$scope.selectRoom = function(roomNumber){
			console.log(roomNumber);
			if(roomNumber.number>$scope.rooms.length){
				alert("总房间数量只有"+$scope.rooms.length);
			}
			var num = roomNumber.number;
			$scope.list = [];
			for(var i=1;i<=num;i++){
				$scope.list.push(i);
			}
			$scope.numbers = roomNumber.number;
	     	$scope.totalMoney = $scope.onePrice*$scope.numbers*$scope.totalDays;
		}
//		//获取预订的房间人的姓名
//		$scope.names = [];
//		$scope.saveRoom = function(username){
//			console.log(username);
//			$scope.names.push(username);
//			console.log($scope.names);
//			
//		}
		
		//获得预订电话和到店时间
		$scope.step1Reserve = function(vo){
			console.log(vo);
			$scope.order.price = $scope.rooms[0].roomPrice;
			$scope.order.roomName = $scope.rooms[0].roomName;
			$scope.order.inTime = vo.inTime;
			$scope.order.outTime = vo.outTime;
			$scope.order.userName = vo.userName;
			$scope.order.phoneNumber = vo.phoneNumber;
			var checkCode = vo.checkCode;
			reserveService.validCheckCode(checkCode).success(function(data){
				console.log(data);
				if(data=="success"){
				reserveService.onReserve($scope.order).success(function(){
				alert("预订成功");
				$location.path("main");
		    	}).error(function(error){
			 	alert("预订失败");
			    });
			   }else{
			   	alert("手机验证码验证失败");
			   }
			}).error(function(error){
				alert("手机验证码验证失败");
			})
//			$scope.order.bedType = $scope.rooms[0].bedType;
//			$scope.order.roomType = $scope.rooms[0].roomType;
			
			console.log($scope.order);
			
		};
		$scope.getCheckCode = function(phoneNumber){
			console.log(phoneNumber);
			if(phoneNumber==undefined){
				alert("请输入电话号码");
			}
			var res = verifyCode.validate(document.getElementById("code_input").value);
			if(res){
				reserveService.getCheckCode(phoneNumber).success(function(data){
				console.log("success");
				}).error(function(){
				console.log("error");
				});
			}else{
				alert("验证码错误");
			}
		}
		var time = new Date();
	    var temp = new Date();
	    var tempTime = new Date();
	    $scope.inTimes = new Array();
	    for(i=-1;i<5;i++){
	    	if(i>0){
	    	time.setDate(time.getDate()+1);
	    	$scope.inTimes.push($filter('date')(time,"yyyy年MM月dd日"));
	    	}else if(i==0){
	    	time.setDate(time.getDate());
	    	$scope.inTimes.push($filter('date')(time,"yyyy年MM月dd日"));
	    	}else{
	    	temp.setDate(temp.getDate()+i);
	    	$scope.inTimes.push($filter('date')(temp,"yyyy年MM月dd日"));	
	    	}
	    }
	    
	    $scope.typeRooms = [
	    "经济房","标准房","商务房"];
	    
	    $scope.outTimes = new Array();
	    console.log($filter('date')(tempTime,"yyyy年MM月dd日"));
	    for(i=0;i<15;i++){
	    	if(i>0){
	    	tempTime.setDate(tempTime.getDate()+1);
	    	$scope.outTimes.push($filter('date')(tempTime,"yyyy年MM月dd日"));
	    	}else{
	    	tempTime.setDate(tempTime.getDate()+0);
	    	$scope.outTimes.push($filter('date')(tempTime,"yyyy年MM月dd日"));	
	    	}
	    }
	    $scope.selectinTime = function(inTime){
	    	if($scope.order.inTime != "" && $scope.order.outTime != ""){
	    		var inTimeArr = $scope.order.inTime.split("");
	    		var outTimeArr = $scope.order.outTime.split("");
	    		var inTime = parseInt(inTimeArr[inTimeArr.length-3]+inTimeArr[inTimeArr.length-2]);
	    		var outTime = parseInt(outTimeArr[outTimeArr.length-3]+outTimeArr[outTimeArr.length-2]);
	    		if((outTime-inTime) != 0){
	    		$scope.totalDays = outTime-inTime;
	    		$scope.totalMoney = $scope.onePrice*$scope.totalDays*$scope.numbers;
	    		}else{
	    			$scope.totalMoney = $scope.onePrice;
	    		}
	    	}else{
	    		$scope.totalMoney = $scope.onePrice;
	    	}
	    }
	     $scope.selectoutTime = function(inTime){
        	if($scope.order.inTime != "" && $scope.order.outTime != ""){
	    		var inTimeArr = $scope.order.inTime.split("");
	    		var outTimeArr = $scope.order.outTime.split("");
	    		var inTime = parseInt(inTimeArr[inTimeArr.length-3]+inTimeArr[inTimeArr.length-2]);
	    		var outTime = parseInt(outTimeArr[outTimeArr.length-3]+outTimeArr[outTimeArr.length-2]);
	    		if((outTime-inTime) != 0){
	    			$scope.totalDays = outTime-inTime;
	    		    $scopetotalMoney = $scope.onePrice*$scope.totalDays*$scope.numbers;
	    		}else{
	    			$scope.totalMoney = $scope.onePrice;
	    		}
	    	}else{
	    		$scope.totalMoney = $scope.onePrice;
	    	}
	     }
        $scope.init();
}]);
UserApp.controller('indexCtrl',['$scope','$http','indexService','$location',function($scope,$http,indexService,$location){
	$scope.reviewTo = function(){
		console.log("dd");
		$location.path('/review/');
//		indexService.goReview();
	}
}]);
UserApp.controller('updateCustomerCtrl',['$scope','$http','updateCustomerService','$location',function($scope,$http,updateCustomer,$location){
	
}]);
UserApp.controller('detailOrderCtrl',['$scope','$http','detailOrderService','$location',function($scope,$http,detailOrderService,$location){
	$scope.orders = [];
	$scope.getOrder = function(phoneNumber){
		console.log(phoneNumber);
		detailOrderService.findOrderByPhone(phoneNumber).success(function(data){
			$scope.orders = data;
		}).error(function(error){
			alert("无相关信息");
		});
	}
	$scope.refreshPage = function(){
		$location.path('detailOrder');
	}
}]);

