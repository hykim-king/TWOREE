<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="/TWOREE/User/assets/images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="/TWOREE/User/assets/css/bootstrap.css">
<title>회원가입</title>
<script src = "/TWOREE/User/assets/js/jquery_3_7_1.js"> </script>
<script src="/TWOREE/User/assets/js/common.js"></script> 
<script>
  document.addEventListener("DOMContentLoaded", function(){
	 console.log('DOMContentLoaded---');
  
  const joinBtn = document.querySelector("#join");
  
  const workDiv = document.querySelector("#workDiv");
  const userId = document.querySelector("#userId");
  const password = document.querySelector("#password");
  const name = document.querySelector("#name");
  const userEmail = document.querySelector("#userEmail");
  const tel = document.querySelector("#tel");
  const birthday = document.querySelector("#birthday");
  
  joinBtn.addEventListener("click", function(event){
	  console.log('joinBtn click event'+event);  
    join();
  
  });
  
  function join(){
	  console.log('join()');
	  
	  if(isExistId(userId.value) == 1){
		  userId.focus();
		  alert('중복된 아이디가 있습니다.');
		  return;
	  }
	  if(isEmpty(userId.value) == true){
		  userId.focus();
		  alert('아이디를 입력 하세요.');
		  return;
	  }
	  if(isEmpty(password.value) == true){
		      password.focus();
	        alert('비밀번호를 입력 하세요.');
	        return;
	  }	  
	  if(isEmpty(name.value) == true){
		      name.focus();
	        alert('이름을 입력 하세요.');
	        return;
	  }	  
	  if(isEmpty(userEmail.value) == true){
		      userEmail.focus();
	        alert('이메일을 입력 하세요.');
	        return;
	  }     
	  if(isEmpty(tel.value) == true){
		      tel.focus();
	        alert('핸드폰 번호를 입력 하세요.');
	        return;
	  }   	  
	  if(isEmpty(birthday.value) == true){
		      birthday.focus();
	        alert('생년월일을 입력 하세요.');
	        return;
	  }   	  
	  
	    $.ajax({
	        type: "POST", 
	        url:"/TWOREE/login/login.do",
	        asyn:"true",
	        dataType:"html",
	        data:{
	            "work_div":"join",
	            "userId": userId.value,
	            "password": password.value,
	            "name": name.value,
	            "userEmail": userEmail.value,  
	            "tel" : tel.value,
	            "birthday" : birthday.value
	        
	        },
	        success:function(response){
	            console.log("success data:"+response);  
	     
	        
	     }
  
  });
  


</script>

</head>
<body>
	<h2></h2>
  <hr/>
	
</body>
<script src="/TWOREE/User/assets/js/bootstrap.bundle.min.js"></script> 
</html>