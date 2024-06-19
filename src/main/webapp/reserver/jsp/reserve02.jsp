<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>예약하기</h1>
        <h5>✔️아래 내용이 맞는지 확인해 주세요.</h5>
        <div class="reservation-info">
            <p id="reservationText"></p>
        </div>

        <div class="customer-info">
            <h3>😀예약자 정보</h3>
            <label for="customerName">예약자:</label>
            <input type="text" id="customerName" name="customerName" placeholder="이름을 입력해 주세요.">

            <label for="customerPhone">연락처:</label>
            <input type="text" id="customerPhone" name="customerPhone" placeholder="연락처를 입력해 주세요.">

            <label for="customerEmail">이메일:</label>
            <input type="email" id="customerEmail" name="customerEmail" placeholder="이메일을 입력해 주세요.">

            <label for="customerRequest">요청사항:</label>
            <input type="text" id="customerRequest" name="customerRequest" placeholder="업체에 요청하실 내용을 적어주세요.">
        </div>
    </div>

    <div class="content_box">
        <button class="styled-button" onclick="location.href='index.html'">이전</button>
        <button class="styled-button" id="submitReservation">동의하고 예약신청</button>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            // localStorage에서 예약 정보 가져오기
            const reservationData = JSON.parse(localStorage.getItem('reservation'));

            if (reservationData) {
                // 예약 정보를 화면에 표시
                const reservationText = `일정: ${reservationData.date}, ${reservationData.time}, 인원: ${reservationData.participants}`;
                document.getElementById('reservationText').innerText = reservationText;
            } else {
                // 예약 정보가 없을 경우 처리 (예: 에러 메시지 표시 등)
                document.getElementById('reservationText').innerText = '예약 정보가 없습니다.';
            }

            // 페이지 이동 후 localStorage에서 예약 정보 삭제 (선택사항)
            localStorage.removeItem('reservation');
        });

        // "동의하고 예약신청" 버튼 클릭 시 이벤트 처리
        document.getElementById('submitReservation').addEventListener('click', function() {
            // 입력된 예약자 정보 확인
            const customerName = document.getElementById('customerName').value;
            const customerPhone = document.getElementById('customerPhone').value;
            const customerEmail = document.getElementById('customerEmail').value;
            const customerRequest = document.getElementById('customerRequest').value;

            // 예약자 정보 확인
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
