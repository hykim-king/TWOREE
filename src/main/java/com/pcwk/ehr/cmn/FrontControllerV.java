package com.pcwk.ehr.cmn;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcwk.reserve.ReserveController;
import com.pcwk.shop.ShopController;
import com.pcwk.user.UserController;
import com.pcwk.user.UserLoginController;

//import com.pcwk.ehr.board.BoardController;
//import com.pcwk.ehr.servlet.ConnectController;
//import com.pcwk.ehr.servlet.CookieController;
//import com.pcwk.ehr.servlet.LoginController;

/**
 * Servlet implementation class FrontControllerV
 */
@WebServlet("*.do")
public class FrontControllerV extends HttpServlet implements PLog {
	private static final long serialVersionUID = 1L;
       
	//URL과, ControllerV 맵핑해준다.
	private Map<String, ControllerV> controllerMap = new HashMap<String, ControllerV>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerV() {    
    	log.debug("FrontControllerV()");
    	
    	controllerMap.put("/TWOREE/login/login.do", new UserLoginController());
    	controllerMap.put("/TWOREE/shop/shop.do", new ShopController());
    	controllerMap.put("/TWOREE/user/myPage.do", new UserController());
//    	controllerMap.put("/WEB02/board/board.do", new BoardController());
//    	controllerMap.put("/WEB02/connect/connect.do", new ConnectController());
//    	controllerMap.put("/WEB02/cookie/cookie.do", new CookieController());
//    	controllerMap.put("/WEB02/login/login.do", new LoginController());

    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		log.debug("requestURI:{}",requestURI);
		
		//controllerV:com.pcwk.ehr.board.BoardController@47eaa5bb
		ControllerV controller= controllerMap.get(requestURI);
		log.debug("controllerV:{}",controller);
	
		//controller가 null 이면 404 예외
		if(null == controller) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		//request 인코딩 처리"
    	request.setCharacterEncoding("UTF-8");
		
		//각각의 dowork를 호출한다. 
		log.debug("service:1");
		JView jview = controller.doWork(request, response);
		log.debug("service:2");
		log.debug("jview:{}",jview);  
		
		//각각의 컨트롤러가 forward 로직을 제대로 수행하고 있는지 하나하나
		//신경쓸 필요가 없고 JView 객체만 제대로 반환한다면 무리없이 작동한다.
		if(null != jview && jview.getViewName().length()>1) {
			jview.render(request, response);
		}
	}

}
