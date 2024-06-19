package com.pcwk.ask;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.pcwk.ehr.cmn.ControllerV;
import com.pcwk.ehr.cmn.JView;
import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.StringUtill; 
import com.pcwk.reserve.ReserveService;

public class AskController  extends HttpServlet implements ControllerV, PLog {
	private static final long serialVersionUID = 1L;
		AskService  service;
		 
	    public AskController() {
	    	log.debug("-----------------");
	    	log.debug("BoardController()");
	    	log.debug("-----------------");		 
	    	
	    	service = new AskService(); 
	    }
		
		@Override
		public JView doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	log.debug("-----------------");
	    	log.debug("doWork()");
	    	log.debug("-----------------");			
		
    	JView  viewName = null;
    	
    	//request ���ڵ� ó��:
    	request.setCharacterEncoding("UTF-8");
    	
 
    	
    	String workDiv = StringUtill.nvl( request.getParameter("work_div"),"");
        log.debug("workDiv : {} ",workDiv);
        
        switch(workDiv) { 
        
        case "doUpdate":
        	//viewName = doUpdate(request,response);
        	//break; 
        	
        }
    	return viewName;
    	 
       }
    	/**
    	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	log.debug("-----------------");
        	log.debug("doGet()");
        	log.debug("-----------------");				
    		doWork(request,response);
    	}

    	/**
    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	log.debug("-----------------");
        	log.debug("doPost()");
        	log.debug("-----------------");				
    		doWork(request,response);
    	}



    }