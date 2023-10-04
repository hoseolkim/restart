package kr.or.ddit.actor.student.dao;

import java.util.List;

import kr.or.ddit.vo.ClassVO;
import kr.or.ddit.vo.CounselVO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.StudentVO;

public interface StudentDAO {
	/**
	 * 학생 상세정보 조회
	 * @param stdNo 
	 * @return 없을 시 null 반환
	 */
	public StudentVO selectStudent(String stdNo);
	/**
	 * 학생이 수강신청 할 수 있는 목록 확인
	 * @param stdNo
	 * @return
	 */
	public List<LectureVO> selectLecutreList(String stdNo);
	/**
	 * 학생이 수강신청 한 목록 확인
	 * @param stdNo
	 * @return
	 */
	public List<LectureVO> selectMyLecutreList(String stdNo);
	/**
	 * 수강 신청 입력
	 * @param classVO 학생 학번, 개설과목 코드가 담긴 VO
	 * @return 성공시 ( >= 1)
	 */
	public int insertClass(ClassVO classVO);
	/**
	 * 수강 신청 전에 이미 신청한 과목인지 확인
	 * @param classVO 학생 학번, 개설과목 코드가 담긴 VO
	 * @return 이미 수강신청 한 경우 ( >= 1)
	 */
	public int selectClass(ClassVO classVO);
	/**
	 * 개설된 과목의 수강인원 제한 확인
	 * @param lecCd 개설 과목 코드
	 * @return 해당 과목의 제한인원 반환
	 */
	public int selectClassLimit(String lecCd);
	/**
	 * 개설된 과목의 현재 수강인원 확인
	 * @param lecCd 개설 과목 코드
	 * @return 해당 과목의 현재 수강인원 반환
	 */
	public int selectClassCurrent(String lecCd);
	/**
	 * 수강신청 하려는 강의 정보 확인
	 * @param lecCd
	 * @return
	 */
	public LectureVO selectLecture(String lecCd);
	/**
	 * 수강 신청 취소
	 * @param classVO
	 * @return 성공 시 ( >= 1)
	 */
	public int deleteClass(ClassVO classVO);
	/**
	 * 학생 한 명의 수강 목록에 모든 정보 조회(성적 포함)
	 * @param stdNo
	 * @return List size로 판단
	 */
	public List<ClassVO> selectScore(String stdNo);
	/**
	 * 학생 한 명의 상담 기록 조회
	 * @param stdNo
	 * @return List size로 판단
	 */
	public List<CounselVO> selectCounselList(String stdNo);
	/**
	 * 상담기록의 상세정보 조회
	 * @param counselVO 상담일시, 학생 번호가 담긴 VO
	 * @return 없을 시 null
	 */
	public CounselVO selectCounsel(CounselVO counselVO);
	/**
	 * 학생 연락처, 주소 수정
	 * @param studentVO
	 * @return 성공 시 ( >= 1)
	 */
	public int updateStudent(StudentVO studentVO);
}
