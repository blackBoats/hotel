backApp.service("backService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	/*
	   	 * 分页
	   	 * 初始化数据
	   	 */
	   	    initPages : function(rooms){
	   	    	var length = rooms.length;
	   	    	var totalPages = length/10;
	   	    	var more = length%10;
	   	    	var pages = new Array();
	   	    	for(var i=1;i<=totalPages;i++){
	  		        var page = new Array();
	  		        for(var j=(i-1)*10+1;j<=i*10;j++){
	  			        page.push(rooms[j-1]);
	  		         }
	  		        pages.push(page);
	  		    }
	   	    	page = [];
	   	    	for(var i=1;i<=more;i++){
                    page.push(rooms[pages.length*10+i-1])
	         	}
	   	    	pages.push(page);
	   	   	return pages;
	       },
	       /*-----------------*/
	       initListPage : function(pages){
	       	    listPage = new Array();  //页码
	  	        if(pages.length<=7){
	  		        for(var i=1;i<=pages.length;i++){
	  		         	listPage.push(i);
	  		         }
	  	        }else{
	  		        for(var i =1; i <= 7; i++){
	  			        listPage.push(i);}
	  	        }
	  	        return listPage;
	       },
	       /*-----------------*/
	       listPage : function(pages,index,listPage){
	       	    if(pages.length>7){
	  	     	    if(pages.length-index>7){
	  	  	        	listPage = [];
	  	  		        for(var i = $scope.index; i<$scope.index+7; i++){
	  	  			        $scope.listPage.push(i);
	  	  		        }
	  	  	        }else{
	  	  	           	$scope.listPage = [];
	  	  		        for(var i=$scope.pages.length-7; i<$scope.pages.length;i++){
	  	  		     	$scope.listPage.push(i);
	  	  		       }
	  	           	}
	  	        }else{
	  	         }
	       	    return listPage;	      
	        },
	       /*-----------------*/
	      room : [],
	      customer:[],
	      employee: [],
	      account: [],
	      imagee: []
	    }
	   return service;
}]);
backApp.service("orderService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	    queryOrderStatus : function(){
	   	   	 return $http.get("/order/status");
	   	    },
	   	    queryAll: function(){
	   	    	return $http.get('/order/all');
	   	    },
	   	    queryOrderUnStatus: function(){
	   	    	return $http.get('/order/unStatus');
	   	    },
	   	    saveOrder: function(order){
	   	    	return $http.post('/order/save',order);
	   	    },
	   	    findByRoomName: function(roomName){
	   	    	return $http.get('/order/findByRoomName/'+roomName);
	   	    },
	   	    updateOrder: function(order){
	   	    	return $http.post('/order/update');
	   	    }
	   };
	   return service;
}]);
backApp.service("addOrderService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	    queryRoomByTypeRoom : function(typeRoom){
	   	   	    return $http.get("/findByTypeRoom/room/"+typeRoom);
	   	    },
	   	    queryRoomByTypeBed : function(bedType,roomType){
	   	    	return $http.post("/findByBedType/room/"+bedType,roomType);
	   	    }
	   }; 
	   return service;
}]);
backApp.service("roomService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	    queryRoomStatus : function(){
	   	   	 return $http.get("/findByStatus");
	   	    },
	   	    queryRoomUnStatus : function(){
	   	   	 return $http.get("/findByUnStatus");
	   	    },
	   	    createOrder : function(order){
	   	    	return $http.post('/order/create',order);
	   	    },
	   	    searchRoom : function(roomName,reserveStatus){
	   	    	return $http.get('/findByLikeRoomName/'+roomName+'&&'+reserveStatus);
	   	    },
	   	    deleteRoomById: function(roomId){
	   	    	return $http.delete('/deleteRoom/'+roomId);
	   	    }
	   	    
	   };
	   return service;
}]);
backApp.service("updateRoomService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	   updateRoom : function(room){
	   	   	return $http.post('updateRoom',room);
	   	   },
	   	   deleteRoom : function(roomId){
	   	   	return $http.delete('deleteRoom/'+roomId);	
	   	   }
	   	    
	   };
	   return service;
}]);
backApp.service("addRoomService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	   createRoom : function(room){
	   	   	return $http.post('/createRoom',room);
	   	   }
	   	    
	   };
	   return service;
}]);
backApp.service("addEmployeeService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	   createEmployee: function(employee){
	   	   	return $http.post('/employee/create',employee);
	   	   }
	   };
	   return service;
}]);
backApp.service("updateEmployeeService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	  
	   	   updateEmployee: function(employee){
	   	   	return $http.post('/employee/update',employee);
	   	   }
	   	    
	   };
	   return service;
}]);
backApp.service("employeeService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	  
	   	   allEmployee: function(){
	   	   	return $http.get('/employee/listAll');
	   	   },
	   	   deleteEmployee: function(id){
	   	   	return $http.delete('/employee/delete/'+id);
	   	   },
	   	   createAccount: function(employee){
	   	   	return $http.post('/employee/account',employee);
	   	   },
	   	   searchEmployee: function(username){
	   	   	return $http.get('/employee/findByUsername/'+username);
	   	   }
	   	    
	   };
	   return service;
}]);
backApp.service("accountService", ['$rootScope', '$http', function($rootScope, $http){
	    var service = {
	   	    listAll: function(){
	   	  	    return $http.get('/account/listAll');
	   	    },
	   	    deleteAccount: function(id){
	   	    	return $http.delete('/account/delete/'+id);
	   	    },
	   	    findByStatus: function(){
	   	    	return $http.get('/account/findByStatus');	
	   	    },
	   	    findByUnStatus: function(){
	   	    	return $http.get('/account/findByUnStatus');
	   	    },
	   	    findByLike: function(accountUsername){
	   	    	return $http.get('/account/likeAccountUsername/'+accountUsername);
	   	    }
	    };
	   return service;
}]);
backApp.service("addAccountService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	createAccount: function(account){
	   		return $http.post('/account/create',account);
	   	}
	   };
	   return service;
}]);
backApp.service("updateAccountService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	updateAccount: function(account){
	   		return $http.post('/account/update',account);
	   	}
	   };
	   return service;
}]);
backApp.service("addImageService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	saveImage: function(fd){
	   	    return $http({
	   			method: "POST",
	   			url:"/image/save",
	   			data: fd,
	   		    headers: {'Content-Type':undefined},
                transformRequest: angular.identity 
	   		});
	   	},
	   	createImage: function(image){
	   		return $http.post('/image/save')
	   	}
	   };
	   return service;
}]);
backApp.service("imageService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	findAll: function(){
	   		return $http.get('image/listAll');
	   	},
	   	deleteImage: function(id){
	   		return $http.delete('image/delete/'+id);
	   	},
	   	updateImage: function(imagee){
	   		return $http.post('/image/update',imagee);
	   	}
	   
	   };
	   return service;
}]);
backApp.service("customerService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	onFindAll: function(){
	   	    return $http.get('/customer/findAll');
	   	},
	   	deleteCustomer: function(id){
	   		return $http.delete('customer/delete/'+id);
	   	},
	   	findByPhoneNumber: function(phoneNumber){
	   		return $http.get('/customer/findByPhoneNumber/'+phoneNumber);
	   	}
	   };
	   return service;
}]);
backApp.service("updateUserService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	onFindAll: function(){
	   	    return $http.get('/customer/findAll');
	   	},
	   	updateCustomer: function(customer){
	   		return $http.post('/customer/update',customer);
	   	},
	   	deleteCustomer: function(id){
	   		return $http.delete('/customer/delete/'+id);
	   	}
	   };
	   return service;
}]);
backApp.service("reviewService", ['$rootScope', '$http', function($rootScope, $http){
	   var service = {
	   	findAll: function(){
	   		return $http.get('/review/findAll');
	   	},
	   	deleteReview: function(reviewId){
	   		return $http.delete('/review/delete/'+reviewId);
	   	}
	   };
	   return service;
}]);