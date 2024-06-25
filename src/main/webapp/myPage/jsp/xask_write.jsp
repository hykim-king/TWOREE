<%@page import="java.util.List"%>
<%@page import="com.pcwk.ask.AskDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pcwk.user.UserDTO"%>
<%
	AskDTO doSelectOneX1InVO = (AskDTO)request.getAttribute("doSelectOneX1InVO");
	UserDTO user= (UserDTO)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/TWOREE/myPage/css/bootstrap.min.css">
<script src="/TWOREE/myPage/js/jquery_3_7_1.js"></script>
<script src="/TWOREE/myPage/js/common.js"></script>
<script > 
document.addEventListener("DOMContentLoaded", function(){
	const workDiv = document.querySelector("#workDiv"); 
	const shopNo = document.querySelector("#shopNo");
	const userId = document.querySelector("#userId");
	const userAsk = document.querySelector("#userAsk"); 
	
	const saveBtn = document.querySelector("#saveBtn"); 
	const toAsk = document.querySelector("#toAsk");
	
	
	toAsk.addEventListener("click",function(event){
		console.log('toReview click'); 

		$.ajax({
	    type: "GET", 
	    url:"/TWOREE/user/myPage.do",
	    dataType:"html",
	    data:{
	        "work_div": "doRetrieveX",
	        "askNo": "42",
	        "userId": "user1"
	    },
	    success:function(response){//통신 성공
	        console.log("success data:"+response);
	         window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveX&userId="+"user1"); 
	    },
	    error:function(response){//실패시 처리
	            console.log("error:"+response);
	    }
		})//-ajax
		});//-Vtn
		
		
	saveBtn.addEventListener("click", function(event){
			console.log('saveBtn click event'+event); 
			askSave();
		});
		
		
		function askSave() {
			console.log('askSave' ); 
			
			
			 if(isEmpty(shopNo.value) == true){
				 shopNo.focus();
			      alert('가게번호를 입력 하세요.');
			      return;
			    }
			 if(isEmpty(userId.value) == true){
				 userId.focus();
			      alert('유저이름를 입력 하세요.');
			      return;
			    }
			 if(isEmpty(userAsk.value) == true){
				 userAsk.focus();
			      alert('내용를 입력 하세요.');
			      return;
			    }
			 $.ajax({
			        type: "POST", 
			        url:"/TWOREE/user/myPage.do",
			        dataType:"html",
			        data:{
			            "work_div":"doSaveAsk",
			            "shopNo": shopNo.value,
			            "userId": userId.value,
			            "userAsk": userAsk.value
			        },
			        success:function(response){
			            console.log("success data:"+response);  
			     
			         if(response){
			        	 try{
			        		  const messageVO = JSON.parse(response);
			        		  console.log("messageVO.messageId:"+messageVO.messageId);
			        		  console.log("messageVO.msgContents:"+messageVO.msgContents);
			        		  
			        		  if(isEmpty(messageVO)==false && "1"===messageVO.messageId){
			        			alert(messageVO.msgContents);
			        			window.close();
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
			
		}//-save end
	 
		
		
	}) ;//--document



</script>
 
</head>
<body>
		<div class="container my-5">
        <h1 class="mb-4">문의 쓰기</h1>
        <form id="menuForm">
            <div class="form-group row">
                <label for="shopNo" class="col-sm-2 col-form-label" >가게번호 :</label>
                <div class="col-sm-10">
                    <input type="text" disabled="disabled" class="form-control" name="shopNo" id="shopNo" value="${doSelectOneX1InVO.shopNo}">
                </div>
            </div>
            
             <br>
            <div class="form-group row">
                <label for="userId" class="col-sm-2 col-form-label">문의자 :</label>
                <div class="col-sm-10">
                    <input type="text" disabled="disabled" class="form-control" name="userId"  id="userId" value="${user.userId}"  >
                </div>
            </div> 
            <br>
            <div class="form-group row">
                <label for="userAsk" class="col-sm-2 col-form-label">문의 내용:</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="userAsk" name="userAsk" rows="4"></textarea>
                </div>
            </div>
            
             <br>
            
            
           
            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <button type="button" class="btn btn-primary" id="saveBtn">답변 작성</button>
                    <button type="reset" class="btn btn-secondary" id="toAsk" >취소</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>