<%@page import="com.pcwk.reserve.ReserveDTO"%>
<%@page import="com.pcwk.user.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    List<ReserveDTO> list = (List<ReserveDTO>)request.getAttribute("list"); 
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/TWOREE/myPage/css/bootstrap.min.css">  

<script src="/WEB02/assets/js/jquery_3_7_1.js"></script>
<script>

//String list = (String)request.getAttribute("vo");


</script>

    <title>예약현황</title>
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
            <li><a href="my_p.jsp">내프로필</a></li>
            <li><a href="my_r.jsp">예약</a></li>
            <li><a href="my_v.jsp">리뷰</a></li>
            <li><a href="my_x.jsp">고객문의</a></li>
            
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
        <h5>전체 예약 정보</h5>
        <p></p>
     <div class="right-section">
        <!-- 버튼 -->
        <div class="mb-2 d-grid gap-2 d-md-flex justify-content-md-end"> 
          <button type="reset" class="btn btn-secondary"  value="" >새로고침</button> 
            <button type="button" class="btn btn-danger" value="" onClick="location.href=''">예약취소</button>
        </div>
        <!--// 버튼 ----------------------------------------------------------------->
       <div class="table-container">
          <table class="table table-hover">
          <thead>
                    <tr class="table-warning table-hover table-bordered" id="option_reserver">
                 	<th>예약정보</th>	
                 	<th>개인정보</th>	
                 	<th>메뉴</th>	
                 	<th>옵션</th>
                 	<th class="text_center col-sm-1">관리</th>
                 	</tr>
     	 </thead> 
    	 	<tbody> 
    	 	    <%     if(null != list && list.size()>0){
          				for(ReserveDTO vo   :list){  
		         %>   
    	 	
    	 	
    	 	
					<tr><td>가게이름<%=vo.getShopNo()%></td>	 
						<td>주문자<%=vo.getShopNo()%></td>   
						<td>전화번호<%=vo.getUserTel()%></td>    
						<td>예약상태<%=vo.getReserveDate()%></td>
						<td rowspan="2">
						 <input type="button"  data-hidden-info="" value="수정"  class="btn btn-outline-success btn-sm "></td>
            
					<tr><td>예약날짜<%=vo.getShopNo()%></td>
						<td>마감날짜<%=vo.getConfirmedDate()%></td>	 	 
						<td>인원수<%=vo.getPeople()%></td>	 
						<td>요청사항<%=vo.getUserComment()%></td>
						
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