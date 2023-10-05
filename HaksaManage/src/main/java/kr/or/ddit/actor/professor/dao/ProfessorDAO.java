package kr.or.ddit.actor.professor.dao;

import java.util.List;

import kr.or.ddit.vo.ClassVO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.PaginationInfo;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;
import kr.or.ddit.vo.SubjectVO;

public interface ProfessorDAO {
	/**
	 * 교수 상세정보 조회
	 * @param proCd
	 * @return 없을 시 null
	 */
	public ProfessorVO selectProfessor(String proCd);
	/**
	 * 한 교수가 강의하는 과목 목록 조회
	 * @param proCd
	 * @return List size로 판단
	 */
	public List<LectureVO> selectLectureList(String proCd);
	/**
	 * 한 과목의 수강생 목록 조회
	 * @param lecCd
	 * @return List size로 판단
	 */
	public List<ClassVO> selectStudentListOnLecture(PaginationInfo paging);
	
	/**
	 * totalRecord 조회
	 * @return
	 */
	public int selectTotalRecord(PaginationInfo<ClassVO> paging);
	/**
	 * 담당 학생 조회
	 * @param proCd
	 * @return
	 */
	public List<StudentVO> selectResponsStudentList(String proCd);
	/**
	 *
		SELECT *
		FROM SUBJECT
		WHERE
		SUB_CD NOT IN (SELECT SUB_CD FROM LECTURE WHERE PRO_CD = #{proCd})
	 * 
	 * 한 교수가 신규 강의 개설 가능한 과목 목록 조회
	 * @param proCd
	 * @return List size로 판단
	 */
	public List<SubjectVO> selectCreatalbeLecture(String proCd);
	
	/**
	 * 새로운 강좌 개설
	 * @param lectureVO
	 * @return 성공 시 ( >= 1)
	 */
	public int insertLecture(LectureVO lectureVO);
	/**
	 * 입력과 수정은 둘 다 같은 쿼리를 사용하는 update문이라 메소드 하나로 가능
	 * 학생 성적 입력/수정
	 * @param classVO
	 * @return 성공 시 ( >= 1)
	 */
	public int updateClassScore(ClassVO classVO);
	/**
	 * 교수 전화번호 수정
	 * @param professorVO
	 * @return 성공 시 ( >= 1)
	 */
	public int updateProfessorTel(ProfessorVO professorVO);

}