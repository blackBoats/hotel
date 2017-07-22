
app.controller('registCtrl',['$scope','$http','registService',function($scope,$http,registService){

//	#scope.validEmail = function(){
//		
//	}
    $scope.saveCustomer = function(customer){
	   
	    var res = verifyCode.validate(document.getElementById("code_input").value);
			if(res){
				registService.onSave(customer).success(function(data){
		    		alert("注册成功");
		    	}).error(function(error){
		    		alert("注册失败");
		    	})
			}else{
				alert("验证码错误");
			}		
    	
    }
    
   
}]);
app.controller('loginCtrl',['$scope','$http','registService','userService',function($scope,$http,registService,userService){

//	#scope.validEmail = function(){
//		
//	}
  
    $scope.login = function(customer){
    	registService.onLogin(customer).success(function(data){
//  		window.location.href="index";
            if(data.length==0){
            	alert("登陆失败");
            }
            console.log(data.prototype);
            console.log(data.password);
            if(data.password===undefined){
            	console.log("null");
            }else{
            	window.location.href="index";
            }
//  		$scope.customer = data.customer;
//  		window.location.href="index";
    	}).error(function(error){
    	    alert("账号或者密码错误");
    	})
    }
}]);

