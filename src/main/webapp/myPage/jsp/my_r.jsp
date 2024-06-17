<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/TWOREE/myPage/bootstrap.min.css"> 
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
            background-color:#ECBD58;
        }
        
          .resever_now {
          	margin-top: 10px;
            flex-grow: 1; /* 남은 공간을 차지하도록 설정 */
            padding: 20px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            overflow: auto; /* 내용이 넘칠 경우 스크롤 생성을 위해 */
            border-radius: 10px; /* 모서리를 둥글게 */
            background-color:#FFFFFF;
        }
        
           .resever_pass {
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
            <li><a href="my_p.jsp">내프로필</a></li>
            <li><a href="my_r.jsp">예약</a></li>
            <li><a href="my_v.jsp">리뷰</a></li>
            <li><a href="my_m.jsp">고객문의</a></li>
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
        <h5>현재 예약 정보</h5>
        <p></p>
        <div class="resever_now">
            <ul>
                <li>
                    <label for="reserveId">예약번호 &nbsp</label>
                    <input type="text" id="reserveId"   readonly> <!-- disabled는 폼값전달안됌 -->
                    &nbsp
                    <label for="reserveState">예약상태 &nbsp</label> 
                    <input type="text" id="reserveState"   placeholder="예약진행중" required > 
                </li>
               
                <li>
                    <label for="sname">가게이름 &nbsp</label>
                    <input type="text" id="sname"   readonly> <!-- disabled는 폼값전달안됌 --> 
                    &nbsp
                    <label for="yyddmm">날짜/시간 &nbsp</label>
                    <input type="datetime-local" id="yyddmm" placeholder="YYYY/DD/MM" required>
                </li>
                <li>
                    <label for="people">인원수 &nbsp</label> 
                    <input type="text" id="people" placeholder="숫자" readonly>명
                </li> 
                <li>
                	<label for="menu">메뉴 &nbsp</label>
                    <input type="text" id="menu" placeholder="메뉴이름" readonly> &nbsp
                    <label for="price">가격 &nbsp</label>
                    <input type="" id=""price"" placeholder="" readonly>원
                     </li>
                     
                <li>
                    <label for="ucomment">주문 요청 사항 &nbsp</label> 
                    <textarea style="resize: both;"></textarea> 
                </li>    
            </ul>  
             <button type="button" class="btn btn-danger" style="float: right;">예약취소</button>
        </div>
        <br>
         <h5>지난 예약 정보</h5>
         <button type="button" class="btn btn-dark" onClick="location.href='option_r.jsp'">전체내역보기</button> 
        <div class="resever_pass"> 
            <ul>
                <li>
                    <label for="reserveId">예약번호 &nbsp</label>
                    <input type="text" id="reserveId"   readonly> <!-- disabled는 폼값전달안됌 -->
                    &nbsp
                    <label for="reserveState">예약상태 &nbsp</label> 
                    <input type="text" id="reserveState"   placeholder="예약완료" required > 
                </li>
               
                <li>
                    <label for="sname">가게이름 &nbsp</label>
                    <input type="text" id="sname"   readonly> <!-- disabled는 폼값전달안됌 --> 
                    &nbsp
                    <label for="yyddmm">날짜/시간 &nbsp</label>
                    <input type="datetime-local" id="yyddmm" placeholder="YYYY/DD/MM" required>
                </li>
                
            </ul>  
             <button type="button" class="btn btn-secondary" style="float: right;">상세보기</button>
        </div>
        
        
    </div>
</body>
</html>
