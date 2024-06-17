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

    // 초기 인원 수 설정
    participantsSpan.textContent = participants;

    // 예약 확인 버튼 클릭 시 동작
    document.getElementById('confirmButton').addEventListener('click', function() {
        const selectedDate = document.getElementById('datePicker').value;
        const selectedTime = document.getElementById('timePicker').value;
        const participants = participantsSpan.textContent; // 수정된 부분

        // 예약 정보를 화면에 보여주는 코드
        let resultText = `일정: ${selectedDate}, ${selectedTime}, 인원: ${participants}`;
        document.getElementById('resultText').innerText = resultText;

        // 예약 정보를 서버로 보내는 코드
        const reservationData = {
            date: selectedDate,
            time: selectedTime,
            participants: participants
        };

        fetch('http://example.com/reserve', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(reservationData)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Reservation successful:', data);
            // 서버로부터의 응답 처리 (예약 성공 메시지 또는 다른 처리 로직 추가)

            // 예약 정보를 화면에 다시 표시할 수 있음
            document.getElementById('resultText').innerText = resultText + ' - 예약 완료!';
        })
        .catch(error => {
            console.error('Error during reservation:', error);
            // 예약 실패 처리 또는 오류 메시지 표시
            document.getElementById('resultText').innerText = resultText + ' - 예약 실패: ' + error.message;
        });
    });
});
