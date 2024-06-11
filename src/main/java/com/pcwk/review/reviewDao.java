package com.pcwk.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pcwk.ehr.cmn.ConnectionMaker;
import com.pcwk.ehr.cmn.DBUtil;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.SearchDTO;
import com.pcwk.ehr.cmn.WorkDiv;


public class reviewDao implements WorkDiv<reviewDTO>, PLog{
	final static String DB_DRIVER = "oracle.jdbc.driver.oracleDriver";
	
	//jdbc:oracle:thin:@IP:PORT:전역 명칭(SID)
	
	final static String DB_URL = "";
	final static String DB_USER = "";
	final static String DB_PASSWORD = "";
	
	private ConnectionMaker connectionMaker;
	
	public  reviewDao() {
	
	}
	public Connection getConnection() {
		Connection conn = null;
		Log.debug("1");
		try {
			Class.forName(DB_DRIVER);
			Log.debug("2");
			
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Log.debug("3 conn: {}", conn);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	@Override
	public int dosave(reviewDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		
	}
	
}
