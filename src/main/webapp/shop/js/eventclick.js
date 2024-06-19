document.addEventListener("DOMContentLoaded", function(){
	
	//이벤트 핸들러
		rows.forEach(function(row){
			row.addEventListener("click", function(){
				console.log("row click");
				
				//this(tr) 자식 -> id: 마지막 위치
				let seqValue = this.querySelector('td:last-child').textContent.trim();
				console.log('seqValue : ' + seqValue);
				
				//폼 요소 선택
				let frm = document.getElementById("board_frm");
				//폼 데이터 설정
				frm.work_div.value = "doRetrieve";
				
				//seq
				frm.seq.value = seqValue;
				frm.action = "<%=cPath%>" + "/shop/shop.do";
				
				//폼 제출
				frm.submit();
			});	
		});
		
	//예약하기 버튼
	const reserveBtn = document.querySelector("#reserve_btn");
	
	//문의하기 버튼
	const askBtn = document.querySelector("#ask_btn");
	
	reserveBtn.addEventListener("click", function(event){
		console.log('reserveBtn click');
	
	
		let frm = document.getElementById("board_frm");
		
		frm.work_div.value = "reserveBtn";
		
		
		console.log("frm.work_div.value : " + frm.work_div.value);
		
		frm.action ="<%=cPath%>"+"/shop/shop.do";
		frm.submit();
	
	});
	
	askBtn.addEventListener("click", function(event){
		console.log('askBtn click');
	
	
		let frm = document.getElementById("board_frm");
		
		frm.work_div.value = "askBtn";
		
		
		console.log("frm.work_div.value : " + frm.work_div.value);
		
		frm.action ="<%=cPath%>"+"/shop/shop.do";
		frm.submit();
	
	});

	function doSelectOne(seqValue){
		
	    // 폼 요소 선택
	    let frm = document.getElementById("board_frm");
	    // 폼 데이터 설정
	    frm.work_div.value = "doSelectOne";  
	    
	    //seq
	    frm.seq.value = seqValue;
	    frm.action = "<%=cPath%>" + "/board/board.do";
	    
	    // 폼 제출
	    frm.submit(); 	
	}
	
});