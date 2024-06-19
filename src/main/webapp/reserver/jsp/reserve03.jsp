<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약 확인</title>
    <link rel="stylesheet" href="style.css">
    <style>
        /* 기본 스타일 */
        body, html {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }

        /* 헤더 스타일 */
        .header {
            background-color: #4CAF50;
            padding: 10px 0;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 1000;
        }
        .header .logo {
            margin-left: 20px;
            font-size: 24px;
            font-weight: bold;
        }
        .header .nav-links {
            display: flex;
            margin-right: 20px;
        }
        .header .nav-links a {
            color: white;
            text-decoration: none;
            margin: 0 10px;
            font-size: 16px;
        }
        .header .login-button {
            background-color: white;
            color: #4CAF50;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
        }

        /* 푸터 스타일 */
        .footer {
            background-color: #f1f1f1;
            padding: 10px 0;
            text-align: center;
            margin-top: 50px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
        .footer p {
            margin: 0;
            color: #555;
        }

        /* 메인 컨텐츠 스타일 */
        .reservation-info, .customer-info {
            border: 2px solid black;
            padding: 10px;
            margin-bottom: 20px;
            margin-top: 80px; /* 헤더를 피하기 위해 */
        }
        .customer-info input {
            margin-bottom: 10px;
            width: 100%;
            padding: 5px;
            box-sizing: border-box;
        }
        .content_box {
            display: flex;
            justify-content: center;
            ma
