package kr.or.ddit.actor.staff.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;
import kr.or.ddit.vo.SubjectVO;

public class StaffDAOImpl implements StaffDAO{
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int insertSubject(SubjectVO subjectVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectSubject(String subCd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SubjectVO> selectSubjectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfessorVO> selectProfessorList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.selectProfessorList();
		}
	}

	@Override
	public ProfessorVO selectProfessor(String proCd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentVO> selectStudentList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.selectStudentList();
		}
	}

	@Override
	public int insertStudent(StudentVO studentVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.insertStudent(studentVO);	
		}
	}

	@Override
	   public int insertProfessor(ProfessorVO professorVO) {
	      try(
	            SqlSession sqlSession = sqlSessionFactory.openSession(true);
	         ){
	            StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
	            return mapperProxy.insertProfessor(professorVO);   
	         }
	   }

   @Override
   public int deleteProffesor(String proCd) {
       try(
         SqlSession session = sqlSessionFactory.openSession(true);    
      ){
         StaffDAO mapper = session.getMapper(StaffDAO.class);
         return mapper.deleteProffesor(proCd);
       }
   }

	@Override
	public int deleteStudent(String stdNo) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.deleteStudent(stdNo);
		}
	}

	@Override
	public int updateStudent(StudentVO studentVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.updateStudent(studentVO);	
		}
	}
	
}
