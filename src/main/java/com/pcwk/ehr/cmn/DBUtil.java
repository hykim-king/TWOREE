package com.pcwk.ehr.cmn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
<<<<<<< HEAD
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
=======
	//close
	public static void close(Connection conn,PreparedStatement pstmt) {
		if(null != pstmt) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				
			}
		}
		
		if(null != conn) {
			try {
				conn.close();
			} catch(SQLException e) {
				
>>>>>>> c505a575be35c76359fe71d8cb37dc7b79582b6c
			}
		}
	}
	
<<<<<<< HEAD
	public static void close(Connection conn, PreparedStatement pstmt,ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			}catch(SQLException e) {
				
			}
		}
		if (null != pstmt) {
=======
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		if(null != pstmt) {
>>>>>>> c505a575be35c76359fe71d8cb37dc7b79582b6c
			try {
				pstmt.close();
			} catch (SQLException e) {
				
			}
		}
<<<<<<< HEAD
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
=======
		
		if(null != conn) {
			try {
				conn.close();
			} catch(SQLException e) {
				
			}
		}
		
		if(null != rs) {
			try {
				rs.close();
			} catch(SQLException e) {
>>>>>>> c505a575be35c76359fe71d8cb37dc7b79582b6c
				
			}
		}
	}
<<<<<<< HEAD
}






=======

}
>>>>>>> c505a575be35c76359fe71d8cb37dc7b79582b6c
