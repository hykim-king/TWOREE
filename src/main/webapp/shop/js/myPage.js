/**
 * 
 */
 
 $(document).ready(function() {
		const reserveConfirmBtn = document.querySelector("#to_my_page");
		     	
		reserveConfirmBtn.addEventListener("click", function(event){
	     		console.log("to_my_page click event" + event)
	     		to_my_page();
	     	});
		
    	function to_my_page(){
    		console.log('to_my_page()');
    		window.location.replace("/TWOREE/user/myPage.do?work_div=doSelectOne");
    		//window.location.href = "/TWOREE/shop/shop.do?work_div=";
    	}
    });
    	