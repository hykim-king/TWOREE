package com.pcwk.ehr.cmn;

import java.util.List;

public interface WorkDlv<T> extends PLog {
/* WorkDlv  : 재정의하기위해. 
 *  
 *   +-+-+-+-+ +-+-+-+-+ +-+-+-+-+-+-+-+
     |M|i|n|i| |J|a|v|a| |P|r|o|j|e|c|t|
     +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     |2|0|2|4|.|0|4|.|2|4|              
     +-+-+-+-+-+-+-+-+-+-+
 */
/*
 * *** 회원 관리 프로그램 ***
 * 1. 회원 목록 조회
 * 2. 회원 단건 조회
 * 3. 회원 단건 저장
 * 4. 회원 단건 수정
 * 5. 회원  삭제
 * 6. 프로그램 종료
 */
	/**
	 * 목록 조회
	 * 
	 * @param search
	 * @return List<T>
	 */
	public List<T> doRetrieve(DTO search);

	/**
	 * 단건 저장
	 * 
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doSave(T param);

	/**
	 * 단건 수정
	 * 
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doUpdate(T param);

	/**
	 * 단건 삭제
	 * 
	 * @param param
	 * @return 성공(1)/실패(0)
	 */
	public int doDelete(T param);

	/**
	 * 단건 조회
	 * 
	 * @param param
	 * @return T
	 */
	public T doSelectOne(T param);

    public int doUpdateReadCnt(T param);

}