package kr.or.ddit.actor.professor.service;

import java.util.List;

import kr.or.ddit.common.eunm.ServiceResult;
import kr.or.ddit.vo.ClassVO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;
import kr.or.ddit.vo.SubjectVO;

public interface ProfessorService {
	/**
	 * 교수 상세 정보 조회
	 * @param proCd 없을 시 null 반환
	 * @return
	 */
	public ProfessorVO retrieveProfessor(String proCd);
	/**
	 * 한 교수가 강의하는 과목 목록 조회
	 * @param proCd
	 * @return List size로 판단
	 */
	public List<LectureVO> retrieveLectureList(String proCd);
	/**
	 * 한 과목의 수강생 목록 조회
	 * @param lecCd
	 * @return List size로 판단
	 */
	public List<ClassVO> retrieveStudentListOnLecture(String lecCd);
	/**
	 * 담당 학생 조회
	 * @param proCd
	 * @return
	 */
	public List<StudentVO> selectResponsStudentList(String proCd);
	/**
	 * 한 교수가 신규 강의 개설 가능한 과목 목록 조회
	 * @param proCd
	 * @return List size로 판단
	 */
	public List<SubjectVO> retrieveCreatalbeLecture(String proCd);
	/**
	 * 새로운 강의 개설
	 * @param lectureVO
	 * @return 성공 시 OK, 실패 시 FAIL
	 */
	public ServiceResult createLecture(LectureVO lectureVO);
	/**
	 * 학생 성적 입력/수정
	 * @param classVO
	 * @return 성공 시 OK, 실패 시 FAIL
	 */
	public ServiceResult modifyClassScore(ClassVO classVO);
	/**
	 * 교수 연락처 수정
	 * @param professorVO
	 * @return 성공 시 OK, 실패 시 FAIL
	 */
	public ServiceResult modifyProfessorTel(ProfessorVO professorVO);
}