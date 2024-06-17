<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/TWOREE/myPage/bootstrap.min.css"> 
<link rel="stylesheet" href="/a_myPage/css/style_p.css" > 
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
</head>
<body>
    <div class="menu">
          <img src="/TWOREE/myPage/img/user_icon1.png" width= 80px><br>
        <label for="uid">아이디 &nbsp</label>
        <ul>
            <li><a href="my_p.jsp">내프로필</a></li>
            <li><a href="my_r.jsp">예약</a></li>
            <li><a href="my_v.jsp">리뷰</a></li>
            <li><a href="my_a.jsp">고객문의</a></li>
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
        <h5>개인 정보</h5>
        <p></p>
        <div class="content_info">
            <ul>
                <li>
                    <label for="uid">아이디 &nbsp</label>
                    <input type="text" id="uid"   placeholder="4자 ~ 10자 사이, 공백없이" required> 
                </li>
                <li>
                    <label for="umail">이메일 &nbsp</label>
                    <input type="email" id="umail" placeholder="ex.@naver.com" required> 
                </li>
                <li>
                    <label for="upw">비밀번호 &nbsp</label>
                    <input type="password" id="upw" placeholder="문자와 숫자, 특수 기호 포함" required> 
                </li> 
            </ul>  
             <button type="button" class="btn btn-secondary" style="float: right;">수정하기</button>
        </div>
        
              <div class="content_info">
        
            <ul>
                <li>
                    <label for="uname">이름 &nbsp</label>
                    <input type="text" id="uname"   placeholder="ex.홍길동" required> 
                </li>
                <li>
                    <label for="utel">전화번호 &nbsp</label>
                    <input type="email" id="utel" placeholder="ex.010-1111-1111" required> 
                </li>
                <li>
                    <label for="ubirth">생년월일 &nbsp</label>
                    <input type="password" id="ubirth" placeholder="ex.990101" required> 
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
</html>
