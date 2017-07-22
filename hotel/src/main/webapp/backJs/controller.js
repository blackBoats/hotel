backApp.controller("limitCtrl",['$scope','$http','$location','backService',function($scope,$http,$location,backService){
    $scope.logout = function(){
    	console.log("out");
    	$http.get('/employee/logout').success(function(data){
    		$scope.init();
			window.location.reload();
    	}).error(function(error){
    		alert("出现位置错误");
    	})
    }
    $scope.init = function(){
    	$http.get('/employee/init').success(function(data){
    		console.log(data);
    		$scope.user = data;
    		console.log(data.name);
    	}).error(function(error){
    		console.log(error);
    	});
    }
    $scope.init();
}]);
backApp.controller("addImageCtrl",['$scope','$http','$location','addImageService',function($scope,$http,$location,addImageService){
	$scope.createImage = function(image){
	var fd = new FormData();
	console.log(fd);
	console.log(image);
    var fil = document.querySelector('input[type=file]').files[0];
    fd.append('load',fil);
    fd.append('typeBed',image.typeBed);
     fd.append('typeRoom',image.typeRoom);
    fd.append('imageDescription',image.imageDescription);
    fd.append('level',image.level);
    console.log(fil);
    console.log(fd);
    addImageService.saveImage(fd).success(function(success){
    	alert("上传成功");
    }).error(function(error){
    	alert("上传失败");
    })
	 }
	$scope.levels = ['1','2','3'];
}]);
backApp.controller("imageCtrl",['$scope','$http','$location','imageService','backService','$location',
         function($scope,$http,$location,imageService,backService,$location){
    $scope.uploadImage = function(){
    	$location.path('addImage');
    }
    
    $scope.deleteImage = function(id){
    	imageService.deleteImage(id).success(function(data){
    		alert("删除成功");
    		$scope.init();
    	}).error(function(error){
    		alert("删除失败");
    	});
    }
    
    $scope.updateImage = function(imagee){
    	backService.imagee = imagee;
    	$location.path('updateImage');
    }
	/*初始化表格数据*/
	$scope.init = function(){
		imageService.findAll().success(function(data){
			console.log(data);
	        $scope.images = data;
	     	$scope.pages = backService.initPages($scope.images);
	     	$scope.index = 1;
	        $scope.indexPage = $scope.pages[$scope.index-1];
	        $scope.listPage = backService.initListPage($scope.pages);
		}).error(function(error){
			console.log(error);
		});
	}
	$scope.selectPage = function(list){
	  	    $scope.index = list;
	  	    $scope.indexPage = $scope.pages[list-1];
	    };
	    
	//上一页
	$scope.prePage = function(){
	  	    if($scope.index>1){
	  	  	   $scope.index--;
	  	  	   $scope.indexPage = $scope.pages[$scope.index-1];
	  	     }else{
	  	         }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	    }
	  	
	  	$scope.nextPage = function(){
	  	    var s = $scope.listPage.length;
	  	    var max = $scope.listPage[$scope.listPage.length-1];
	  	    if($scope.index<$scope.listPage[$scope.listPage.length-1]){
	  	     	$scope.index++;
	  	  	    $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	  }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	  	}
	  	
	  	$scope.jumpTo = function(index){
	  	    if(index<1){
	  	    	$scope.index = 1;
	  	    	$scope.indexPage = $scope.pages[0];
	  	    }else if(index<$scope.pages.length){
	  	    	$scope.index = index;
	  	        $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	    	$scope.index = $scope.pages.length;
	  	    	$scope.indexPage = $scope.pages[$scope.pages.length-1];
	  	    }
	    }
	  	$scope.init();
}]);
backApp.controller("updateImageCtrl",['$scope','$http','imageService','$location','backService',
    function($scope,$http,imageService,$location,backService){
    	$scope.image = backService.imagee;
    	console.log($scope.image);
    	$scope.levels = ['1','2','3'];
    	$scope.updateImage = function(imagee){
    		console.log(imagee);
    		imageService.updateImage(imagee).success(function(data){
    			alert("修改成功");
    		}).error(function(error){
    			alert("修改失败");
    		})
    	}
    	$scope.returnPage = function(){
    		$location.path('image');
    	}
 }]);  	
//订单的控制器
backApp.controller("orderCtrl",['$scope','$http','orderService','$location','backService','$filter',
    function($scope,$http,orderService,$location,backService,$filter){
    	 $scope.createOrder = function(order){
	    	console.log(order);
	    	orderService.createOrder(order).success(function(){
	    		$scope.initPage();
	    	}).error(function(error){
	    		console.log(error);
	    	});
	    }
    	$scope.updateOrder = function(order){
    		console.log(order);
    		$scope.order = order;
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
	    
	    $scope.reserveStatus = ["已预订","未预订"];
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
	    /****************************/
	    $scope.searchOrder = function(roomName){
	    	
	    	orderService.findByRoomName(roomName).success(function(data){
	    		$scope.orders    = data;
			  	$scope.pages     = backService.initPages($scope.orders);
			    $scope.init();
			    $scope.listPage  = backService.initListPage($scope.pages);
	    	}).error(function(error){
	    		alert("没有查询到相关数据");
	    	});
	    }
	    $scope.addOrder = function(){
	    	$location.path('room');
	    }
	    /**************当选择框为所有订单时*************/
	    $scope.selectStatus = function(status){
	    	if(status == '所有订单'){
	    		orderService.queryAll().success(function(data){
	    			$scope.orders     = data;
	    			$scope.pages      = backService.initPages($scope.orders);
				    $scope.init();
				    $scope.listPage   = backService.initListPage($scope.pages);
	    			
	    		}).error(function(error){
	    			alert("初始化数据失败");
	    		});
	    	}else if(status == '预订中'){
	    		orderService.queryOrderStatus().success(function(data){
			  	$scope.orders = data;
			  	$scope.pages = backService.initPages($scope.orders);
			    $scope.init();
			    $scope.listPage = backService.initListPage($scope.pages);
	    		}).error(function(error){
	    			alert("初始化数据失败");
	    		});
	    	}else if(status == '已预订'){
	    		orderService.queryOrderUnStatus().success(function(data){
			  	$scope.orders = data;
			  	$scope.pages = backService.initPages($scope.orders);
			    $scope.init();
			    $scope.listPage = backService.initListPage($scope.pages);
	    	 }).error(function(){
	    	 	alert("初始化数据失败");
	    	});
	    	}
	    }
	    /**********保存订单**********/
	   $scope.saveOrder = function(order){
	   	orderService.saveOrder(order).success(function(){
	   		alert("保存成功");
	   		$scope.initPage();
	   	}).error(function(error){
	   		alert("保存失败");
	   	});
	   }
	    //初始化
	    $scope.typeOrders = ["所有订单","预订中","已预订"];
	    $scope.initPage = function(){
	    orderService.queryOrderStatus().success(function(data){
	  	$scope.orders = data;
	  	$scope.pages = backService.initPages($scope.orders);
	    $scope.init();
	    $scope.listPage = backService.initListPage($scope.pages);
	  	}).error(function(error){
	  	  	alert("请求错误");
	  	});
	  	}
	    $scope.init = function(){
	     	$scope.index = 1;
	        $scope.indexPage = $scope.pages[$scope.index-1];
	    }
	    $scope.selectPage = function(list){
	  	    $scope.index = list;
	  	    $scope.indexPage = $scope.pages[list-1];
	    };
	    
	     //上一页
	    $scope.prePage = function(){
	  	    if($scope.index>1){
	  	  	   $scope.index--;
	  	  	   $scope.indexPage = $scope.pages[$scope.index-1];
	  	     }else{
	  	         }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	    }
	  	
	  	$scope.nextPage = function(){
	  	    var s = $scope.listPage.length;
	  	    var max = $scope.listPage[$scope.listPage.length-1];
	  	    if($scope.index<$scope.listPage[$scope.listPage.length-1]){
	  	     	$scope.index++;
	  	  	    $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	  }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	  	}
	  	
	  	$scope.jumpTo = function(index){
	  	    if(index<1){
	  	    	$scope.index = 1;
	  	    	$scope.indexPage = $scope.pages[0];
	  	    }else if(index<$scope.pages.length){
	  	    	$scope.index = index;
	  	        $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	    	$scope.index = $scope.pages.length;
	  	    	$scope.indexPage = $scope.pages[$scope.pages.length-1];
	  	    }
	    }
	  	$scope.initPage();
}]);
backApp.controller("addOrderCtrl",['$scope','$http','$filter','addOrderService',function($scope,$http,$filter,addOrderService){
	
	$scope.typeRooms = [
	    "经济房","标准房","商务房"
	];
	
	$scope.typeBeds = ["单人床","双人床"];
	
	$scope.dates = new Date().format("yyyy-mm-dd");
	console.log($scope.dates);
	var s = $scope.dates.getDay;
	console.log(s);
	console.log($scope.dates);
	 
	$scope.selectRoomType = function(roomType){
		$scope.roomType = roomType;
		addOrderService.queryRoomByTypeRoom(roomType)
		    .success(function(data){
		    	console.log(data);
		 	    $scope.rooms = data;
		     }).error(function(error){
		     	
		     });
		     $scope.listRoom = $scope.rooms;
		    
	}
	
	$scope.selectTypeBed = function(bedType){
//		console.log($scope.roomType)
//		
//		addOrderService.queryRoomByTypeBed(bedType,$scope.roomType)
//		    .success(function(data){
//		    	console.log(data);
//		    	$scope.rooms = data;
//		    }).error(function(error){
//		    	
//		    })
         
        console.log($scope.rooms);
	}
	
}]);
backApp.controller("showOrderCtrl",['$scope','$http',function($scope,$http){
	
}]);
backApp.controller("questionCtrl",['$scope','$http',function($scope,$http){
	
}]);
backApp.controller("remarkCtrl",['$scope','$http',function($scope,$http){
	
}]);
backApp.controller("roomCtrl",['$scope','$http','roomService','backService','$filter','$location',
       function($scope,$http,roomService,backService,$filter,$location){
	    
	    $scope.typeRooms = [
	    "经济房","标准房","商务房"];
	     //初始化时间选择框
	    
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
	    
	    $scope.reserveStatus = ["已预订","未预订"];
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
	    $scope.initPage = function(){
	    roomService.queryRoomUnStatus().success(function(data){
	    	console.log(data);
	    	$scope.rooms = data;
	    	$scope.pages = backService.initPages($scope.rooms);
	    	$scope.init();
	    	$scope.listPage = backService.initListPage($scope.pages);
	    	}).error(function(error){
	    		console.log(error);
	    	});
	    }
	    
	    $scope.searchRoom = function(roomName){
	    	var status;
	    	console.log($scope.status=='未预订');
	    	if($scope.status=='未预订'){
	    		var status = 0;
	    	}else{
	    		var status = 1;
	    	}
	    	console.log(status);
	    	console.log($scope.status);
	    	roomService.searchRoom(roomName,status).success(function(data){
	    		console.log(data);
	    		$scope.rooms = data;
	    		$scope.pages = backService.initPages($scope.rooms);
		    	$scope.init();
		    	$scope.listPage = backService.initListPage($scope.pages);
	    	}).error(function(error){
	    		console.log(error);
	    	})
	    }
	    $scope.queryStatus = function(status){
	    	console.log(status);
	    	if(status==="未预订"){
	    		roomService.queryRoomUnStatus().success(function(data){
	    		$scope.rooms = data;	
	    		$scope.pages = backService.initPages($scope.rooms);
	    	    $scope.init();
	    	    $scope.listPage = backService.initListPage($scope.pages);
	    		console.log($scope.rooms);
	    	       }).error(function(error){
	    		console.log(error);
	    	    });
	    	}else{
	    		roomService.queryRoomStatus().success(function(data){
	    		$scope.rooms = data;
	    		$scope.pages = backService.initPages($scope.rooms);
	    	    $scope.init();
	    	    $scope.listPage = backService.initListPage($scope.pages);
	    		console.log($scope.rooms);
	    	}).error(function(error){
	    		console.log(error);
	    	});
	    	}
	    }
	    
	    $scope.init = function(){
	     	$scope.index = 1;
	        $scope.indexPage = $scope.pages[$scope.index-1];
	    }
	    $scope.selectPage = function(list){
	  	    $scope.index = list;
	  	    $scope.indexPage = $scope.pages[list-1];
	    };
	    
	     //上一页
	    $scope.prePage = function(){
	  	    if($scope.index>1){
	  	  	   $scope.index--;
	  	  	   $scope.indexPage = $scope.pages[$scope.index-1];
	  	     }else{
	  	         }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	    }
	  	
	  	$scope.nextPage = function(){
	  	    var s = $scope.listPage.length;
	  	    var max = $scope.listPage[$scope.listPage.length-1];
	  	    if($scope.index<$scope.listPage[$scope.listPage.length-1]){
	  	     	$scope.index++;
	  	  	    $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	  }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	  	}
	  	
	  	$scope.jumpTo = function(index){
	  	    if(index<1){
	  	    	$scope.index = 1;
	  	    	$scope.indexPage = $scope.pages[0];
	  	    }else if(index<$scope.pages.length){
	  	    	$scope.index = index;
	  	        $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	    	$scope.index = $scope.pages.length;
	  	    	$scope.indexPage = $scope.pages[$scope.pages.length-1];
	  	    }
	    }
	    
	    $scope.reserveRoom = function(room){
	    	$scope.order = new Object();	
	    	$scope.order.roomName = room.roomName;
	    	$scope.onePrice = room.roomPrice;
	    	$scope.order.price = room.roomPrice;
	    	$scope.order.inTime = "";
	    	$scope.order.outTime = 	"";
	    	$scope.order.roomType = room.roomType;
	    }
	    
	    $scope.selectinTime = function(inTime){
	    	if($scope.order.inTime != "" && $scope.order.outTime != ""){
	    		var inTimeArr = $scope.order.inTime.split("");
	    		var outTimeArr = $scope.order.outTime.split("");
	    		var inTime = parseInt(inTimeArr[inTimeArr.length-3]+inTimeArr[inTimeArr.length-2]);
	    		var outTime = parseInt(outTimeArr[outTimeArr.length-3]+outTimeArr[outTimeArr.length-2]);
	    		if((outTime-inTime) != 0){
	    		$scope.order.price = $scope.onePrice*(outTime-inTime);
	    		}else{
	    			$scope.order.price = $scope.onePrice;
	    		}
	    	}else{
	    		$scope.order.price = $scope.onePrice;
	    	}
	    }
	     $scope.selectoutTime = function(inTime){
        	if($scope.order.inTime != "" && $scope.order.outTime != ""){
	    		var inTimeArr = $scope.order.inTime.split("");
	    		var outTimeArr = $scope.order.outTime.split("");
	    		var inTime = parseInt(inTimeArr[inTimeArr.length-3]+inTimeArr[inTimeArr.length-2]);
	    		var outTime = parseInt(outTimeArr[outTimeArr.length-3]+outTimeArr[outTimeArr.length-2]);
	    		if((outTime-inTime) != 0){
	    		$scope.order.price = $scope.onePrice*(outTime-inTime);
	    		}else{
	    			$scope.order.price = $scope.onePrice;
	    		}
	    	}else{
	    		$scope.order.price = $scope.onePrice;
	    	}
	     }
	    $scope.createOrder = function(order){
	    	console.log(order);
	    	roomService.createOrder(order).success(function(){
	    		$scope.initPage();
	    	}).error(function(error){
	    		console.log(error);
	    	});
	    }
	    
	    //showDetailRoom 房间详细信息
	    $scope.showRoom = function(room){
            backService.room = room;
	    	$location.path('updateRoom');
	    }
	    /*********************/
	    $scope.addRoom = function(){
	    	$location.path('addRoom');
	    }
	    
	    $scope.updateRoom = function(room){
	    	$location.path('updateRoom');
	    	backService.room = room;
	    }
	    $scope.deleteRoom = function(id){
	    	roomService.deleteRoomById(id).success(function(data){
	    		alert("删除成功");
	    		$scope.init();
	    	}).error(function(error){
	    		alert("删除失败");
	    	});
	    }
	    $scope.initPage();
	    
}]);
backApp.controller("updateRoomCtrl",['$scope','$http','$filter','backService','updateRoomService',
        function($scope,$http,$filter,backService,updateRoomService){
	    console.log(backService.room);
	    $scope.room = backService.room;
	    $scope.typeRooms = [
	    "经济房","标准房","商务房"
	                ];
	             
	    $scope.typeBeds = ["单人床","双人床"];
	    /****************/
	   $scope.updateRoom = function(room){
	   	    updateRoomService.updateRoom(room).success(function(){
	   	    	console.log("success");
	   	    }).error(function(){
	   	    	
	   	    });
	   }
	   
	   $scope.deleteRoom = function(roomName){
	   	   updateRoomService.deleteRoom(roomName).success(function(){
	   	   	  console.log("success");
	   	   }).error(function(){
	   	   	
	   	   });
	   }
	    
}]);
backApp.controller("addRoomCtrl",['$scope','$http','$filter','backService','$location','addRoomService'
    ,function($scope,$http,$filter,backService,$location,addRoomService){
	    
	    $scope.addRoom = function(room){
	    	addRoomService.createRoom(room).success(function(){
	    		console.log("创建成功")
	    	}).error(function(error){
	    		alert("创建失败");
	    	})
	    }
	    $scope.cancel = function(){
	    	$location.path('room');
	    }
	    
}]);
backApp.controller("employeeCtrl",['$scope','$http','$filter','$location','backService','employeeService',
          function($scope,$http,$filter,$location,backService,employeeService){
	/*页面跳转到添加员工*/
	$scope.createEmployee = function(){
		$location.path('addEmployee');
	}
	$scope.searchEmployee = function(username){
		console.log(username);
		employeeService.searchEmployee(username).success(function(data){
			console.log(data);
			$scope.employees = data;
	     	$scope.pages = backService.initPages($scope.employees);
	     	$scope.index = 1;
	        $scope.indexPage = $scope.pages[$scope.index-1];
	        $scope.listPage = backService.initListPage($scope.pages);
		}).error(function(error){
			console.log(error);
		});
	}
	/*----------------*/
	$scope.deleteEmployee = function(id){
		console.log(id);
		employeeService.deleteEmployee(id).success(function(){
			alert("删除成功");
			$scope.init();
		}).error(function(error){
			alert("删除失败");
		});
	}
	/*----------------*/
	$scope.updateEmployee = function(employee){
		backService.employee = employee;
		$location.path('updateEmployee');
	}
	/*********************************/
	$scope.saveAccount = function(item){
		item.workMonth = new Date().getMonth()+1;
		item.realSalary = item.employeeSalary;
		console.log(item.workMonth);
		employeeService.createAccount(item).success(function(){
			console.log("success");
		}).error(function(error){
			console.log(error);
		});
		
		
	}
	
	/*初始化表格数据*/
	$scope.init = function(){
		employeeService.allEmployee().success(function(data){
			
	        $scope.employees = data;
	     	$scope.pages = backService.initPages($scope.employees);
	     	$scope.index = 1;
	        $scope.indexPage = $scope.pages[$scope.index-1];
	        $scope.listPage = backService.initListPage($scope.pages);
	       
			console.log(data);
		}).error(function(error){
			console.log(error);
		});
	}
	$scope.selectPage = function(list){
	  	    $scope.index = list;
	  	    $scope.indexPage = $scope.pages[list-1];
	    };
	    
	//上一页
	$scope.prePage = function(){
	  	    if($scope.index>1){
	  	  	   $scope.index--;
	  	  	   $scope.indexPage = $scope.pages[$scope.index-1];
	  	     }else{
	  	         }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	    }
	  	
	  	$scope.nextPage = function(){
	  	    var s = $scope.listPage.length;
	  	    var max = $scope.listPage[$scope.listPage.length-1];
	  	    if($scope.index<$scope.listPage[$scope.listPage.length-1]){
	  	     	$scope.index++;
	  	  	    $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	  }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	  	}
	  	
	  	$scope.jumpTo = function(index){
	  	    if(index<1){
	  	    	$scope.index = 1;
	  	    	$scope.indexPage = $scope.pages[0];
	  	    }else if(index<$scope.pages.length){
	  	    	$scope.index = index;
	  	        $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	    	$scope.index = $scope.pages.length;
	  	    	$scope.indexPage = $scope.pages[$scope.pages.length-1];
	  	    }
	    }
	  	$scope.init();
	
	
}]);
backApp.controller("addEmployeeCtrl",['$scope','$http','$filter','$location','addEmployeeService',function($scope,$http,$filter,$location,addEmployeeService){
	/*
	 * 初始化时间
	 */
	var time = new Date();
	var temp = new Date();
	    $scope.inTimes = new Array();
	    for(i=-1;i<7;i++){
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
	/*----------返回页面---------------*/
	$scope.returnPage = function(){
		console.log("d");
		$location.path('employee');
	}
	/*-----------保存employee信息--------*/
	$scope.createEmployee = function(employee){
		addEmployeeService.createEmployee(employee).success(function(){
			console.log("success");
		}).error(function(error){
			console.log(error);
		});
	}
}]);
backApp.controller("updateEmployeeCtrl",['$scope','$http','$filter','backService','updateEmployeeService','$location',function($scope,$http,$filter,backService,updateEmployeeService,$location){
	$scope.employee = backService.employee;
	console.log($scope.employee);
	
	$scope.updateEmployee = function(employee){
		console.log(employee);
		updateEmployeeService.updateEmployee(employee).success(function(data){
			alert("修改成功");
		}).error(function(error){
			alert("修改失败");
		});
	}
	
	$scope.returnPage = function(){
		$location.path('employee');
	}
}]);

backApp.controller("updateAccountCtrl",['$scope','$http','$filter','updateAccountService','backService','$location',
             function($scope,$http,$filter,updateAccountService,backService,$location){
             	
	$scope.returnPage = function(){
		$location.path('account');
	}
	
	$scope.account = backService.account;
	
	$scope.updateAccount = function(account){
		console.log(account);
		updateAccountService.updateAccount(account).success(function(data){
			alert("修改成功");
		}).error(function(error){
			alert("修改失败");
		})
	}
}]);
backApp.controller("accountCtrl",['$scope','$http','$filter','accountService','backService','$location',
             function($scope,$http,$filter,accountService,backService,$location){
	$scope.accountStatus = ['所有','支出','收入'];
	$scope.searchAcount = function(imageUsername){
		console.log("dd");
		accountService.findByLike(imageUsername).success(function(data){
			$scope.accounts = data;
	        for(var i = 0;i<$scope.accounts.length;i++){
	        	$scope.accounts[i].accountId = $scope.accounts[i].accountId+10000;
	        }
	     	$scope.pages = backService.initPages($scope.accounts);
	     	$scope.index = 1;
	        $scope.indexPage = $scope.pages[$scope.index-1];
	        $scope.listPage = backService.initListPage($scope.pages);
		}).error(function(error){
			console.log("无数据");
		});
	}
	$scope.queryStatus = function(status){
		if(status=='所有'){
			console.log("所有");
			accountService.listAll().success(function(data){
				$scope.accounts = data;
		        for(var i = 0;i<$scope.accounts.length;i++){
		        	$scope.accounts[i].accountId = $scope.accounts[i].accountId+10000;
		        }
		     	$scope.pages = backService.initPages($scope.accounts);
		     	$scope.index = 1;
		        $scope.indexPage = $scope.pages[$scope.index-1];
		        $scope.listPage = backService.initListPage($scope.pages);
			}).error(function(error){
				console.log("error");
			});
		}else if(status=='支出'){
			console.log('支出');
			accountService.findByUnStatus().success(function(data){
				$scope.accounts = data;
		        for(var i = 0;i<$scope.accounts.length;i++){
		        	$scope.accounts[i].accountId = $scope.accounts[i].accountId+10000;
		        }
		     	$scope.pages = backService.initPages($scope.accounts);
		     	$scope.index = 1;
		        $scope.indexPage = $scope.pages[$scope.index-1];
		        $scope.listPage = backService.initListPage($scope.pages);
			}).error(function(error){
				console.log("error");
			});
		}else if(status=='收入'){
			console.log('收入');
			accountService.findByStatus().success(function(data){
				$scope.accounts = data;
		        for(var i = 0;i<$scope.accounts.length;i++){
		        	$scope.accounts[i].accountId = $scope.accounts[i].accountId+10000;
		        }
		     	$scope.pages = backService.initPages($scope.accounts);
		     	$scope.index = 1;
		        $scope.indexPage = $scope.pages[$scope.index-1];
		        $scope.listPage = backService.initListPage($scope.pages);
			}).error(function(error){
				console.log("error");
			});
		}else{
			console.log("error");
			accountService.findAll().success(function(data){
				$scope.accounts = data;
		        for(var i = 0;i<$scope.accounts.length;i++){
		        	$scope.accounts[i].accountId = $scope.accounts[i].accountId+10000;
		        }
		     	$scope.pages = backService.initPages($scope.accounts);
		     	$scope.index = 1;
		        $scope.indexPage = $scope.pages[$scope.index-1];
		        $scope.listPage = backService.initListPage($scope.pages);
			}).error(function(error){
				console.log("error");
			});
		}
	}
	$scope.createAccount = function(){
		console.log("dd");
		$location.path('addAccount');
	}
	$scope.updateAccount = function(account){
		backService.account = account;
		$location.path('updateAccount');
	}
	$scope.deleteAccount = function(id){
		ide = id%1000;
		accountService.deleteAccount(ide).success(function(data){
			alert("删除成功");
			$scope.init();
		}).error(function(error){
			alert("删除失败");
		});
	}
	/*初始化表格数据*/
	$scope.init = function(){
		accountService.listAll().success(function(data){
			
	        $scope.accounts = data;
	        
	        for(var i = 0;i<$scope.accounts.length;i++){
	        	$scope.accounts[i].accountId = $scope.accounts[i].accountId+10000;
	        }
	     	$scope.pages = backService.initPages($scope.accounts);
	     	$scope.index = 1;
	        $scope.indexPage = $scope.pages[$scope.index-1];
	        $scope.listPage = backService.initListPage($scope.pages);
			console.log($scope.indexPage);
		}).error(function(error){
			alert("初始化数据必败");
		});
	}
	$scope.selectPage = function(list){
	  	    $scope.index = list;
	  	    $scope.indexPage = $scope.pages[list-1];
	    };
	    
	//上一页
	$scope.prePage = function(){
	  	    if($scope.index>1){
	  	  	   $scope.index--;
	  	  	   $scope.indexPage = $scope.pages[$scope.index-1];
	  	     }else{
	  	         }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	    }
	  	
	  	$scope.nextPage = function(){
	  	    var s = $scope.listPage.length;
	  	    var max = $scope.listPage[$scope.listPage.length-1];
	  	    if($scope.index<$scope.listPage[$scope.listPage.length-1]){
	  	     	$scope.index++;
	  	  	    $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	  }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	  	}
	  	
	  	$scope.jumpTo = function(index){
	  	    if(index<1){
	  	    	$scope.index = 1;
	  	    	$scope.indexPage = $scope.pages[0];
	  	    }else if(index<$scope.pages.length){
	  	    	$scope.index = index;
	  	        $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	    	$scope.index = $scope.pages.length;
	  	    	$scope.indexPage = $scope.pages[$scope.pages.length-1];
	  	    }
	    }
	  	$scope.init();
	
}]);
backApp.controller("addAccountCtrl",['$scope','$http','$filter','$location','addAccountService',function($scope,$http,$filter,$location,addAccountService){
	$scope.createAccount = function(account){
		console.log(account);
		addAccountService.createAccount(account).success(function(data){
			alert("添加成功");
		}).error(function(error){
			alert("创建失败");
		});
	}
	$scope.returnPage = function(){
		$location.path('account');
	}
}]);
backApp.controller("selectCtrl",['$scope','$http','$filter',function($scope,$http,$filter){
	
}]);
backApp.controller("userCtrl",['$scope','$http','$filter','customerService','$location','backService',
          function($scope,$http,$filter,customerService,$location,backService){
	
/*	var data = new Date();	
	var timeArr = new Array();
	data.setDate(30);
	var s = data;
	var d = data.getDate();
	console.log($filter('date')(data,"yyyy-MM-dd"));
	for(i=0;i<60;i++){
		data.setDate(data.getDate()+1);
		timeArr.push($filter('date')(data,"yyyy-MM-dd"));
	}
	console.log(timeArr[1] instanceof Date);
	var s = new Date();
	var a = s.getMonth();
	console.log(a);
	s.setMonth(19);
	console.log($filter('date')(s,"yyyy-MM-dd"));*/
	$scope.refeshCustomer = function(){
		$scope.init();
	}
	$scope.updateCustomer = function(customer){
		console.log(customer);
		backService.customer = customer;
		$location.path('updateUser');
	}
	$scope.deleteCustomer = function(customer){
		console.log(customer);
		customerService.deleteCustomer(customer.customerId).success(function(data){
			alert("删除成功");
			$scope.init();
		}).error(function(error){
			alert("删除失败");
		})
	}
	
	$scope.searchCustomer = function(phoneNumber){
		customerService.findByPhoneNumber(phoneNumber).success(function(data){
			if(data.length==0){
				alert("没有查询到相关数据");
			}else{
			$scope.customers = data;
	     	$scope.pages = backService.initPages($scope.customers);
	     	$scope.index = 1;
	        $scope.indexPage = $scope.pages[$scope.index-1];
	        $scope.listPage = backService.initListPage($scope.pages);
	       }
		}).error(function(error){
			console.log(error);
		});
	}
	$scope.init = function(){
		customerService.onFindAll().success(function(data){
			$scope.customers = data;
	     	$scope.pages = backService.initPages($scope.customers);
	     	$scope.index = 1;
	        $scope.indexPage = $scope.pages[$scope.index-1];
	        $scope.listPage = backService.initListPage($scope.pages);
			console.log(data);
			console.log(data);
		}).error(function(error){
			console.log(error);
		});
	}
	$scope.selectPage = function(list){
	  	    $scope.index = list;
	  	    $scope.indexPage = $scope.pages[list-1];
	    };
	    
	
	    
	//上一页
	$scope.prePage = function(){
	  	    if($scope.index>1){
	  	  	   $scope.index--;
	  	  	   $scope.indexPage = $scope.pages[$scope.index-1];
	  	     }else{
	  	         }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	    }
	  	
	  	$scope.nextPage = function(){
	  	    var s = $scope.listPage.length;
	  	    var max = $scope.listPage[$scope.listPage.length-1];
	  	    if($scope.index<$scope.listPage[$scope.listPage.length-1]){
	  	     	$scope.index++;
	  	  	    $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	  }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	  	}
	  	
	  	$scope.jumpTo = function(index){
	  	    if(index<1){
	  	    	$scope.index = 1;
	  	    	$scope.indexPage = $scope.pages[0];
	  	    }else if(index<$scope.pages.length){
	  	    	$scope.index = index;
	  	        $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	    	$scope.index = $scope.pages.length;
	  	    	$scope.indexPage = $scope.pages[$scope.pages.length-1];
	  	    }
	    }
	$scope.init();
}]);
backApp.controller("updateUserCtrl",['$scope','$http','$filter','updateUserService','$location','backService',
          function($scope,$http,$filter,updateUserService,$location,backService){
    $scope.customer = backService.customer;
    console.log($scope.customer);
    $scope.updateCustomer = function(customer){
    	updateUserService.updateCustomer(customer).success(function(data){
    		alert("修改成功");
    	}).error(function(error){
    		console.log(error);
    	});
    }
    
    $scope.returnPage = function(){
    	$location.path('user');
    }
}]);	
backApp.controller("reviewCtrl",['$scope','$http','$filter','reviewService','$location','backService',
          function($scope,$http,$filter,reviewService,$location,backService){
    $scope.selectOptions = ["审核中","已审核"];
    $scope.changeOption = function(){
    	
    }
    $scope.deleteReview = function(id){
    	reviewService.deleteReview(id).success(function(data){
    		alert("删除成功");
    		$scope.init();
    	}).error(function(error){
    		alert("删除失败");
    	})
    }
    $scope.init = function(){
		reviewService.findAll().success(function(data){
			$scope.reviews = data;
			console.log(data);
	     	$scope.pages = backService.initPages($scope.reviews);
	     	$scope.index = 1;
	        $scope.indexPage = $scope.pages[$scope.index-1];
	        $scope.listPage = backService.initListPage($scope.pages);
		}).error(function(error){
			console.log(error);
		});
	}
	$scope.selectPage = function(list){
	  	    $scope.index = list;
	  	    $scope.indexPage = $scope.pages[list-1];
	    };
	//上一页
	$scope.prePage = function(){
	  	    if($scope.index>1){
	  	  	   $scope.index--;
	  	  	   $scope.indexPage = $scope.pages[$scope.index-1];
	  	     }else{
	  	         }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	    }
	  	
	  	$scope.nextPage = function(){
	  	    var s = $scope.listPage.length;
	  	    var max = $scope.listPage[$scope.listPage.length-1];
	  	    if($scope.index<$scope.listPage[$scope.listPage.length-1]){
	  	     	$scope.index++;
	  	  	    $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	  }
	  	    $scope.listPage = backService.listPage($scope.pages,$scope.index,$scope.listPage);
	  	}
	  	
	  	$scope.jumpTo = function(index){
	  	    if(index<1){
	  	    	$scope.index = 1;
	  	    	$scope.indexPage = $scope.pages[0];
	  	    }else if(index<$scope.pages.length){
	  	    	$scope.index = index;
	  	        $scope.indexPage = $scope.pages[$scope.index-1];
	  	    }else{
	  	    	$scope.index = $scope.pages.length;
	  	    	$scope.indexPage = $scope.pages[$scope.pages.length-1];
	  	    }
	    }
	$scope.init();
}]);	