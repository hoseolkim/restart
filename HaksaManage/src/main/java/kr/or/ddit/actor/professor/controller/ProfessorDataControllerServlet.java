package kr.or.ddit.actor.professor.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.actor.professor.service.ProfessorService;
import kr.or.ddit.actor.professor.service.ProfessorServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.LectureVO;

@WebServlet("/professor")
public class ProfessorDataControllerServlet extends HttpServlet{
	
	private ProfessorService service = new ProfessorServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Principal principal = req.getUserPrincipal();
		String proCd = principal.getName();
		
		List<LectureVO> lectureList = new ArrayList<>();
		lectureList = service.retrieveLectureList(proCd);
		
		req.setAttribute("lectureList", lectureList);
		
		String viewName = "/jsonView.view";
		
		if (viewName.startsWith("redirect:")) {
			String location = req.getContextPath() + viewName.substring("redirect:".length());
			resp.sendRedirect(location);
		} else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}
