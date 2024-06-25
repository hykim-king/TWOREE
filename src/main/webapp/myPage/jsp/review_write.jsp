<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pcwk.user.UserDTO"%>
    
    <% String shopNo = (String)request.getAttribute("shopNo"); %>
    <% String userId = (String)request.getAttribute("userId"); %>
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
	const shopNo = document.querySelector("#shopNo");//contents
	const userId = document.querySelector("#userId"); 
	const reviewContent = document.querySelector("#reviewContent"); 
	const score  = document.querySelector("#score");
	const saveBtn = document.querySelector("#saveBtn");
 
	const toReviewBtn = document.querySelector("#toReview");
	
	toReviewBtn.addEventListener("click",function(event){
		toReview();
	});
		
	function toReview(){ 
		console.log('toReviewBtn click'); 
		window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveR1");   
	} 
	
	
		saveBtn.addEventListener("click", function(event){
			console.log('saveBtn click event'+event); 
			reviewSave();
		});
		
		
		function reviewSave() {
			console.log('reviewSave' ); 
		
			 
			 $.ajax({
			        type: "POST", 
			        url:"/TWOREE/user/myPage.do",
			        dataType:"html",
			        data:{
			            "work_div":"doSaveReview",
			            "shopNo": shopNo.value,
			            "userId": userId.value,
			            "reviewContent": reviewContent.value,
			            "score": score.value
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
<jsp:include page="/reserver/jsp/header.jsp"></jsp:include>
		<div class="container my-5">
        <h1 class="mb-4">리뷰쓰기</h1>
        <form id="menuForm">
            <div class="form-group row">
             
                <label for="shopNo" class="col-sm-2 col-form-label" >가게번호 :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="shopNo" disabled="disabled"  value="${shopNo}"    >
                </div>
            </div>
            
             <br>
            <div class="form-group row">
                <label for="userID" class="col-sm-2 col-form-label">작성자 :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="userId" disabled="disabled"  value="${userId}" >
                </div>
            </div> 
            <br>
            <div class="form-group row">
                <label for="reviewContent" class="col-sm-2 col-form-label">리뷰 내용:</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="reviewContent" name="reviewContent" rows="4"    ></textarea>
                </div>
            </div>
            
             <br>
            <div class="form-group row">
                <label for="score" class="col-sm-2 col-form-label">별점 : (10점만점)</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="score"  name="score"   >
                </div>
            </div>
            
           
            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <button type="button" class="btn btn-primary" id="saveBtn">리뷰 등록</button>
                    <button type="reset" class="btn btn-secondary"  id="toReview" name="toReview">취소</button>
                </div>
            </div>
        </form>
    </div>
    <jsp:include page="/reserver/jsp/footer.jsp"></jsp:include>
</body>
</html>