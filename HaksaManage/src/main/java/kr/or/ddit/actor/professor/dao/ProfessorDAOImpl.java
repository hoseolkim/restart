package kr.or.ddit.actor.professor.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ClassVO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.PaginationInfo;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;
import kr.or.ddit.vo.SubjectVO;

public class ProfessorDAOImpl implements ProfessorDAO {
	
	private SqlSessionFactory sqlSessionFactory =
					CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public ProfessorVO selectProfessor(String proCd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> selectLectureList(String proCd) {
		
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			ProfessorDAO mapperProxy = sqlSession.getMapper(ProfessorDAO.class);
			return mapperProxy.selectLectureList(proCd);
		}
	}
	
	
	public int selectTotalRecord(PaginationInfo<ClassVO> paging) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
			){
				ProfessorDAO mapperProxy = sqlSession.getMapper(ProfessorDAO.class);
				return mapperProxy.selectTotalRecord(paging);
			}
	}
	@Override
	public List<ClassVO> selectStudentListOnLecture(PaginationInfo paging) {
		
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
			){
				ProfessorDAO mapperProxy = sqlSession.getMapper(ProfessorDAO.class);
				return mapperProxy.selectStudentListOnLecture(paging);
			}
		}

	@Override
	public List<SubjectVO> selectCreatalbeLecture(String proCd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertLecture(LectureVO lectureVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateClassScore(ClassVO classVO) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession(true);	
			){
				ProfessorDAO mapperProxy = sqlSession.getMapper(ProfessorDAO.class);
				return mapperProxy.updateClassScore(classVO);
			}
	}

	@Override
	public int updateProfessorTel(ProfessorVO professorVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StudentVO> selectResponsStudentList(String proCd) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			ProfessorDAO mapperProxy = sqlSession.getMapper(ProfessorDAO.class);
			return mapperProxy.selectResponsStudentList(proCd);
		}
	}
	
	

 }
