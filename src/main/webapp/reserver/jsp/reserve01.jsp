<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약 확인</title>
    <link rel="stylesheet" href="style.css">
        <style>
            
            body {
                margin: 0;
                padding: 0;
                background: rgb(126, 121, 121);
            }
            #con_layout {
                width :1060px;
                padding: 0 20px;
                background: #FFF;
                height: 800px;
                margin: 0 auto; 
            }
            .header { 
                background:beige ;
                width:1020px;
                
                height: 160px;
                padding: 20px;
             
                border-radius:0 0 20px  20px;
                text-align: center;
            }
            .h2_t40 {
            margin : 40px 0 10px 0;
            }
            .h4_t10 {
                margin: 10px 0;
            }
            .top {
                width: 1020px;
                padding: 20px;
                background: rgb(251, 169, 197);
                border-radius:20px;
            }
            ul {
                overflow: hidden;
                width: 420px;
                margin: 0 auto;
                padding: 0;
            }
            li {
                list-style: none;
                float: left;
                padding: 0 20px;
                width: 100px;
                text-align: center;
                font-weight: bold;
            }
           
            a { text-decoration: none; }
            a:link { color:rgb(14, 14, 76);}
            a:visited { color:rgb(14, 14, 76);}
            a:hover { color:rgba(182, 9, 194, 0.471);}

            
            

        </style>
    </head>
    <body>
        <div id="con_layout">
            <div class="header">
                <h1 class="h2_t40">로쏘1924 나폴리 피자(예시) </h1>
                <h4 class="h4_t10"></h4>네이버 예약 방문하시면 어쩌구 저쩌구 샬라샬라</h4>
            </div>

            <div class="top">
                <ul>
                     <li> <a href="reserve02.jsp">예약하기</a> </li>
                     <li> <a href="reserve04.jsp">상세정보</a> </li>
                     <li> <a href="">리뷰</a> </li>
                       
            </ul>
            </div>

            <div class="content_box1">
                <div class="content_pic01">
                   

            
            

            
                    </div>
                </div>
            </div>
            
        </div>
    </body>
</html>