<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>헤더와 푸터 만들기</title>
<style>
  /* 기본적인 스타일링 */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    min-height: 100vh; /* 최소 화면 높이 */
  }
  header, footer {
    background-color: #333;
    color: white;
    padding: 10px;
    display: flex;
    justify-content: space-between; /* 요소들을 양쪽 끝으로 배치 */
    align-items: center; /* 세로 중앙 정렬 */
  }
  header h1, footer p {
    margin: 0;
    font-size: 1.5rem;
  }
  .login-btn {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    font-size: 16px;
    cursor: pointer;
  }
  .contact-info {
    text-align: right;
  }
  footer {
    position: fixed;
    bottom: 0;
    width: 100%;
  }
</style>
</head>
<body>
<header>
  <h1 style="flex: 1; text-align: center;">TWOREE</h1>
  <button class="login-btn">로그아웃</button>
</header>

<main style="flex: 1;">
  <!-- 여기에 본문 내용을 추가할 수 있습니다 -->
</main>

<footer>
  <p><h5>&copy;이성연,엄기은,임강혁,박수연,이무원</p></h5>
 
  <p class="contact-info">Contact us: contact@tworee.com | +1-234-567-890</p>
</footer>
</body>
</html>
