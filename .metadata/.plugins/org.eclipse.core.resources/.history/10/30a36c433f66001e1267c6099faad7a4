package kr.or.ddit.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.common.eunm.ServiceResult;
import kr.or.ddit.login.service.LoginService;
import kr.or.ddit.login.service.LoginServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.utils.ValidationUtils;
import kr.or.ddit.validate.grouphint.LoginGroup;
import kr.or.ddit.vo.ProfessorVO;
import kr.or.ddit.vo.StudentVO;

@WebServlet("/login")
public class LoginProcessControllerServlet extends HttpServlet{
	private LoginService service = new LoginServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// 로그인 폼 입력란 name = id
		String id = req.getParameter("id");
		String viewName = null;
		String message = null;
		HttpSession session = req.getSession();
		viewName = "redirect:/";
		boolean valid = StringUtils.isNotBlank(id);
		// id에 뭐라도 들어있는 경우
		if(valid) {
			if(id.equals("admin")) {
				// 교직원 로그인인 경우
				session.setAttribute("loginId", id);
				viewName = "redirect:/staffMain.tiles";
			}else if(id.length()==5) {
				ProfessorVO professorVO = new ProfessorVO();
				professorVO.setProCd(id);
				Map<String, List<String>> errors = new HashMap<String, List<String>>();
				boolean isProfessor = ValidationUtils.validate(professorVO, errors, LoginGroup.class);
				if(isProfessor) {
					// 교수코드일 경우
					ServiceResult result = service.professorLogin(professorVO);
					if(result == ServiceResult.OK) {
						// 로그인 성공시
						session.setAttribute("loginId", id);
						viewName = "redirect:/professorMain.tiles";
					}else {
						message = "존재하지 않는 아이디입니다!";
					}
				}else {
					session.setAttribute("errors", errors); // flush attribute
				}
			}else if(id.length()==10) {
				StudentVO studentVO = new StudentVO();
				studentVO.setStdNo(id);
				Map<String, List<String>> errors = new HashMap<String, List<String>>();
				boolean isStudent = ValidationUtils.validate(studentVO, errors, LoginGroup.class);
				// 학번일 경우
				if(isStudent) {
					ServiceResult result = service.studentLogin(studentVO);
					if(result == ServiceResult.OK) {
						session.setAttribute("loginId", id);
						// 로그인 성공시
						viewName = "redirect:/studentMain.tiles";
					}else {
						message = "존재하지 않는 아이디입니다!";
					}
				}else {
					session.setAttribute("errors", errors); // flush attribute
				}
			}else {
				// 교직원, 교수, 학생 아이디형식에 안 맞는 경우
				message = "학번 형식이 맞지 않습니다!!";
			}
		}else{
			message = "학번을 입력해주세요!!";
		}// id에 뭐라도 들어있는 경우 if문 끝
		session.setAttribute("message", message);
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
}
