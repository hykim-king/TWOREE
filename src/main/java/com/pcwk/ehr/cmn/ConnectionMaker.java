package com.pcwk.ehr.cmn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMaker implements PLog {
	
	final	static	String	DB_DRIVER	= "oracle.jdbc.driver.OracleDriver";
	final	static	String	DB_URL 		= "jdbc:oracle:thin:@118.33.104.105:1522:xe";
	final	static	String	DB_USER 	= "tworee";
	final	static	String	DB_PASSWORD = "reetwo";
	
	public ConnectionMaker() { 
		log.debug("ConnectionMaker()");
	}
	
	/**
	 * DB연결 정보 생성
	 * @return Connection
	 * */
	public Connection getConnection() {
		Connection conn = null;
		log.debug("1");
		try {
			Class.forName(DB_DRIVER);
			log.debug("2");
			
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			log.debug("3 connection : {}", conn);
			//파라메터로 연결할 수 있다.
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
