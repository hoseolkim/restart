package kr.or.ddit.actor.staff.dao;

import java.util.List;

import kr.or.ddit.vo.PaginationInfo;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;
import kr.or.ddit.vo.SubjectVO;

public interface StaffDAO {
	/**
	 * 개설할 수 있는 과목 추가
	 * @param subjectVO
	 * @return 성공 시 ( >=1)
	 */
	public int insertSubject(SubjectVO subjectVO);
	/**
	 * 과목코드로 이미 개설된 과목인지 확인
	 * @param subCd 과목 코드
	 * @return 개설 가능 시 0 반환, 이미 개설되어있을 경우 ( >=1)
	 */
	public int selectSubject(String subCd);
	/**
	 * 개설되어있는 과목 목록 조회
	 * @return
	 */
	public List<SubjectVO> selectSubjectList();
	/**
	 * 모든 교수 목록 조회
	 * @param paging TODO
	 * @return List size로 판단
	 */
	public List<ProfessorVO> selectProfessorList(PaginationInfo<ProfessorVO> paging);
	/**
	 * 교수 상세정보 조회
	 * @param proCd 교수 코드
	 * @return 없다면 null, 있다면 ProfessorVO
	 */
	public ProfessorVO selectProfessor(String proCd);
	/**
	 * 모든 학생 조회
	 * @param paging TODO
	 * @return List size로 판단
	 */
	public List<StudentVO> selectStudentList(PaginationInfo<StudentVO> paging);
	/**
	 * 신규 학생 입력
	 * @param studentVO
	 * @return 성공 시 ( >=1)
	 */
	public int insertStudent(StudentVO studentVO);
	/**
	 * 신규 교수 입력
	 * @param studentVO
	 * @return 성공 시 ( >=1)
	 */
	public int insertProfessor(ProfessorVO professorVO);
	
	public int deleteStudent(String stdNo);
	
	public int updateStudent(StudentVO studentVO);
	   
	public int deleteProffesor (String proCd);
	/**
	 * 교수 리스트 출력을 위한 totalCount 조회
	 * @param paging
	 * @return
	 */
	public int selectProfessorTotalCount(PaginationInfo<ProfessorVO> paging);
	/**
	 * 학생 리스트 출력을 위한 totalCount 조회
	 * @param paging
	 * @return
	 */
	public int selectStudentTotalCount(PaginationInfo<StudentVO> paging);
}
