package kr.or.ddit.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;

public class LoginDAOImpl implements LoginDAO {
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory(); 
	@Override
	public StudentVO studentLogin(StudentVO studentVO) {
		try(
			SqlSession session = sqlSessionFactory.openSession(); 
		){
			LoginDAO mapper = session.getMapper(LoginDAO.class);
			return mapper.studentLogin(studentVO);
		}
	}

	@Override
	public ProfessorVO professorLogin(ProfessorVO professorVO) {
		try(
			SqlSession session = sqlSessionFactory.openSession(); 
		){
			LoginDAO mapper = session.getMapper(LoginDAO.class);
			return mapper.professorLogin(professorVO);
		}
	}

}
