<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="/TWOREE/User/assets/images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="/TWOREE/User/assets/css/bootstrap.css">
<style> 
    .container{
        max-width: 600px;
        margin: auto;
        margin-top: 100px; /* Adjust this value to move the form down */
    }
     footer {
        background-color: #333;
        color: white;
        padding: 10px;
        text-align: center;
        width: 100%;
        position: absolute;
        bottom: 0;
        left: 0;
    }
    footer p {
        margin: 0;
        font-size: 1rem;
    }
    .contact-info {
        text-align: right;
        font-size: 0.8rem;
    }   
    
</style>
<title>회원가입</title>
<script src = "/TWOREE/User/assets/js/jquery_3_7_1.js"> </script>
<script src="/TWOREE/User/assets/js/common.js"></script> 
<script>
  document.addEventListener("DOMContentLoaded", function(){
	 console.log('DOMContentLoaded---');
  
  const joinBtn = document.querySelector("#join");
  const moveToLoginBtn = document.querySelector("#moveToLogin")
  
  const workDiv = document.querySelector("#work_div");
  const userId = document.querySelector("#userId");
  const password = document.querySelector("#password");
  const name = document.querySelector("#name");
  const userEmail = document.querySelector("#userEmail");
  const tel = document.querySelector("#tel");
  const birthday = document.querySelector("#birthday");
  

  $(joinBtn).ready(function() {
      document.addEventListener("keydown", function(){
        if (event.keyCode === 13) {
         event.preventDefault();
          console.log('joinBtn click:');
          join();
        }
      });
    });
  
  moveToLoginBtn.addEventListener("click", function(event){
	  console.log('moveToLogin click event'+event);
	  moveToLogin();
	
  });
  
  joinBtn.addEventListener("click", function(event){
	  console.log('joinBtn click event'+event);  
    join();
  
  });
  
  function moveToLogin(){
	  console.log('moveToLogin()');
	  alert("로그인 화면으로 이동 합니다.");
	  window.location.href = "/TWOREE/login/login.do?work_div=toLogin";
  }
  
  function join(){
	  console.log('join()');
	  
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
	  if(password.value.length<8 || password.value.length >16){
		    password.focus();
		    alert('비밀번호는 8~16자리여야 합니다.')
		    return;
	  }
	  if(isEmpty(name.value) == true){
		      name.focus();
	        alert('이름을 입력 하세요.');
	        return;
	  }
    if (!isValidKoreanName(name.value)) {
          name.focus();
          alert('이름은 한글로만 입력해야 합니다.');
          return;
    }
	  if(isEmpty(userEmail.value) == true){
		      userEmail.focus();
	        alert('이메일을 입력 하세요.');
	        return;
	  
	  } 
    if (!isValidEmail(userEmail.value)) {
          userEmail.focus();
          alert('올바른 이메일 형식을 입력하세요.');
          return;
    }	  
	  if(isEmpty(tel.value) == true){
		      tel.focus();
	        alert('핸드폰 번호를 입력 하세요.');
	        return;
	  }
    if (!isValidPhoneNumber(tel.value)) {
          tel.focus();
          alert('올바른 핸드폰 번호 형식을 입력하세요.');
          return;
    }
	  if(isEmpty(birthday.value) == true){
		      birthday.focus();
	        alert('생년월일을 입력 하세요.');
	        return;
	  } 
    if (!isValidBirthday(birthday.value)) {
          birthday.focus();
          alert('올바른 생년월일 형식을 입력하세요.');
          return;
    }
	  const shopAdmin = document.querySelector("#shopAdmin").checked ? "Y" : "N";
	    
	  $.ajax({
	        type: "POST", 
	        url:"/TWOREE/login/login.do",
	        dataType:"html",
	        data:{
	            "work_div":"join",
	            "userId": userId.value,
	            "password": password.value,
	            "name": name.value,
	            "userEmail": userEmail.value,  
	            "tel" : tel.value,
	            "birthday" : birthday.value,
	            "shopAdmin" : shopAdmin
	        },
	        success:function(response){
	            console.log("success data:"+response);  
	            
	           
	         if(response){
	        	 try{
	        		  const messageVO = JSON.parse(response);
	        		  console.log("messageVO.messageId:"+messageVO.messageId);
	        		  console.log("messageVO.msgContents:"+messageVO.msgContents);
	        		  
	        		  if(isEmpty(messageVO)==false && "10"===messageVO.messageId){
	        			alert(messageVO.msgContents);
	        			
	        			window.location.href="/TWOREE/login/login.do?work_div=toLogin";
	        		  
	        		  }else{
	        			  alert(messageVO.msgContents); 
	        		  }
	        		  
	        	    }catch(e){
	        		   console.error("JSON 파싱 에러:",e);
	        	    }
	        	
	            }else{
	        	   console.warn("response가 null혹은 undefined.");
	        	   alert("response가 null혹은 undefined.");
	            }
	        
	          },
	          error:function(data){
	        	  console.log("error:"+data);
	          
	        
	       }
	        
 
    });//--ajaxend
     
 
   }//-join end
   
   function isValidEmail(email) {
       const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
       return emailPattern.test(email);
   }
   
   function isValidPhoneNumber(phoneNumber) {
	    const phonePattern = /^(010|011|016|017|018|019)-?\d{3,4}-?\d{4}$/;
	    return phonePattern.test(phoneNumber);
	}
   function isValidBirthday(birthday) {
	    const birthdayPattern = /^(19|20)\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$/;

	    if (!birthdayPattern.test(birthday)) {
	        return false;
	    }

	    const year = parseInt(birthday.substring(0, 4), 10);
	    const month = parseInt(birthday.substring(4, 6), 10);
	    const day = parseInt(birthday.substring(6, 8), 10);

	    const date = new Date(year, month - 1, day);

	    return date.getFullYear() === year && date.getMonth() + 1 === month && date.getDate() === day;
	}
   function isValidKoreanName(name) {
	    const koreanNamePattern = /^[가-힣]+$/;
	    return koreanNamePattern.test(name);
	}   
 
});//Docoment end


</script>
</head>
<body>
<!--container -->
<div class ="container">
	
	<!-- 제목 -->
	<div class ="page-header mb-4">
	  <h2>회원 가입</h2>
	</div>
	<!-- //제목 end -->
  <!-- 버튼 -->
  <div class="mb-2 d-grid gap-2 d-md-flex justify-content-md-end">
    <input type="button" value="뒤로가기" class="btn btn-primary" id="moveToLogin">
    <input type="button" value="가입하기" class="btn btn-primary" id="join">
  </div>
  
 <!-- //버튼 end -->
 
 <!-- form -->
 <form action="#" class="form-horizontal">
  <input type="hidden" name="workDiv" id="workDiv">
  
  <div class="row mb-3">
    <label for="userId" class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-10">
     <input type="text" class="form-control" name="userId" id="userId" placeholder="아이디를 입력해주세요." required="required">
    </div>
  </div>

  <div class="row mb-3">
    <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-10">
     <input  type="password" class="form-control" name="password" id="password" placeholder="비밀번호 8~16자리를 입력해주세요." required="required" pattern=".{8,16}" title="비밀번호는 8~16자리여야 합니다.">
    </div>
  </div> 

  <div class="row mb-3">
    <label for="name" class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-10">
     <input type="text" class="form-control" name="name" id="name" placeholder="ex)홍길동" required="required">
    </div>
    
  </div> 

  <div class="row mb-3">
    <label for="userEmail" class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-10">
     <input type="email" class="form-control" name="userEmail" id="userEmail" placeholder="ex)ooo123@naver.com" required="required">
    </div>
  </div>  

  <div class="row mb-3">
    <label for="tel" class="col-sm-2 col-form-label">전화번호</label>
    <div class="col-sm-10">
     <input  type="tel" class="form-control" name="tel" id="tel" placeholder="ex)01012345678" required="required">
    </div>
  </div> 

  <div class="row mb-3">
    <label for="birthday" class="col-sm-2 col-form-label">생년월일</label>
    <div class="col-sm-10">
     <input  type="text" class="form-control" name="birthday" id="birthday" placeholder="ex)19940000" required="required">
    </div>
  </div> 


 </form>
 <div>
 <label><input type="checkbox" id="shopAdmin" name="shopAdmin" value="Y">관리자 여부</label>
 </div>
 
</div>	
    <footer>
        <p>&copy; 이성연, 엄기은, 임강혁, 박수연, 이무원, 황찬호</p>
        <p class="contact-info">Contact us: contact@tworee.com | +1-234-567-890</p>
    </footer>
</body>
<script src="/TWOREE/User/assets/js/bootstrap.bundle.min.js"></script> 
</html>