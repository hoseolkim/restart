package kr.or.ddit.login.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

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
		ServiceResult result = null;
		if(student != null) {
			try {
				BeanUtils.copyProperties(studentVO, student);
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		return result;
	}

	@Override
	public ServiceResult professorLogin(ProfessorVO professorVO) {
		ProfessorVO professor = dao.professorLogin(professorVO);
		ServiceResult result = null;
		if(professor !=null) {
			try {
				BeanUtils.copyProperties(professorVO, professor);
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		
		return result;
	}

}
