<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
=======

>>>>>>> ffedc42ed2719d9bdcc2c0368dab396100fa048f
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>피자가게 예약 시스템</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>피자가게 예약 시스템</h1>
        <p>피자를 파는 가게입니다.</p>
        
        <div class="calendar">
            <input type="date" id="datePicker" min="2024-06-18" max="2024-8-31">
        </div>
        <div class="time-picker">
            <select id="timePicker">
                <option value="" disabled selected>시간 선택</option>
                <option value="오전 10:00">오전 10:00</option>
                <option value="오전 10:30">오전 10:30</option>
                <option value="오전 10:30">오전 10:30</option>
                <option value="오전 11:00">오전 11:00</option>
                <option value="오전 11:30">오전 11:30</option>
                <option value="오후 12:00">오후 12:00</option>
                <option value="오후 12:30">오후 12:30</option>
                <option value="오후 1:00">오후 1:00</option>
                <option value="오후 1:30">오후 1:30</option>
                <option value="오후 2:00">오후 2:00</option>
                <option value="오후 2:30">오후 2:30</option>
                <option value="오후 3:00">오후 3:00</option>
                <option value="오후 3:30">오후 3:30</option>
                <option value="오후 4:00">오후 4:00</option>
                <option value="오후 4:30">오후 4:30</option>
                <option value="오후 5:00">오후 5:00</option>
                <option value="오후 5:30">오후 5:30</option>
            </select>
        </div>
        <label for="participants">인원:</label>
        <span id="participants">1</span>
        <button id="increaseButton">+</button>
        <button id="decreaseButton">-</button>

        <br><br>
        
        <button id="confirmButton" onclick="confirmReservation()">예약 확인</button>
        <div class="result">
            <p id="resultText"></p>
        </div>
    </div>

    <div class="content_box">
<<<<<<< HEAD
        <button class="styled-button" onclick="location.href='reserve01.jsp'">이전</button>
        <button class="styled-button" onclick="location.href='reserve03.jsp'">다음</button>
=======
        <button class="styled-button" onclick="location.href='reserve02.jsp'">이전</button>
        <button class="styled-button" id="submitReservation">동의하고 예약신청</button>
>>>>>>> ffedc42ed2719d9bdcc2c0368dab396100fa048f
    </div>

    <script>
        function confirmReservation() {
            let participants = parseInt(document.getElementById('participants').textContent);
            const selectedDate = document.getElementById('datePicker').value;
            const selectedTime = document.getElementById('timePicker').value;

            // 예약 정보를 localStorage에 저장
            const reservationData = {
                date: selectedDate,
                time: selectedTime,
                participants: participants
            };
            localStorage.setItem('reservation', JSON.stringify(reservationData));

            // 예약 정보를 화면에 보여주는 코드
            let resultText = `일정: ${selectedDate}, ${selectedTime}, 인원: ${participants}`;
            document.getElementById('resultText').innerText = resultText;
        }

        document.addEventListener('DOMContentLoaded', function() {
            let participants = 1;
            const participantsSpan = document.getElementById('participants');
            const increaseButton = document.getElementById('increaseButton');
            const decreaseButton = document.getElementById('decreaseButton');

            increaseButton.addEventListener('click', function() {
                participants++;
                participantsSpan.textContent = participants;
            });

            decreaseButton.addEventListener('click', function() {
                if (participants > 1) {
                    participants--;
                    participantsSpan.textContent = participants;
                }
            });
        });
    </script>
   
</body>
</html>