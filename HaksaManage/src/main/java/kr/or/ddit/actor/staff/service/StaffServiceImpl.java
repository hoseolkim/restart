package kr.or.ddit.actor.staff.service;

import java.util.List;

import kr.or.ddit.actor.staff.dao.StaffDAO;
import kr.or.ddit.actor.staff.dao.StaffDAOImpl;
import kr.or.ddit.common.eunm.ServiceResult;
import kr.or.ddit.vo.PaginationInfo;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;
import kr.or.ddit.vo.SubjectVO;
import oracle.net.ano.AuthenticationService;

public class StaffServiceImpl implements StaffService{
	private StaffDAO dao = new StaffDAOImpl();
			

	@Override
	public ServiceResult createSubject(SubjectVO subjectVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void retrieveSubjectList(PaginationInfo<SubjectVO> paging) {
		// TODO Auto-generated method stub
	}

	@Override
	public void retrieveProfessorList(PaginationInfo<ProfessorVO> paging) {
		int totalRow = dao.selectProfessorTotalCount(paging);
		paging.setTotalRecord(totalRow);
		List<ProfessorVO> list = dao.selectProfessorList(paging);
		paging.setDataList(list);
	}

	@Override
	public void retrieveStudentList(PaginationInfo<StudentVO> paging) {
		int totalRow = dao.selectStudentTotalCount(paging);
		paging.setTotalRecord(totalRow);
		List<StudentVO> list = dao.selectStudentList(paging);
		paging.setDataList(list);
	}

	@Override
	public ServiceResult createProfessor(ProfessorVO professorVO) {
		try {
			int res = dao.insertProfessor(professorVO);
			ServiceResult result = null;
			if(res > 0 ) {
				result = ServiceResult.OK;
			}else {
				result = ServiceResult.FAIL;
			}
			return result;
		} catch (Exception e) {
			return ServiceResult.DUPLICATED;
		}
	}

	@Override
	public ServiceResult createStudent(StudentVO studentVO) {
		ServiceResult result = null;
		int rowcnt = dao.insertStudent(studentVO);
		
		result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		
		return result;
	}

	@Override
	public ServiceResult removeStduent(String stdNo) {
		ServiceResult result = null;
		int rowcnt = -1;
		try {
			rowcnt = dao.deleteStudent(stdNo);
		} catch(Exception e) {
			return ServiceResult.NOTPOSSIBLE;
		}
		result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

	@Override
	public ServiceResult modifyStduent(StudentVO studentVO) {
		ServiceResult result = null;
		int rowcnt = dao.updateStudent(studentVO);
		
		result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		
		return result;
	}
	@Override
	public ServiceResult removeProffesor(String proCd) {
		int rowcnt = -1;
		try {
			rowcnt = dao.deleteProffesor(proCd);
		}catch(Exception e) {
			return ServiceResult.NOTPOSSIBLE;
		}
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
}
