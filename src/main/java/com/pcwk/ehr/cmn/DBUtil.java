package com.pcwk.ehr.cmn;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//왜 자꾸늘어나는거야
public class DBUtil {
	
	public static void close(Connection conn, PreparedStatement pstmt ) {
	
		if (null != pstmt) {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		}
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt,ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			}catch(SQLException e) {
				
			}
		}
		if (null != pstmt) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				
			}
		}
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}
	}
}






