package kr.or.ddit.actor.professor.service;

import java.util.List;

import kr.or.ddit.actor.professor.dao.ProfessorDAO;
import kr.or.ddit.actor.professor.dao.ProfessorDAOImpl;
import kr.or.ddit.common.eunm.ServiceResult;
import kr.or.ddit.login.service.LoginService;
import kr.or.ddit.login.service.LoginServiceImpl;
import kr.or.ddit.vo.ClassVO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;
import kr.or.ddit.vo.SubjectVO;
import oracle.net.ano.AuthenticationService;

public class ProfessorServiceImpl implements ProfessorService{
	
	private ProfessorDAO dao = new ProfessorDAOImpl();
	private LoginService loservice = new LoginServiceImpl();
	
	@Override
	public List<LectureVO> retrieveLectureList(String proCd) {
		
		List<LectureVO> lectureList = dao.selectLectureList(proCd);
		
		return lectureList;
	}

	@Override
	public List<ClassVO> retrieveStudentListOnLecture(String lecCd) {
		
		List<ClassVO> studentList = dao.selectStudentListOnLecture(lecCd);
		
		return studentList;
	}

	@Override
	public List<SubjectVO> retrieveCreatalbeLecture(String proCd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult createLecture(LectureVO lectureVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult modifyClassScore(ClassVO classVO) {
		
		return null;
	}

	@Override
	public ServiceResult modifyProfessorTel(ProfessorVO professorVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfessorVO retrieveProfessor(String proCd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentVO> selectResponsStudentList(String proCd) {
		return dao.selectResponsStudentList(proCd);
	}
	
}