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

public class UserController implements ControllerV, PLog {

	
	private static final long serialVersionUID = 1L;
    
	UserService  service;
	//CodeService codeService;
	
	
	public UserController() {
		log.debug("-------------------");
    	log.debug("LoginController()");
    	log.debug("-------------------");
    	service = new UserService();
    	    	
	} 
	public JView doSelectOne(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
      	log.debug("-----------------");
    	log.debug("doSelectOne()");
    	log.debug("-----------------");		
    	
    	UserDTO inVO = new UserDTO(); 
    	String userId = StringUtill.nvl(request.getParameter("userId"),"0");
    	
    	inVO.setUserId(userId);
    	log.debug("inVO:"+inVO);
    	
    	//this.service.selectOneReadCnt(inVO);
    	
    	UserDTO outVO = this.service.doSelectOne(inVO);
    	log.debug("outVO:"+outVO); 
    	
    	
    	request.setAttribute("outVO",outVO);
    	
    	
    
    return new JView("/myPage/jsp/my_p.jsp");
    
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
    	case"doSelectOne":
    		viewName = doSelectOne(request, response);
    		break; 
    	}
    		
    	return viewName;
	}
	
}
