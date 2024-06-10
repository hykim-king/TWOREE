package com.pcwk.ehr.cmn;

import java.util.UUID;


public class StringUtill {
	/**
	 * request null 처리
	 * @param request
	 * @param paramName
	 * @param defaultValue
	 * @return
	 */
	
	public static String nvl(String value, String defaultValue) {
		if(null == value || value.trim().isEmpty()) {
			return defaultValue;
		}
		
		return value;
	}

	public static String getUUID() {
		UUID uuidTemp = UUID.randomUUID();
		
		return uuidTemp.toString().replaceAll("-", "");
	
	}
	
}
