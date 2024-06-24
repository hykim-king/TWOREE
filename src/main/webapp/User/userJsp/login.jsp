<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="/TWOREE/User/assets/images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="/TWOREE/User/assets/css/bootstrap.css">
<style >
    .container {
        max-width: 400px; /* Adjust the width as needed */
        margin: auto; /* Center the form */
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100%;
        margin-top: 100px; /* Adjust this value to move the form down */
    }
</style>
<title>TWOREE 로그인</title>
<script src = "/TWOREE/User/assets/js/jquery_3_7_1.js"> </script>
<script src="/TWOREE/User/assets/js/common.js"></script> 
<script>
 document.addEventListener("DOMContentLoaded", function(){
	 console.log('DOMContentLoaded');
	 
	 const loginBtn = document.querySelector("#login");
	 const userId   = document.querySelector("#userId");
	 const password = document.querySelector("#password");
	 const moveToJoinBtn  = document.querySelector("#moveToJoin");
	 
	 $(loginBtn).ready(function() {
	     document.addEventListener("keydown", function(){
	       if (event.keyCode === 13) {
	        event.preventDefault();
	         console.log('loginBtn click:');
	         login();
	       }
	     });
	   });
	 
	 moveToJoinBtn.addEventListener("click", function(event){
		 console.log('moveToJoinBtn click:');
		 moveToJoin();
	
	 });
	 
	 loginBtn.addEventListener("click", function(){
		 console.log('loginBtn click:');
		 login();
		 
	 });
	 
	 function moveToJoin(){
		 console.log('moveToJoin()');
		 alert("회원가입 화면으로 이동 합니다.")
		 window.location.href = "/TWOREE/User/userJsp/join.jsp";
	 }
	 
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
	 
	 $.ajax({
		 type: "POST",
		 url : "/TWOREE/login/login.do",
		 asyn : "true",
		 dataType : "html",
		 data:{
			  "work_div": "login",
			  "userId"  : userId.value,
			  "password": password.value
			 
		 },
		 success:function(response){
			 console.log("success data:"+response);
		 
		 if(response){
			 try{
				 const messageVO = JSON.parse(response);
				 console.log("messageVO.messageId:"+messageVO.messgeId);
				 console.log("messageVO.msgContents:"+messageVO.msgContents);
			 
			 if(isEmpty(messageVO)==false && "10"=== messageVO.messageId){
				 alert(messageVO.msgContents);
				 memberId.focus();
			 }else if(isEmpty(messageVO) == false &&  "20" === messageVO.messageId){
         alert(messageVO.msgContents);
         password.focus();                   
        }else if(isEmpty(messageVO) == false &&  "30" === messageVO.messageId){
               alert(messageVO.msgContents);
               
			   window.location.href = "/TWOREE/shop/shop.do?work_div=doRetrieve";
			 
			 }
		
			 }catch(e){
				 console.error("JSON파싱 에러:",e); 
			 }
			 
		 }else{
			 console.warn("response가 null혹은 undefined.");
			 alert("response가 null혹은 undefined.");
			 
		 }
		 
	 },
	 error:function(data){
		 console.log("error:"+data);
		 
	 }
	
	 
	 
	 });
	 
	 
	 }
	 
	 
 });//--DOMContentLoaded end

</script>


</head>
<body>
<!-- container -->
<div class = "container">
  <!-- 제목 -->
  <div class="page-header mb-4">
    <h2>로그인</h2>
  </div>
  <!-- //제목 end ---------------------------------->
<form action="#" method="post">
  <input type ="hidden" name="work_div" id="work_div">

  <!-- 회원 id input -->
  <div data-mdb-input-init class = "form-outline mb-4">
    <input type="text" id="userId" name="userId" class="form-control /">
    <label class="form-label" for="userId">아이디</label>
  
  </div>
  <div data-mdb-input-init class="form-outline mb-4">
    <input type="password" id="password" name="password" class="form-control" />
    <label class="form-label" for="password">비밀번호</label>
  </div>

  <div class="row mb-4">
    <div class="col d-flex justify-content-center">
      <!-- Checkbox -->
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
        <label class="form-check-label" for="form2Example31"> 로그인 저장 </label>
      </div>
    </div>
<!-- 
  <div class ="col">
    <a href="#!">비밀번호를 잊으셨나요?</a>
  
  </div>
-->  
  </div>


<button id="login" type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-block mb-4">로그인</button>
<button id="moveToJoin" type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-block mb-4">회원가입</button>

</form>
</div>
<!-- //container end --------------------------------->
</body>
<script src="/TWOREE/User/assets/js/bootstrap.bundle.min.js"></script> 
</html>