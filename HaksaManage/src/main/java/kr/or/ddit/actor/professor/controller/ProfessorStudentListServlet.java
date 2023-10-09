package kr.or.ddit.actor.professor.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.actor.professor.service.ProfessorService;
import kr.or.ddit.actor.professor.service.ProfessorServiceImpl;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.vo.ClassVO;
import kr.or.ddit.vo.PaginationInfo;

@WebServlet("/professor/studentList")
public class ProfessorStudentListServlet extends HttpServlet {

	private ProfessorService service = new ProfessorServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String lecCode = req.getParameter("lecCode");
		
		ClassVO detailCondition = new ClassVO();
		PopulateUtils.populate(detailCondition, req.getParameterMap());
		
		String page = req.getParameter("page");
		
		int currentpage = 1;
		if(StringUtils.isNumeric(page)) {
			currentpage = Integer.parseInt(page);
		}
		PaginationInfo<ClassVO> paging = new PaginationInfo<>();
		
		paging.setDetailCondition(detailCondition);
		paging.setCurrentPage(currentpage);
		List<ClassVO> studentList = service.retrieveStudentListOnLecture(paging);
		
		req.setAttribute("paging", paging);
		
		String viewName ="/jsonView.view";
		
		if (viewName.startsWith("redirect:")) {
			String location = req.getContextPath() + viewName.substring("redirect:".length());
			resp.sendRedirect(location);
		} else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}
