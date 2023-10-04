package kr.or.ddit.actor.student.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ClassVO;
import kr.or.ddit.vo.CounselVO;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.StudentVO;

public class StudentDAOImpl implements StudentDAO{
	private SqlSessionFactory sessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public StudentVO selectStudent(String stdNo) {
		try(
			SqlSession session = sessionFactory.openSession();
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.selectStudent(stdNo);
		}
	}

	@Override
	public List<LectureVO> selectLecutreList(String stdNo) {
		try(
			SqlSession session = sessionFactory.openSession();
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.selectLecutreList(stdNo);
		}
	}

	@Override
	public int insertClass(ClassVO classVO) {
		try(
			SqlSession session = sessionFactory.openSession(true);
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.insertClass(classVO);
		}
	}

	@Override
	public int selectClass(ClassVO classVO) {
		try(
			SqlSession session = sessionFactory.openSession();
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.selectClass(classVO);
		}
	}

	@Override
	public int selectClassLimit(String lecCd) {
		try(
			SqlSession session = sessionFactory.openSession();
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.selectClassLimit(lecCd);
		}
	}

	@Override
	public int selectClassCurrent(String lecCd) {
		try(
			SqlSession session = sessionFactory.openSession();
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.selectClassCurrent(lecCd);
		}
	}

	@Override
	public LectureVO selectLecture(String lecCd) {
		try(
			SqlSession session = sessionFactory.openSession();
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.selectLecture(lecCd);
		}
	}

	@Override
	public int deleteClass(ClassVO classVO) {
		try(
			SqlSession session = sessionFactory.openSession(true);
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.deleteClass(classVO);
		}
	}

	@Override
	public List<ClassVO> selectScore(String stdNo) {
		try(
			SqlSession session = sessionFactory.openSession();
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.selectScore(stdNo);
		}
	}

	@Override
	public List<CounselVO> selectCounselList(String stdNo) {
		try(
				SqlSession session = sessionFactory.openSession();
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.selectCounselList(stdNo);
		}
	}

	@Override
	public CounselVO selectCounsel(CounselVO counselVO) {
		try(
			SqlSession session = sessionFactory.openSession();
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.selectCounsel(counselVO);
		}
	}

	@Override
	public int updateStudent(StudentVO studentVO) {
		try(
			SqlSession session = sessionFactory.openSession(true);
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.updateStudent(studentVO);
		}
	}

	@Override
	public List<LectureVO> selectMyLecutreList(String stdNo) {
		try(
			SqlSession session = sessionFactory.openSession();
		){
			StudentDAO mapper = session.getMapper(StudentDAO.class);
			return mapper.selectMyLecutreList(stdNo);
		}
	}
	
	
	
	
}
