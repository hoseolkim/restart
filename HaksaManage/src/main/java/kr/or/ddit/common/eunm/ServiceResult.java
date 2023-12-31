package kr.or.ddit.common.eunm;

public enum ServiceResult {
	OK
	, FAIL
	/**
	 * 이미 수강신청 했거나, 이미 개설된 과목을 개설하려고 할 때
	 */
	, ALREADYDONE
	/**
	 * 수강인원 제한
	 */
	, LIMITED
	/**
	 * 아이디, 학번 등 중복에 관한 결과
	 */
	,DUPLICATED
	
	, INVALIDPASSWORD
	
	, NOTPOSSIBLE
}