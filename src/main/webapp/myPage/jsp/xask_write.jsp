<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pcwk.user.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/TWOREE/myPage/css/bootstrap.min.css">
<script > 
	const userId = document.querySelector("#userId");    



</script>

<script src="/WEB02/assets/js/jquery_3_7_1.js"></script>
</head>
<body>
		<div class="container my-5">
        <h1 class="mb-4">문의 쓰기</h1>
        <form id="menuForm">
            <div class="form-group row">
            
                <label for="shopNo" class="col-sm-2 col-form-label" >가게번호 :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="shopNo"   value="${outVO.shopNo}"    >
                </div>
            </div>
            
             <br>
            <div class="form-group row">
                <label for="userID" class="col-sm-2 col-form-label">문의자 :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="userId" disabled="disabled"  value="${outVO.userId}" >
                </div>
            </div> 
            <br>
            <div class="form-group row">
                <label for="reviewContent" class="col-sm-2 col-form-label">문의 내용:</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="reviewContent" rows="4"  value="${outVO.reviewContent}"  ></textarea>
                </div>
            </div>
            
             <br>
            
            
           
            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <button type="button" class="btn btn-primary" onclick="submitAnswer()">답변 작성</button>
                    <button type="reset" class="btn btn-secondary" >취소</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>