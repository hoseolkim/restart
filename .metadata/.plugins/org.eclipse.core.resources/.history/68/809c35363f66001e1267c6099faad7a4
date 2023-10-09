package kr.or.ddit.login.service;

import kr.or.ddit.common.eunm.ServiceResult;
import kr.or.ddit.login.dao.LoginDAO;
import kr.or.ddit.login.dao.LoginDAOImpl;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;

public class LoginServiceImpl implements LoginService{
	private LoginDAO dao = new LoginDAOImpl();
	@Override
	public ServiceResult studentLogin(StudentVO studentVO) {
		StudentVO student = dao.studentLogin(studentVO);
		return student != null ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public ServiceResult professorLogin(ProfessorVO professorVO) {
		ProfessorVO professor = dao.professorLogin(professorVO);
		return professor != null ? ServiceResult.OK : ServiceResult.FAIL;
	}

}
