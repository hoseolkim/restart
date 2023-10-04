package kr.or.ddit.actor.student.service;

import java.util.List;

import kr.or.ddit.common.eunm.ServiceResult;
import kr.or.ddit.vo.ClassVO;
import kr.or.ddit.vo.CounselVO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.StudentVO;

public interface StudentService {
	/**
	 * 학생 상세정보 조회
	 * @param stdNo 
	 * @return 없을 시 null 반환
	 */
	public StudentVO retrieveStudent(String stdNo);
	/**
	 * 학생이 수강 신청할 수 있는 강의 목록 조회
	 * @param stdNo
	 * @return
	 */
	public List<LectureVO> retrieveLectureList(String stdNo);
	/**
	 * 학생이 수강 한 강의 목록 조회
	 * @param stdNo
	 * @return
	 */
	public List<LectureVO> retrieveMyLectureList(String stdNo);
	/**
	 * 수강 신청 처리
	 * 	1) 이미 신청했는지 확인, 이미 신청했을 시 리턴
	 * 	2) 신청할 과목의 수강인원 제한과 현재 수강인원 확인,
	 * 		두 값이 같거나 현재 수강인원이 클 경우 리턴
	 *  3) 이미 수강신청한 목록들을 가져와서 수강신청하려는 정보, 시간들과 비교
	 *  	겹칠 경우 리턴
	 * 	4) 수강신청 처리
	 * @param classVO
	 * @return 이미 신청했을 시 ALREADYDONE, 수강인원 초과 시 LIMITED, 수강시간 겹칠 시 DUPLICATED, 신청 성공시 OK, 실패 시 FAIL
	 */
	public ServiceResult createClass(ClassVO classVO);
	/**
	 * 수강 신청 취소
	 * @param classVO
	 * @return 성공 시 OK, 실패 시 FAIL
	 */
	public ServiceResult removeClass(ClassVO classVO);
	/**
	 * 학생 한 명의 수강 목록에 모든 정보 조회
	 * @param stdNo
	 * @return List size로 판단
	 */
	public List<ClassVO> retrieveScore(String stdNo);
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
	public CounselVO retrieveCounsel(CounselVO counselVO);
	/**
	 * 학생 연락처,주소 수정
	 * @param studentVO
	 * @return 성공 시 OK, 실패 시 FAIL
	 */
	public ServiceResult updateStudentTel(StudentVO studentVO);
	/**
	 * 강의 정보 확인
	 * @param lecCd
	 * @return
	 */
	public LectureVO retrieveLecture(String lecCd);
}
