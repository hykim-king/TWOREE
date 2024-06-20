<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.user.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/TWOREE/myPage/css/bootstrap.min.css">  

<script src="/TWOREE/myPage/js/jquery_3_7_1.js"></script>
<script src="/TWOREE/myPage/js/common.js"></script>


<script>
//String outVO = (String)request.getAttribute("outVO");

document.addEventListener("DOMContentLoaded", function(){
const profBtn = document.querySelector("#profBtn"); 
const doRetrieveRtn = document.querySelector("#doRetrieveR"); 
const doRetrieveVtn = document.querySelector("#doRetrieveV"); 
const doRetrieveXtn = document.querySelector("#doRetrieveX");

profBtn.addEventListener("click",function(event){
	console.log('profBtn click'); 
	window.location.replace("/TWOREE/user/myPage.do?work_div=doSelectOne&userId="+"user1"); 
	
});
 
doRetrieveRtn.addEventListener("click",function(event){
	console.log('doRetrieveRtn click'); 

	$.ajax({
    type: "GET", 
    url:"/TWOREE/user/myPage.do",
    dataType:"html",
    data:{
        "work_div": "doRetrieveR",
        "userId": "user1"
    },
    success:function(response){//통신 성공
        console.log("success data:"+response);
         window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveR&userId="+"user1"); 
    },
    error:function(response){//실패시 처리
            console.log("error:"+response);
    }
	})//-ajax
	});//-Rtn
	
	doRetrieveVtn.addEventListener("click",function(event){
		console.log('doRetrieveVtn click'); 

		$.ajax({
	    type: "GET", 
	    url:"/TWOREE/user/myPage.do",
	    dataType:"html",
	    data:{
	        "work_div": "doRetrieveV",
	        "userId": "user1"
	    },
	    success:function(response){//통신 성공
	        console.log("success data:"+response);
	         window.location.replace("/TWOREE/user/myPage.do?work_div=doRetrieveV&userId="+"user1"); 
	    },
	    error:function(response){//실패시 처리
	            console.log("error:"+response);
	    }
		})//-ajax
		});//-Vtn
		
	doRetrieveXtn.addEventListener("click",function(event){
		console.log('doRetrieveVtn click'); 

		$.ajax({
	    type: "GET", 
	    url:"/TWOREE/user/myPage.do",
	    dataType:"html",
	    data:{
	        "work_div": "doRetrieveX",
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
		});//-xtn
					
		
	
}) ;//--document
</script>
 

    <title>프로필</title>
    <style>
     h5 {
   		 color: white;
     }
     textarea {
         width: 100%;
         height: 4em;
         resize: none;
     }
     
     .body {
         display: flex;
         margin: 0;
         padding: 100px; /* 가장자리 여백 */
         height: calc(100vh - 100px); /* 패딩 값을 제외한 높이 설정 */
         box-sizing: border-box;
         flex-direction: row;
         gap: 20px;
     }
     
     .body .menu { 
         display: flex;
         flex-direction: column;
         width: 350px;
         min-width: 100px;
         background-color: white;
         border: 1px solid #ccc;
         padding: 20px;
         box-shadow: 2px 0 5px rgba(0,0,0,0.1);
         box-sizing: border-box;
         align-items: center; /* 메뉴를 수평 가운데 정렬 */
         border-radius: 10px; /* 모서리를 둥글게 */
     }
     
     .body .content {
         flex-grow: 1; /* 남은 공간을 차지하도록 설정 */
         padding: 20px;
         box-sizing: border-box;
         border: 1px solid #ccc;
         overflow: auto; /* 내용이 넘칠 경우 스크롤 생성을 위해 */
         border-radius: 10px; /* 모서리를 둥글게 */
         background-color: #ccc;
     }
     
     .body .content_info {
         margin-top: 10px;
         flex-grow: 1; /* 남은 공간을 차지하도록 설정 */
         padding: 20px;
         box-sizing: border-box;
         border: 1px solid #ccc;
         overflow: auto; /* 내용이 넘칠 경우 스크롤 생성을 위해 */
         border-radius: 10px; /* 모서리를 둥글게 */
         background-color: #FFFFFF;
     }
     
     .body .menu ul {
         list-style-type: none;
         padding: 0;
         text-align: left; /* 왼쪽 정렬 */
         width: 100%; /* ul 요소가 전체 너비를 차지하게 설정 */
     }
     
     .body .menu ul li {
         margin: 10px 0;
     }
     
     .body .menu ul li a {
         text-decoration: none;
         color: #333;
     }
     
     .body .menu ul li a:hover {
         text-decoration: underline;
     }
     
     .body .content ul {
         list-style: none;
         padding-left: 0;
     }
     
     .body .content ul li {
         margin: 10px;
     } 
     
     .footer {
         display: flex;
         justify-content: center;
         align-items: center;
         position: fixed;
         bottom: 0;
         width: 100%;
         background-color: #f8f9fa;
         padding: 10px;
         border-top: 1px solid #ccc;
     }
     
    </style>
</head>
<div class ="body">
<body>
    <div class="menu">
          <img src="/TWOREE/myPage/img/user_icon1.png" width= 80px><br>
        <label for="uid">아이디 &nbsp</label>
        <ul>
            <li><input type="button" value="내프로필" class="btn btn-outline-success " id="profBtn" ></li>
            <li><input type="button" value="예약"    class="btn btn-light " id="doRetrieveR" ></li>
            <li><input type="button" value="리뷰"    class="btn btn-light " id="doRetrieveV" ></li>
            <li><input type="button" value="고객문의" class="btn btn-light " id="doRetrieveX" ></li>
        </ul>
        
         <hr>
          <hr>
           <hr>
        
        
    </div>
    <div class="content">
        <h5>개인 정보</h5>
        <p></p>
        <div class="content_info">
            <ul>
                <li>
                    <label for="userId">아이디 &nbsp</label>
                    <input type="text" id="userId"  name="userId" required value="${outVO.userId}"> 
                </li>
                <li>
                    <label for="userEmail">이메일 &nbsp</label>
                    <input type="email" id="userEmail" name="userEmail" required value="${outVO.userEmail}"> 
                </li>
                <li>
                    <label for="password">비밀번호 &nbsp</label>
                    <input type="password" id="password" name="password"  required value="${outVO.password}"> 
                </li> 
            </ul>  
             <button type="button" class="btn btn-secondary" style="float: right;">수정하기</button>
        </div>
        
              <div class="content_info">
        
            <ul>
                <li>
                    <label for="name">이름 &nbsp</label>
                    <input type="text" id="name"   name="name"  required value="${outVO.name}"> 
                </li>
                <li>
                    <label for="tel">전화번호 &nbsp</label>
                    <input type="email" id="tel" name ="tel" required value="${outVO.tel}"> 
                </li>
                <li>
                    <label for="birthday">생년월일 &nbsp</label>
                    <input type="password" id="birthday" name="birthday" required value="${outVO.birthday}"> 
                </li> 
            </ul>
            
             <button type="button" class="btn btn-secondary" style="float: right;">수정하기</button>
        </div>
        
        <div class="content_info">
        
            <ul>
                <li>
                    <label>관리자 &nbsp </label>
                     <!--   <div class="form-check form-switch">
                     <input class="form-check-input" type="checkbox" id="Switches" checked> 
                     <label class="form-check-label" for="Switches"></label>  
                      </div>--> 
                    <button type="button" class="btn btn-success" style="float: right;">관리하기</button>
                </li>
                 
            </ul>
            
        </div>
        <br>
         <h5>예약 관리</h5>
        <div class="content_info">
        
            <ul>
                <li>
                    <label>예약패널티 &nbsp </label>
                     <!--   <div class="form-check form-switch">
                     <input class="form-check-input" type="checkbox" id="Switches" checked> 
                     <label class="form-check-label" for="Switches"></label>  
                      </div>-->
                    <button type="button" class="btn btn-secondary" style="float: right;">확인하기</button>
                </li>
                 
            </ul>
            
        </div>
        
        
    </div> 
    
</body> 
 </div>
   <jsp:include page="/reserver/jsp/footer.jsp"></jsp:include>
</html>
 




