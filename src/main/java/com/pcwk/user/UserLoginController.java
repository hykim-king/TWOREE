package com.pcwk.user;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.pcwk.ehr.cmn.ControllerV;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.JView;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.StringUtill;
import com.pcwk.user.UserDTO;

public class UserLoginController implements ControllerV, PLog {

	UserService service;
	
	public UserLoginController() {
		log.debug("-------------------");
    	log.debug("LoginController()");
    	log.debug("-------------------");
    	    	
	}
	//로그인
	public JView login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("-------------------");
    	log.debug("login()");
    	log.debug("-------------------");
		UserDTO inVO = new UserDTO();
    	
    	String userId = StringUtill.nvl(request.getParameter("user_id"),"");
    	String password = StringUtill.nvl(request.getParameter("password"),"");
    	
    	inVO.setUserId(userId);
    	inVO.setPassword(password);
    	
    	DTO dto = service.doUserSelect(inVO);
    	
    	MessageVO message = new MessageVO();
    	
    	
    	//id, 비번 일치하면 Session처리
    	if(dto instanceof UserDTO) {
    		UserDTO outVO = (UserDTO) dto;
    		log.debug("성공 outVO:{}",outVO);
    		
    		
    		//세션 객체 생성
    		HttpSession session = request.getSession();
    		
    		session.setAttribute("user", outVO);
    	
    		//30, 로그인 성공
    		message.setMessageId("30");
    		message.setMsgContents("로그인 성공");
    	
    	}else {
    		message = (MessageVO) dto;
    		log.debug("실패 message:{}",message);
    	}
	
	
	
	//ajax
	Gson gson = new Gson();
	String jsonString = gson.toJson(message);
	log.debug("jsonString:{}"+jsonString);
	
	response.setContentType("text/html; charset=UTF-8");
	
	PrintWriter out = response.getWriter();
	out.print(jsonString);
	JView viewName= new JView("");
	return viewName;
	}	
	
	
	//로그아웃
	public JView logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("-------------------");
    	log.debug("logout()");
    	log.debug("-------------------");
		
    	HttpSession session = request.getSession();

    	log.debug("session()"+session);
    	
    	String viewName = "";
    	if(null != session) {
    		log.debug("session()"+session);
    		session.invalidate();
    		viewName = "";
    	}
    	
    	
		return new JView(viewName);
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
    	
    	default:
    		log.debug("작업구분을 확인 하세요. workDiv:{}",workDiv);
    	break;
    	}	
    	return viewName;
	}
	
}
