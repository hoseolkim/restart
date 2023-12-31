package kr.or.ddit.actor.staff.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.PaginationInfo;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;
import kr.or.ddit.vo.SubjectVO;

public class StaffDAOImpl implements StaffDAO{
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int insertSubject(SubjectVO subjectVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.insertSubject(subjectVO);
		}
	}

	@Override
	public int selectSubject(String subCd) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.selectSubject(subCd);
		}
	}

	@Override
	public List<SubjectVO> selectSubjectList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.selectSubjectList();
		}
	}

	@Override
	public List<ProfessorVO> selectProfessorList(PaginationInfo<ProfessorVO> paging) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.selectProfessorList(paging);
		}
	}

	@Override
	public ProfessorVO selectProfessor(String proCd) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.selectProfessor(proCd);
		}
	}

	@Override
	public List<StudentVO> selectStudentList(PaginationInfo<StudentVO> paging) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.selectStudentList(paging);
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

	@Override
	public int selectProfessorTotalCount(PaginationInfo<ProfessorVO> paging) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.selectProfessorTotalCount(paging);	
		}
	}

	@Override
	public int selectStudentTotalCount(PaginationInfo<StudentVO> paging) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StaffDAO mapperProxy = sqlSession.getMapper(StaffDAO.class);
			return mapperProxy.selectStudentTotalCount(paging);	
		}
	}
	
}
