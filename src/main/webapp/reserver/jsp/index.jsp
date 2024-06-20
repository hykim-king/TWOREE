<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인 페이지</title>
    <style>
        /* 본문 스타일링 */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh; /* 최소 화면 높이 */
            padding-top: 50px; /* 헤더 높이만큼 패딩 */
            padding-bottom: 50px; /* 푸터 높이만큼 패딩 */
            box-sizing: border-box;
        }
        main {
            flex: 1;
            padding: 20px;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>

    <main>
        <!-- 여기에 본문 내용을 추가할 수 있습니다 -->
        <h2></h2>
        <p></p>
    </main>

    <%@ include file="footer.jsp" %>
</body>
</html>
