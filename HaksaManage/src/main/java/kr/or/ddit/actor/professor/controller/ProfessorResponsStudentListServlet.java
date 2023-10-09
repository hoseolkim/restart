package kr.or.ddit.actor.professor.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.actor.professor.service.ProfessorService;
import kr.or.ddit.actor.professor.service.ProfessorServiceImpl;
import kr.or.ddit.actor.student.service.StudentService;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.StudentVO;

@WebServlet("/professor/responsstudent")
public class ProfessorResponsStudentListServlet extends HttpServlet {
	private ProfessorService service = new ProfessorServiceImpl();
	private StudentService studentService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Principal principal = req.getUserPrincipal();
		String proCd = principal.getName();
		List<StudentVO> list = service.selectResponsStudentList(proCd);
		req.setAttribute("studentList", list);
		String viewName = "professor/responsstudent";
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}

}
