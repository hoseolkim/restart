package kr.or.ddit.actor.student.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.actor.student.service.StudentService;
import kr.or.ddit.actor.student.service.StudentServiceImpl;
import kr.or.ddit.common.eunm.ServiceResult;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.utils.ValidationUtils;
import kr.or.ddit.validate.grouphint.DeleteGroup;
import kr.or.ddit.validate.grouphint.InsertGroup;
import kr.or.ddit.vo.ClassVO;
import kr.or.ddit.vo.LectureVO;

@WebServlet("/student")
public class StudentDataControllerServlet extends HttpServlet{
	private StudentService service = new StudentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Principal principal = req.getUserPrincipal();
		String stdNo = principal.getName();
		List<LectureVO> lectureList = service.retrieveLectureList(stdNo);
		List<LectureVO> myList = service.retrieveMyLectureList(stdNo);
		req.setAttribute("myList", myList);
		req.setAttribute("lectureList", lectureList);
		req.getRequestDispatcher("/jsonView.view").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String lecCd = req.getParameter("lecCd");
		
		Principal principal = req.getUserPrincipal();
		String stdNo = principal.getName();
		ClassVO classVO = new ClassVO();
		classVO.setLecCd(lecCd);
		classVO.setStdNo(stdNo);
		
		Map<String, List<String>> errors = new HashMap<String, List<String>>();
		
		boolean valid = ValidationUtils.validate(classVO , errors, InsertGroup.class);
		ServiceResult result = null;
		if(valid) {
			result = service.createClass(classVO);
		}else {
			resp.sendError(400,"잘못된 요청입니다!!!");
			return;
		}
		
//		이미 신청했을 시 ALREADYDONE, 수강인원 초과 시 LIMITED, 수강시간 겹칠 시 DUPLICATED, 신청 성공시 OK, 실패 시 FAIL
		String message = null;
		boolean res = false;
		switch (result) {
		case ALREADYDONE:
			message = "이미 수강신청한 과목입니다!";
			break;
		case LIMITED:
			message = "수강 인원 제한입니다!";
			break;
		case DUPLICATED:
			message = "수강 시간이 겹치는 과목이 존재합니다!";
			break;
		case OK:
			res = true;
			LectureVO lecture = service.retrieveLecture(lecCd);
			req.setAttribute("lecture", lecture);
			break;
		default:
			message = "서버 오류! 잠시후 다시 시도해주세요!";
			break;
		}
		
		req.setAttribute("result", res);
		req.setAttribute("message", message);
		
		String viewName = "/jsonView.view";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
}
