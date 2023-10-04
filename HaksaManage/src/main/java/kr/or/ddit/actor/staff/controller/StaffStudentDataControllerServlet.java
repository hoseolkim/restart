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
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.or.ddit.actor.staff.service.StaffService;
import kr.or.ddit.actor.staff.service.StaffServiceImpl;
import kr.or.ddit.actor.student.service.StudentService;
import kr.or.ddit.common.eunm.ServiceResult;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidationUtils;
import kr.or.ddit.validate.grouphint.InsertGroup;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;

@WebServlet("/staff/student")
public class StaffStudentDataControllerServlet extends HttpServlet {
	private StaffService service = new StaffServiceImpl();
	private StudentService studentService;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<StudentVO> studentList = service.retrieveStudentList();
		List<ProfessorVO> professorList = service.retrieveProfessorList();
		
		req.setAttribute("studentList", studentList);
		req.setAttribute("professorList", professorList);
		
		String viewName = "staff/student";
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		StudentVO student = new StudentVO();
		req.setAttribute("student", student);
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		PopulateUtils.populate(student, parameterMap);
		
		System.out.println(student.toString());
		
		Map<String, List<String>> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		boolean valid = ValidationUtils.validate(student, errors, InsertGroup.class);
		
		String viewName = null;
		if(valid) {
			ServiceResult result = service.createStudent(student);
			switch (result) {
			case DUPLICATED:
				req.setAttribute("message", "학번 중복");
				viewName = "staff/student";
				break;
			case OK:
				viewName = "redirect:/staff/student";
				break;								
			default:
				req.setAttribute("message", "서버 오류");
				viewName = "staff/student";
				break;
			}
		}else {
			viewName = "staff/student";
		}
		
		if(viewName.startsWith("redirect:")) {			
			String location = req.getContextPath() + viewName.substring("redirect:".length());			
			resp.sendRedirect(location);
			
		}else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
	
}
