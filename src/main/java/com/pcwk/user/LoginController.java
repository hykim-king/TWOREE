package com.pcwk.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcwk.ehr.cmn.ControllerV;
import com.pcwk.ehr.cmn.JView;
import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.StringUtill;
import com.pcwk.user.UserDTO;

public class LoginController implements ControllerV, PLog {

	public LoginController() {
		log.debug("-------------------");
    	log.debug("LoginController()");
    	log.debug("-------------------");
    	    	
	}
	//로그인
	public JView login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("-------------------");
    	log.debug("login()");
    	log.debug("-------------------");
		
    	//데이터 읽기
    	String userId = StringUtill.nvl(request.getParameter("user_id"),"");
    	String userPw = StringUtill.nvl(request.getParameter("user_pw"),"");
    	
    	String viewName ="";
    	//id, 비번 일치하면 Session처리
    	if("jjj".equals(userId) && "4321".equals(userPw)) {
    		
    		//세션 객체 생성
    		HttpSession session = request.getSession();
    		
    		//회원 정보(세션 읽기)
    		UserDTO member = new UserDTO();
    		member.setUserId(userId);
    		member.setPassword(userPw);
    		member.setName("이상무");
    		
    		
    		//세션에 데이터 저장
    		session.setAttribute("member", member);
    		log.debug("세션 생성");
    		viewName = "/A_JSP/J04/j05_login_result.jsp";
    	}
    	
    	log.debug("user_id:{}",userId);
    	log.debug("user_pw:{}",userPw);
    	return new JView(viewName);
	}
	//로그아웃
	public JView logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("-------------------");
    	log.debug("logout()");
    	log.debug("-------------------");
		
    	HttpSession session = request.getSession();
    	//세션값을 지워버림
    	
    	log.debug("session()"+session);
    	String viewName = "";
    	if(null != session) {
    		log.debug("session()"+session);
    		session.invalidate();
    		viewName = "/A_JSP/J04/j05_login_result.jsp";
    	}
    	
    	
		return null;
	}
	
	
	
	@Override
	public JView doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("-------------------");
    	log.debug("doWork()");
    	log.debug("-------------------");
		
    	JView viewName = null;
    	
    	String workDiv = StringUtill.nvl(request.getParameter("work_div"),"");
    	log.debug("workDiv:{}",workDiv);
    	
    	switch(workDiv) {
    	case"login":
    		viewName = login(request, response);
    		break;
    	case"logout":
    		viewName = logout(request, response);
    		break;
    	}
    		
    	return viewName;
	}
	
}
