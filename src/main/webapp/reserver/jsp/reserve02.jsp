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
        .reservation-info, .customer-info {
            border: 2px solid black;
            padding: 10px;
            margin-bottom: 20px;
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
            margin-top: 25px;
        }
        .styled-button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 3px 8px;
            cursor: pointer;
            border-radius: 12px;
        }
        .styled-button:hover {
            background-color: #45A049;
        }
        .checkbox-container {
            display: flex;
            align-items: center;
            margin-top: 15px;
        }
        .checkbox-container input {
            margin-right: 10px;
        }
        .terms-box {
            border: 1px solid #ddd;
            padding: 10px;
            margin-top: 10px;
            max-height: 100px;
            overflow-y: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>(๑・‿・๑) 예약 확인</h1>
        <h5>:두꺼운_확인_표시: 아래 내용이 맞는지 확인해 주세요.</h5>
        <div class="reservation-info">
            <p id="reservationText"></p>
        </div>
        <div class="customer-info">
            <h3>:활짝_웃는: 예약자 정보</h3>
            <label for="customerName">예약자:</label>
            <input type="text" id="customerName" name="customerName" placeholder="이름을 입력해 주세요.">
            <label for="customerPhone">연락처:</label>
            <input type="text" id="customerPhone" name="customerPhone" placeholder="연락처를 입력해 주세요.">
            <label for="customerEmail">이메일:</label>
            <input type="email" id="customerEmail" name="customerEmail" placeholder="이메일을 입력해 주세요.">
            <label for="customerRequest">요청사항:</label>
            <input type="text" id="customerRequest" name="customerRequest" placeholder="업체에 요청하실 내용을 적어주세요.">
        </div>
        <div class="checkbox-container">
            <input type="checkbox" id="termsCheckbox">
            <label for="termsCheckbox">개인정보 수집 및 이용에 동의합니다.</label>
        </div>
        <div class="terms-box">
            <h4>개인정보 수집 및 이용에 대한 안내</h4>
            <p>**는 예약 서비스 제공을 위해 최소한의 개인정보를 수집하고 있습니다. 수집된 개인정보는 예약 확인 및 관련 서비스 제공을 위해 사용됩니다.</p>
            <p>1. 수집 항목: 이름, 연락처, 이메일</p>
            <p>2. 이용 목적: 예약 확인 및 서비스 제공</p>
            <p>3. 보유 기간: 수집일로부터 1년</p>
            <p>자세한 내용은 [개인정보 처리방침](#)을 참고해 주세요.</p>
        </div>
    </div>
    <div class="content_box">
        <button class="styled-button" onclick="location.href='reserve02.jsp'">이전</button>
        <button class="styled-button" id="submitReservation">동의하고 예약신청</button>
    </div>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const reservationData = JSON.parse(localStorage.getItem('reservation'));
            if (reservationData) {
                const reservationText = `일정: ${reservationData.date}, ${reservationData.time}, 인원: ${reservationData.participants}`;
                document.getElementById('reservationText').innerText = reservationText;
            } else {
                document.getElementById('reservationText').innerText = '예약 정보가 없습니다.';
            }
            localStorage.removeItem('reservation');
        });
        document.getElementById('submitReservation').addEventListener('click', function() {
            const customerName = document.getElementById('customerName').value;
            const customerPhone = document.getElementById('customerPhone').value;
            const customerEmail = document.getElementById('customerEmail').value;
            const customerRequest = document.getElementById('customerRequest').value;
            const termsCheckbox = document.getElementById('termsCheckbox').checked;
            if (!termsCheckbox) {
                alert('개인정보 수집 및 이용에 동의해 주세요.');
                return;
            }
            if (customerName && customerPhone && customerEmail) {
                alert('예약이 완료되었습니다.\n\n' +
                      '예약자: ' + customerName + '\n' +
                      '연락처: ' + customerPhone + '\n' +
                      '이메일: ' + customerEmail + '\n' +
                      '요청사항: ' + (customerRequest || '없음'));
            } else {
                alert('모든 예약자 정보를 입력해 주세요.');
            }
        });
    </script>
</body>
</html>