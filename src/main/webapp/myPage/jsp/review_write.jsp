<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
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
	const shopNo = document.querySelector("#shopNo");//contents
	const userId = document.querySelector("#userId"); 
	const reviewContent = document.querySelector("#reviewContent"); 
	const score  = document.querySelector("#score"); 

	toReview.addEventListener("click",function(event){
		console.log('toReview click'); 

		$.ajax({
	    type: "GET", 
	    url:"/TWOREE/user/myPage.do",
	    dataType:"html",
	    data:{
	        "work_div": "doRetrieveR1",
	        "userId": "user1"
	    },
	    success:function(response){//통신 성공
	        console.log("success data:"+response);
	         window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveR1&userId="+"user1"); 
	    },
	    error:function(response){//실패시 처리
	            console.log("error:"+response);
	    }
		})//-ajax
		});//-Vtn
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
                <label for="userID" class="col-sm-2 col-form-label">문의자 :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="userId" disabled="disabled"  value="${userId}" >
                </div>
            </div> 
            <br>
            <div class="form-group row">
                <label for="reviewContent" class="col-sm-2 col-form-label">문의 내용:</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="reviewContent" rows="4" ></textarea>
                </div>
            </div>
            
             <br>
            <div class="form-group row">
                <label for="score" class="col-sm-2 col-form-label">별점 :</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="score"   value="${outVO.score}" >
                </div>
            </div>
            
           
            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <button type="button" class="btn btn-primary" onclick="submitAnswer()">답변 작성</button>
                    <button type="reset" class="btn btn-secondary"  id="toReview" >취소</button>
                </div>
            </div>
        </form>
    </div>
    <jsp:include page="/reserver/jsp/footer.jsp"></jsp:include>
</body>
</html>