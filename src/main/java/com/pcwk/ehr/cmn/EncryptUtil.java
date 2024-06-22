package com.pcwk.ehr.cmn;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
	
	  static public String Encrypt(String text) throws NoSuchAlgorithmException {
		  
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        try {
				md.update(text.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return bytesToHex(md.digest());
	        
	    }
	    static public String bytesToHex(byte[] bytes) {
	    	
	        StringBuilder builder = new StringBuilder();
	        for (byte b : bytes) {
	            builder.append(String.format("%02x", b));	            
	        }
	        return builder.toString();
	    }

	}