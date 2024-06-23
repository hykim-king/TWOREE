/**
 * 
 */
 const detailPageDiv = document.querySelector("#detail_page");
	
	function loadData(data) {
		
		let shopListObj =data.get("shopList");
		let detailListObj =data.get("detailList");
		let noticeListObj =data.get("noticeList");
		let menuListObj =data.get("menuList");
		let reviewListObj =data.get("reviewList");
		
		console.log("shopListObj : "+ shopListObj);
		console.log("detailListObj : "+ detailListObj);
		console.log("noticeListObj : "+ noticeListObj);
		console.log("menuListObj : "+ menuListObj);
		console.log("reviewListObj : "+ reviewListObj);
		 
		 $("#shopName").text(shopListObj.shopName);
         $("#shopOpenTime").text(detailListObj.openTime);
         $("#shopCloseTime").text(detailListObj.closeTime);
         $("#shopLoc").text(detailListObj.shopLoc);
         $("#shopScore").text(shopListObj.score);
         $("#shopReviewCnt").text(shopListObj.reviewCnt);
         
         $("#shopNotice").empty();
         $.each(noticeListObj, function(index, notice) {
               let li = $("<li></li>");
               li.append($("<li class='small_size_word'></li>").text(notice.openTime));
               li.append($("<li class='small_size_word'></li>").text(notice.closeTime));
               li.append($("<li class='middle_size_word'></li>").text(notice.content));
               li.append($("<li class='small_size_word'></li>").text(menu.noticeWrtDate));
               $("#shopNotice").append(li);
         });
        
         $("#menuList").empty();
         $.each(menuListObj, function(index, menu) {
               let li = $("<li></li>");
               li.append($("<li></li>").text(menu.menuName));
               li.append($("<li></li>").text(menu.menuInfo));
               li.append($("<li></li>").text(menu.price));
               $("#menuList").append(li);
         });
         
         $("#reviewList").empty();
         $.each(reviewListObj, function(index, review) {
               let li = $("<li></li>");
               li.append($("<li></li>").text(review.userId));
               li.append($("<li></li>").text(review.reviewContent));
               li.append($("<li></li>").text(review.score));
               $("#shopReview").append(li);
           });
         
       //예약하기 버튼
     	const moveToReserveBtn = document.querySelector("#reserve_btn");
     	
     	moveToReserveBtn.addEventListener("click", function(event){
     		console.log("moveToReserveBtn click event" + event)
     		moveToReserve();
     	});
     	
     	function moveToReserve(){
     		console.log('moveToReserve()');
     		let shopNo = shopListObj.shopNo;
     		console.log("shopNo : " + shopNo);
     		window.open("/TWOREE/shop/shop.do"+"?work_div=reserve&shopNo="+shopNo,"예약","width=700,height=700,top=100,left=100");
     		//window.location.href = "/TWOREE/shop/shop.do?work_div=";
     	}
     	
     	//문의하기 버튼
     	const askBtn = document.querySelector("#ask_btn");
     	
     	askBtn.addEventListener("click", function(event){
     		console.log("askBtn click event" + event)
     		ask();
     	});
     	
     	function ask(){
     		console.log('ask()');
     		let shopNo = shopListObj.shopNo;
     		console.log("shopNo : " + shopNo);
     		//window.location.href = "/TWOREE/shop/shop.do?work_div=";
     	}
	}
	