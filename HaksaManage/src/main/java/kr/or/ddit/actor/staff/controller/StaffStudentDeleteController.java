package kr.or.ddit.actor.staff.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.actor.staff.service.StaffService;
import kr.or.ddit.actor.staff.service.StaffServiceImpl;
import kr.or.ddit.actor.student.service.StudentService;
import kr.or.ddit.actor.student.service.StudentServiceImpl;
import kr.or.ddit.common.eunm.ServiceResult;
import kr.or.ddit.utils.ValidationUtils;
import kr.or.ddit.validate.grouphint.DeleteGroup;
import kr.or.ddit.vo.LectureVO;
import kr.or.ddit.vo.StudentVO;

@WebServlet("/staff/student/*")
public class StaffStudentDeleteController extends HttpServlet{
	
	private StaffService service = new StaffServiceImpl();
	private StudentService studentService = new StudentServiceImpl();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String uri = StringUtils.substringAfter(req.getRequestURI(), req.getContextPath());
		int lastIdx = uri.lastIndexOf("/");
		int uriLen = uri.length();
		int baseLen = "/staff/student/".length();
		
		String stdNo = uri.substring(lastIdx+1);
		String message = null;
		Map<String, List<String>> errors = new HashMap<>();

		boolean valid = ValidationUtils.validate(stdNo, errors, DeleteGroup.class);
		boolean res = false;
		String viewName = "/jsonView.view";
		if(valid) {
			ServiceResult result = service.removeStduent(stdNo);
			switch (result) {
			case OK:
				res = true;
				break;								
			default:
				message = "서버오류";
				break;
			}
		}else {
			message = "파라미터 누락";
		}
		req.setAttribute("message", message);
		req.setAttribute("result", res);
		
		if(viewName.startsWith("redirect:")) {			
			String location = req.getContextPath() + viewName.substring("redirect:".length());			
			resp.sendRedirect(location);
			
		}else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}

	}
}
