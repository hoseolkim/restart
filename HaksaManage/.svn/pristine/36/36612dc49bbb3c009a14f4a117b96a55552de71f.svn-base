package kr.or.ddit.actor.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.actor.student.service.StudentService;
import kr.or.ddit.actor.student.service.StudentServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.ClassVO;
import kr.or.ddit.vo.LectureVO;

@WebServlet("/studentHakjum")
public class StudentHakjumUIControlerServlet extends HttpServlet{
	
	private StudentService service = new StudentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stdNo = (String)req.getSession().getAttribute("loginId");
		List<LectureVO> myList = service.retrieveMyLectureList(stdNo);
		List<ClassVO> score = service.retrieveScore(stdNo);
		req.setAttribute("myList", myList);
		req.setAttribute("score", score);
		
		String viewName = "student_Hakjum";
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
}
