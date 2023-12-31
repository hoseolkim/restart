package kr.or.ddit.actor.staff.service;

import kr.or.ddit.common.eunm.ServiceResult;
import kr.or.ddit.vo.PaginationInfo;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;
import kr.or.ddit.vo.SubjectVO;

/**
 * 학생, 교수의 상세정보 조회는
 * 각각의 Actor에서 제공하는 service로 요청
 *
 */
public interface StaffService {
	/**
	 * 신규 과목 개설
	 * 	1) 과목 코드로 이미 개설되어있는지 확인, 이미 개설되어있을 시 리턴
	 * 	2) 과목 개설
	 * @param subjectVO
	 * @return 이미 있는 과목일 시 ALREADYDONE, 성공 시 OK, 실패 시 FAIL
	 */
	public ServiceResult createSubject(SubjectVO subjectVO);
	/**
	 * 현재 개설되어있는 과목 목록 조회
	 * @param paging TODO
	 */
	public void retrieveSubjectList(PaginationInfo<SubjectVO> paging);
	/**
	 * 전체 교수 목록 조회
	 * @param paging TODO
	 */
	public void retrieveProfessorList(PaginationInfo<ProfessorVO> paging);

	/**
	 * 전체 학생목록 조회
	 * @param paging TODO
	 */
	public void retrieveStudentList(PaginationInfo<StudentVO> paging);
	/**
	 * 신규 교수 생성
	 * @param professorVO
	 * @return 성공 시 OK, 실패 시 FAIL
	 */
	public ServiceResult createProfessor(ProfessorVO professorVO);
	/**
	 * 신규 학생 생성
	 * @param studentVO
	 * @return 성공 시 OK, 실패 시 FAIL
	 */
	public ServiceResult createStudent(StudentVO studentVO);
	
	public ServiceResult removeStduent(String stdNo);
	
	public ServiceResult modifyStduent(StudentVO studentVO);
	
	public ServiceResult removeProffesor (String proCd);
}
