<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.review.ReviewDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    List<ReviewDTO> list = (List<ReviewDTO>)request.getAttribute("reviewList"); 
%>
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

const doReviewBtn = document.querySelector("#doRetrieveR1");

profBtn.addEventListener("click",function(event){
	console.log('profBtn click'); 
	window.location.replace("/TWOREE/user/myPage.do?work_div=doSelectOne&userId="+"user1"); 
	
});

	doReviewBtn.addEventListener("click",function(event){
	console.log('doReviewBtn click'); 

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
	});//-doReviewBtn
	
 
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
    <title>리뷰</title>
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

        .onboarding {
            display: flex;
            justify-content: center;
            gap: 100px;
            color: #dc143c;
        } 
        
        .star-rating {
        	display: inline-block;
        	font-size: 20px;
        	color: #ccc; /* 회색 별의 색상 */
        	position: relative;
   		 }
    	.star-rating .filled-stars {
        	color: gold; /* 금색 별의 색상 */
        	position: absolute;
        	top: 0;
        	left: 0;
        	overflow: hidden;
        	white-space: nowrap;
    	}
        
        
    </style>
</head>
<jsp:include page="/reserver/jsp/header.jsp"></jsp:include>
<div class ="body">
<body>
    <div class="menu">
        <img src="/TWOREE/myPage/img/user_icon1.png" width= 80px><br>
        <p class="text-success"><strong><%= list.get(0).getUserId()%></strong></p>
       <ul>
            <li><input type="button" value="내프로필" class="btn btn-light " id="profBtn" ></li>
            <li><input type="button" value="예약"    class="btn btn-light " id="doRetrieveR" ></li>
            <li><input type="button" value="리뷰"    class="btn btn-outline-success " id="doRetrieveV" ></li>
            <li><input type="button" value="고객문의" class="btn btn-light " id="doRetrieveX" ></li>
        </ul>
        
         <hr>
          <hr>
           <hr>
        
        
    </div>
    <div class="content">
        <h5>전체 리뷰 정보</h5>
        <p></p>
         <div class="right-section">
        <!-- 버튼 --> 
        <div class="mb-2 d-grid gap-2 d-md-flex justify-content-md-end"> 
            <button type="reset" class="btn btn-secondary" value="" >새로고침</button> 
            <button type="button" class="btn btn-dark"   id="doRetrieveR1">리뷰쓰기</button>
        </div>
        <!--// 버튼 ----------------------------------------------------------------->
       <div class="table-container">
          <table class="table table-hover">
          <thead>
                    <tr class="table-dark table-hover table-bordered" id="option_reserver">
                 	<th>예약정보</th>	
                 	<th>리뷰정보</th>	
                 	<th>메뉴</th>	  
                 	</tr>
     	 </thead> 
    	 <tbody> 
    	 
    	 <%     if(null != list && list.size()>0){
          				for(ReviewDTO vo   :list){  
		         %> 
		         
				<tr><td rowspan="3" >[가게번호] <%=vo.getShopNo()%></td>
					<td>[별점]  
                             <div class="star-rating">
                              <div class="filled-stars" style="width: <%= (vo.getScore() / 10.0) * 100 %>%;">
                               ★★★★★ </div>
                              <div> ☆☆☆☆☆ </div></div> </td> 
					<td>[작성날짜] <%=vo.getReviewWrtDate()%></td>  
					 
					
				<tr><td>[내용] <%=vo.getReviewContent()%></td>
				 	<td>[수정날짜] <%=vo.getReviewModDate()%></td>	   
				 
					
					<tr> 
						<td> </td> 
						<td> </td>	 
			 <%  
          		  }//for
         		}//--if 
      		  %> 
   			 </tbody>
			 </table>
        </div>
    </div>
        
        
    </div>   
</body>
 </div>
   <jsp:include page="/reserver/jsp/footer.jsp"></jsp:include>
</html>
 