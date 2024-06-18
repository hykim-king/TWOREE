package com.pcwk.reserve;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcwk.ehr.cmn.ControllerV;
import com.pcwk.ehr.cmn.JView;
import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.StringUtill;
import com.pcwk.user.UserDTO;
import com.pcwk.user.UserService;

public class ReserveController implements ControllerV, PLog  {
private static final long serialVersionUID = 1L;
    
	ReserveService  service;
	//CodeService codeService;
	
	
	public ReserveController() {
		log.debug("-------------------");
    	log.debug("LoginController()");
    	log.debug("-------------------");
    	service = new ReserveService();
    	    	
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
    	
    	//UserDTO outVO = this.service.doSelectOne(inVO);
    	//log.debug("outVO:"+outVO); 
    	
    	
    	//request.setAttribute("outVO",outVO);
    	
    	
    
    return new JView("/myPage/jsp/my_p.jsp");
    
    }
	public JView doRetrieve(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
      	log.debug("-----------------");
    	log.debug("doRetrieve ()");
    	log.debug("-----------------");		
    	
    	ReserveDTO inVO = new ReserveDTO(); 
    	String userId = StringUtill.nvl(request.getParameter("userId"),"0");
    	
    	inVO.setUserId(userId);
    	log.debug("inVO:"+inVO);
    	
    	//this.service.selectOneReadCnt(inVO);
    	
    	List<ReserveDTO> list = this.service.doRetrieve(inVO);

    	request.setAttribute("list",list);
		
		 return new JView("/myPage/jsp/my_r.jsp");	
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
    		
    	case"doRetrieve ":
    		viewName = doRetrieve (request, response);
    		break; 
    		
    		
    	}
    		
    	return viewName;
	}
	
}
