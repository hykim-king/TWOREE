
	const pageList = document.querySelector("#page_list");
	
	const workDiv = document.querySelector('#work_div');
	const searchDiv = document.querySelector('#search_div');
	
	$(document).ready(function() {
		document.addEventListener('keydown', function(event) {
			if (event.keyCode === 13) {
			event.preventDefault();
			      
			  	
			let frm = document.getElementById("board_frm");
			let searchDivValue = document.querySelector("#search_div");
			
			// 폼 데이터 설정
			frm.work_div.value = "doRetrieve";
			frm.page_size.value = "6";
			frm.search_div.value = $('#search_div').val();
			
			      		  
			console.log(" frm.work_div.value: " +  frm.work_div.value);
			console.log(" frm.search_word.value: " +  frm.search_word.value);
			console.log(" frm.search_div.value: " +  frm.search_div.value);
			
			frm.action = "<%=cPath%>" + "/shop/shop.do";
			
			// 폼 제출
			frm.submit();
			
			const pageListObj = (<%= list %>);
		   	
		    $("#page_list").empty();
		    $.each(pageListObj, function(index, page) {
		    	let row = $("<ul onclick ='pageListBtn("+page.shopNo+")'></ul>");
		          row.append($("<li class='shop_name'></li>").text(page.shopName));
		          row.append($("<li></li>").text(page.shopLoc));
		          row.append($("<li></li>").text(page.reviewCnt));
		          //row.append($("<li></li>").text(page.shopNo));
		          $("#page_list").append(row);
		      });
		  }
		}, true);
	});
	
	
	function getShopNo(){
        return document.getElementById('shopNo');
      }
	
	const shopNo = getShopNo();
	
	function pageListBtn(shopNo){
		console.log("pageListBtn clicked");
		console.log("shopNo : " + shopNo);
		
		$.ajax({
		    type: "GET", 
		    url:"/TWOREE/shop/shop.do",
		    contentType : "application/json; charset:UTF-8",
		    asyn:"true",
		    dataType:"html",
		    data:{
		        "work_div":"doSelectOne",
		        "shopNo": shopNo
		    },
		    success:function(response){//통신 성공
		        console.log("success data:"+response);
		    	
		    	//null, undefined
		    	if(response){
	    		    	let jsonData = JSON.parse(response);
		    			let map = new Map(Object.entries(jsonData));
		    			console.log(map.get("shopList"));
	    		    	loadData(map);
		    		
		    	}else{
		    		console.warn("res가 null 혹은 undefined");
		    		alert(messageVO.msgContents);
		    	}
		    },
		    error:function(response){//실패시 처리
		            console.log("error:"+response);
		    }
		});//ajax end
		
	}
	
    
    $(document).ready(function() {
    	
    	$("#pageListBtn").click(function() {
           
        });
    	
    });
    

   	const pageListObj = (<%= list %>);
   	
	    $("#page_list").empty();
	    $.each(pageListObj, function(index, page) {
	    	let row = $("<ul onclick ='pageListBtn("+page.shopNo+")'></ul>");
	          row.append($("<li class='shop_name'></li>").text(page.shopName));
	          row.append($("<li></li>").text(page.shopLoc));
	          row.append($("<li></li>").text(page.reviewCnt));
	          //row.append($("<li></li>").text(page.shopNo));
	          $("#page_list").append(row);
	      });
   