<%@page import="java.util.List"%>
<%@page import="com.pcwk.shop.ShopDTO"%>
<%@page import="com.pcwk.shop.ShopDetailDTO"%>
<%@page import="com.pcwk.ehr.cmn.SearchDTO"%>
<%@page import="com.pcwk.shop.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>
<%
	List<ShopDTO> list = (List<ShopDTO>)request.getAttribute("list");  
	SearchDTO searchCon = (SearchDTO)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/TWOREE/shop/css/bootstrap.css">
    <title>test</title>
    <link rel="stylesheet" href="/TWOREE/shop/css/poster.css">
    <script src="/TWOREE/shop/js/jquery_3_7_1.js"></script>
    <script>
    	
    document.addEventListener("DOMContentLoaded", function(){
  	
		const page_ul = document.querySelectorAll("#page_ul");
		const shopName = document.querySelector("#shopName");
		const shopTime = document.querySelector("#shopTime");
		const shopLoc = document.querySelector("#shopLoc");
		const shopScore = document.querySelector("#shopScore");
		const shopReviewCnt = document.querySelector("#shopReviewCnt");
		const shopNotice = document.querySelector("#shopNotice");
		const shopMenu = document.querySelector("#shopMenu");
		const shopReview = document.querySelector("#shopReview");
		
		//예약하기 버튼
		const reserveBtn = document.querySelector("#reserve_btn");
		
		//문의하기 버튼
		const askBtn = document.querySelector("#ask_btn");
		
		//이벤트 핸들러
		page_ul.forEach(function(page_ul){
			page_ul.addEventListener("click", function(){
				console.log("page_ul click");
				$.ajax({
	    		    type: "GET", 
	    		    url:"/TWOREE/shop/shop.do",
	    		    asyn:"true",
	    		    dataType:"html",
	    		    data:{
	    		        "work_div":"doSelectOne",
	    		        "shopName": shopName.value,
	    		        "shopTime": shopTime.value,
	    		        "shopLoc": shopLoc.value,
	    		        "shopScore": shopScore.value,
	    		        "shopReviewCnt": shopReviewCnt.value,
	    		        "shopNotice": shopNotice.value,
	    		        "shopMenu": shopMenu.value,
	    		        "shopReview": shopReview.value	
	    		    },
	    		    success:function(response){//통신 성공
	    		        console.log("success data:"+response);
	    		    
	    		    	//null, undefined
	    		    	if(response){
	    		    		try{
	    		    			const messageVO = JSON.parse(response);
	    		    			console.log("messageVO.messageId : " + messageVO.messageId);
	    		    			console.log("messageVO.msgContents : " + messageVO.msgContents);
	    		    			if(isEmpty(messageVO) == false && "1" === messageVO.messageId){
	    		    				alert(messageVO.msgContents);
	    		    				window.location.href = "/TWOREE/shop/shop.do?work_div=doRetrieve";
	    		    			}else{
	    		    				alert(messageVO.msgContents);
	    		    			}
	    		    		}catch(e){
	    		    			console.error("JSON Parsing error : " + e);
	    		    		}
	    		    		
	    		    	}else{
	    		    		console.warn("res가 null 혹은 undefined");
	    		    		alert(messageVO.msgContents);
	    		    	}
	    		    },
	    		    error:function(response){//실패시 처리
	    		            console.log("error:"+response);
	    		    }
	    	});
			});	
		});
		
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
    	    
    	    //seq
    	    frm.seq.value = seqValue;
    	    
    	    $.ajax({
    		    type: "GET", 
    		    url:"/WEB02/shop/shop.do",
    		    asyn:"true",
    		    dataType:"html",
    		    data:{
    		        "work_div":"doSelectOne",
    		        "shopName": shopName.value,
    		        "shopTime": shopTime.value,
    		        "shopLoc": shopLoc.value,
    		        "shopScore": shopScore.value,
    		        "shopReviewCnt": shopReviewCnt.value,
    		        "shopNotice": shopNotice.value,
    		        "shopMenu": shopMenu.value,
    		        "shopReview": shopReview.value	
    		    },
    		    success:function(response){//통신 성공
    		        console.log("success data:"+response);
    		    
    		    	//null, undefined
    		    	if(response){
    		    		try{
    		    			const messageVO = JSON.parse(response);
    		    			console.log("messageVO.messageId : " + messageVO.messageId);
    		    			console.log("messageVO.msgContents : " + messageVO.msgContents);
    		    			if(isEmpty(messageVO) == false && "1" === messageVO.messageId){
    		    				alert(messageVO.msgContents);
    		    				window.location.href = "/TWOREE/shop/shop.do?work_div=doRetrieve";
    		    			}else{
    		    				alert(messageVO.msgContents);
    		    			}
    		    		}catch(e){
    		    			console.error("JSON Parsing error : " + e);
    		    		}
    		    		
    		    	}else{
    		    		console.warn("res가 null 혹은 undefined");
    		    		alert(messageVO.msgContents);
    		    	}
    		    },
    		    error:function(response){//실패시 처리
    		            console.log("error:"+response);
    		    }
    	});
    };
    });
    </script>
</head>
<body>
    <hr>
    <div class="container">
        <form action="/TWOREE/shop/shop.do" name="board_frm" method="get" id="board_frm"  class="row g-2 align-items-center">
            <div class="col-sm-4">
            <input type="hidden" name="work_div"  id="work_div" placeholder="작업구분">
            <input type="hidden" name="page_no"   id="page_no"  placeholder="페이지 번호">        
            <input type="hidden" name="seq"       id="seq"      placeholder="순번">
            </div>
            <div class="row mb-2">
                <label for="search_div" class="col-sm-2 col-form-label">구분</label>
                <div class="col-sm-1">
                    <div>
                        <select name="search_div" class="form-control" id="search_div">
                            <option value="">전체</option>
                            <option value="10">가게명</option>
                            <option value="20">별점순</option>
                            <option value="30">리뷰순</option>
                        </select>    
                    </div>
                </div>
                <div class="col-sm-4">
                    <input type="search" name="search_word" class="form-control"  id="search_word" placeholder="가게명을 입력하세요  " >
                </div>
            </div>
        </form>
        <hr>
        <jsp:include page="MyPage.jsp" flush="false"/>
        <div class="main_page">
           	 	<%for(ShopDTO vo   :list){ %>
            <ul class="main_page_ul" id="page_ul">
                <li class="shop_name"> <%=vo.getShopName() %></li>
                <li> <%=vo.getShopLoc()%> </li>
                <li>별점 : <%=vo.getScore() %></li> 
            </ul>
                <%  } %>
        </div>
       <jsp:include page="ShopDetailPage.jsp" flush="false"/>
    </div>
<script src="/TWOREE/shop/js/popper_min.js"></script>
</body>
</html>