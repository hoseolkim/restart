package kr.or.ddit.actor.professor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.actor.professor.service.ProfessorService;
import kr.or.ddit.actor.professor.service.ProfessorServiceImpl;
import kr.or.ddit.vo.ClassVO;

@WebServlet("/professor/studentList")
public class ProfessorStudentListServlet extends HttpServlet {

	private ProfessorService service = new ProfessorServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String lecCode = req.getParameter("lecCode");
		
		List<ClassVO> studentList = service.retrieveStudentListOnLecture(lecCode);
		
		req.setAttribute("studentList", studentList);
		
		String viewName ="/jsonView.view";
		
		if (viewName.startsWith("redirect:")) {
			String location = req.getContextPath() + viewName.substring("redirect:".length());
			resp.sendRedirect(location);
		} else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}
