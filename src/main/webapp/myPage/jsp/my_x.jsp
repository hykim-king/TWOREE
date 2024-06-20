<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.ask.AskDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<AskDTO> list = (List<AskDTO>)request.getAttribute("askList"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/TWOREE/myPage/css/bootstrap.min.css"> 
<script src="/WEB02/assets/js/jquery_3_7_1.js">


<script src="/WEB02/assets/js/jquery_3_7_1.js"></script>
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
   h5{
  	color: white;
  	}
  	 textarea {
 		 	width: 100%;
  		height: 4em; 
  		resize: none;
		}
  	
      body {
          display: flex;
          margin: 0;
          padding: 100px; /* 가장자리 여백 */
          height: calc(100vh - 100px); /* 패딩 값을 제외한 높이 설정 */
          box-sizing: border-box;
          flex-direction: row;
          gap: 20px;  
      }
      .menu { 
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
      .content {
          flex-grow: 1; /* 남은 공간을 차지하도록 설정 */
          padding: 20px; 
          box-sizing: border-box;
          border: 1px solid #ccc;
          overflow: auto; /* 내용이 넘칠 경우 스크롤 생성을 위해 */
          border-radius: 10px; /* 모서리를 둥글게 */
          background-color:#ccc;
      }
      
        .content_info {
        	margin-top: 10px;
          flex-grow: 1; /* 남은 공간을 차지하도록 설정 */
          padding: 20px;
          box-sizing: border-box;
          border: 1px solid #ccc;
          overflow: auto; /* 내용이 넘칠 경우 스크롤 생성을 위해 */
          border-radius: 10px; /* 모서리를 둥글게 */
          background-color:#FFFFFF;
      }
      .menu ul {
          list-style-type: none;
          padding: 0;
          text-align: left; /* 왼쪽 정렬 */
          width: 100%; /* ul 요소가 전체 너비를 차지하게 설정 */
      }
      .menu ul li {
          margin: 10px 0;
      }
      .menu ul li a {
          text-decoration: none;
          color: #333;
      }
      .menu ul li a:hover {
          text-decoration: underline;
      }
      
      .content ul {
          list-style: none;
          padding-left: 0;
      }
      .content ul li {
          margin:10px;
      }

      .onboarding {
          display: flex;
          justify-content: center;
          gap: 100px;
          color: #dc143c;
      }
  </style>
  
 
    <title>고객문의</title>
    <style>
    	h5{
    	color: white;
    	}
    	 textarea {
   		 	width: 100%;
    		height: 4em; 
    		resize: none;
  		}
    	
        body {
            display: flex;
            margin: 0;
            padding: 100px; /* 가장자리 여백 */
            height: calc(100vh - 100px); /* 패딩 값을 제외한 높이 설정 */
            box-sizing: border-box;
            flex-direction: row;
            gap: 20px;  
        }
        .menu { 
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
        .content {
            flex-grow: 1; /* 남은 공간을 차지하도록 설정 */
            padding: 20px; 
            box-sizing: border-box;
            border: 1px solid #ccc;
            overflow: auto; /* 내용이 넘칠 경우 스크롤 생성을 위해 */
            border-radius: 10px; /* 모서리를 둥글게 */
            background-color:#ccc;
        }
        
          .ask_now {
          	margin-top: 10px;
            flex-grow: 1; /* 남은 공간을 차지하도록 설정 */
            padding: 20px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            overflow: auto; /* 내용이 넘칠 경우 스크롤 생성을 위해 */
            border-radius: 10px; /* 모서리를 둥글게 */
            background-color:#FFFFFF;
        }
        
           .ask_pass {
          	margin-top: 10px;
            flex-grow: 1; /* 남은 공간을 차지하도록 설정 */
            padding: 20px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            overflow: auto; /* 내용이 넘칠 경우 스크롤 생성을 위해 */
            border-radius: 10px; /* 모서리를 둥글게 */
            background-color:#FFFFFF;
        }
        
        
        .menu ul {
            list-style-type: none;
            padding: 0;
            text-align: left; /* 왼쪽 정렬 */
            width: 100%; /* ul 요소가 전체 너비를 차지하게 설정 */
        }
        .menu ul li {
            margin: 10px 0;
        }
        .menu ul li a {
            text-decoration: none;
            color: #333;
        }
        .menu ul li a:hover {
            text-decoration: underline;
        }
        
        .content ul {
            list-style: none;
            padding-left: 0;
        }
        .content ul li {
            margin:10px;
        }

        .onboarding {
            display: flex;
            justify-content: center;
            gap: 100px;
            color: #dc143c;
        } 
    </style>
</head>
<body>
    <div class="menu">
        
        <img src="/TWOREE/myPage/img/user_icon1.png" width= 80px><br>
        <label for="uid">아이디 &nbsp</label>
   <ul>
            <li><input type="button" value="내프로필" class="btn btn-light " id="profBtn" ></li>
            <li><input type="button" value="예약"    class="btn btn-light " id="doRetrieveR" ></li>
            <li><input type="button" value="리뷰"    class="btn btn-light " id="doRetrieveV" ></li>
            <li><input type="button" value="고객문의" class="btn btn-light " id="doRetrieveX" ></li>
        </ul>
        
         <hr>
          <hr>
           <hr>
       
        <ul class="onboarding">
           <button type="button" class="btn btn-light">홈</button>
           <button type="button" class="btn btn-light">로그아웃</button>
        </ul>
        
    </div>
    <div class="content">
        <h5>전체 문의 정보</h5>
        <p></p>
        <div class="right-section">
        <!-- 버튼 -->
        <div class="mb-2 d-grid gap-2 d-md-flex justify-content-md-end"> 
 		  <button type="rest" class="btn btn-secondary" value="" >새로고침</button> 
          <button type=" " class="btn btn-dark" value="" onClick="location.href='my_v.jsp'">문의하기</button>
        </div>
        <!--// 버튼 ----------------------------------------------------------------->
       <div class="table-container">
          <table class="table table-hover">
          <thead>
                    <tr class="table-dark table-hover table-bordered" id="option_reserver">
                 	<th>문의정보</th>	
                 	<th>개인정보</th>	
                 	<th>옵션</th>	 
                 	<th class="text_center col-sm-1">관리</th>
                 	</tr>
     	 </thead> 
    	 <tbody> 
    	  
    	 <%     if(null != list && list.size()>0){
          				for(AskDTO vo   :list){  
		         %> 
		         
		         
					<tr><td rowspan="3">[가게이름] <%=vo.getShopName()%></td>	 
						<td>[유저아이디] <%=vo.getUserId()%></td> 
						<td>[문의상태] <%=vo.getAskState()%></td>	  
						 
						<td rowspan="3">
						 <input type="button"  data-hidden-info="" value="수정"  class="btn btn-outline-success "></td>
                 	</tr>  
					<tr><td>[문의날짜] <%=vo.getAskDate()%></td>	 
						<td>[요청사항] <%=vo.getShopName()%></td> 
		 				
						
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
<script src="/WEB02/assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>