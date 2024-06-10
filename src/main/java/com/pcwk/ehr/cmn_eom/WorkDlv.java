package com.pcwk.ehr.cmn_eom;

import java.util.List;

public interface WorkDlv<T> extends PLog {
/* WorkDlv  : ?û¨?†ï?ùò?ïòÍ∏∞ÏúÑ?ï¥. 
 *  
 *   +-+-+-+-+ +-+-+-+-+ +-+-+-+-+-+-+-+
     |M|i|n|i| |J|a|v|a| |P|r|o|j|e|c|t|
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     |2|0|2|4|.|0|4|.|2|4|              
     +-+-+-+-+-+-+-+-+-+-+
 */
 
	/**
	 * doRetrieve
	 * 
	 * @param search
	 * @return List<T>
	 */
	public List<T> doRetrieve(DTO search);

	/**
	 * doSave
	 * 
	 * @param param
	 * @return ?Ñ±Í≥?(1)/?ã§?å®(0)
	 */
	public int doSave(T param);

	/**
	 * doUpdate
	 * 
	 * @param param
	 * @return ?Ñ±Í≥?(1)/?ã§?å®(0)
	 */
	public int doUpdate(T param);

	/**
	 * doDelete
	 * 
	 * @param param
	 * @return ?Ñ±Í≥?(1)/?ã§?å®(0)
	 */
	public int doDelete(T param);

	/**
	 * doSelectOne
	 * 
	 * @param param
	 * @return T
	 */
	public T doSelectOne(T param);

    public int doUpdateReadCnt(T param);

}