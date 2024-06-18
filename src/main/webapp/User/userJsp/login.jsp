<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="/TWOREE/assets/images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="/TWOREE/assets/css/bootstrap.css">
<style >
    .container {
      max-width: 400px; /* Adjust the width as needed */
      margin: auto; /* Center the form */
    }
</style>
<title>TWOREE 로그인</title>
<script src = "/TWOREE/assets/js/jquery_3_7_1.js"> </script>
<script src="/TWOREE/assets/js/common.js"></script> 
<script>
 document.addEventListener("DOMContentLoaded", function(){
	 console.log('DOMContentLoaded');
	 
	 const loginBtn = document.querySelector("#login");
	 const userId   = document.querySelector("#user_id");
	 const password = document.querySelector("#passwd");
	 
	 loginBtn.addEventListener("click", function(){
		 console.log('loginBtn click:');
		 login();
		 
	 });
	 
	 function login(){
		 console.log('login()');
	 
	 if(isEmpty(userId.value)== true){
		 userId.focus();
		 alert('ID를 입력 하세요.');
		 return;
	 }
	 
	 if(isEmpty(password.value)==true){
		 password.focus();
		 alert('비번을 입력 하세요.');
		 return;
	 }
	 
	 $ajax({
		 type: "POST",
		 url : ""
	 
	 
	
	 
	 
	 });
	 
	 
	 }
	 
	 
 });

</script>


</head>
<body>
	<h2></h2>
  <hr/>
	
</body>
<script src="/TWOREE/assets/js/bootstrap.bundle.min.js"></script> 
</html>