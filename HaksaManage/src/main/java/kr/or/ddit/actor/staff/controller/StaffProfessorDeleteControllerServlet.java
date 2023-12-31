package kr.or.ddit.actor.staff.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
import kr.or.ddit.common.eunm.ServiceResult;

/*
 * @WebServlet("/staff/professor/*")
 * 
 * public class StaffProfessorDeleteControllerServlet extends HttpServlet {
 * private StaffService service = new StaffServiceImpl();
 * 
 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException { // POST 요청을 받아서 교수 삭제 작업 수행
 * String proCd = req.getParameter("proCd");
 * 
 * if (proCd != null && !proCd.isEmpty()) { ServiceResult result =
 * service.removeProffesor(proCd);
 * 
 * if (result == ServiceResult.OK) { req.setAttribute("message", "교수 삭제에성공.");
 * req.setAttribute("result", true); } else { // 삭제 실패
 * req.setAttribute("message", "교수 삭제에 실패했습니다.");
 * 
 * } } else { // 유효하지 않은 요청 resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
 * "교수 코드가 올바르지 않습니다.");
 * 
 * } String viewName = "/jsonView.view";
 * req.getRequestDispatcher(viewName).forward(req, resp); } }
 */

@WebServlet("/staff/professor/*")
public class StaffProfessorDeleteControllerServlet extends HttpServlet {
    private StaffService service = new StaffServiceImpl();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String proCd = req.getParameter("proCd");
    	
    	boolean valid = StringUtils.isNotBlank(proCd);
    	String message = null;
    	if(valid) {
    		ServiceResult result = service.removeProffesor(proCd);
    		boolean res = false;
    		switch (result) {
			case OK:
				message = "성공적으로 삭제했습니다!";
				res = true;
				break;
			case NOTPOSSIBLE:
				message = "연관된 데이터 존재로 삭제 불가!";
				
				break;
			default:
				message = "서버 오류로 인한 삭제 실패!";
				break;
			}
    		req.setAttribute("result", res);
    	}else {
    		resp.sendError(400,"잘못된 요청입니다.");
    		return;
    	}
    	req.setAttribute("message", message);
    	String viewName = "/jsonView.view";
    	req.getRequestDispatcher(viewName).forward(req, resp);
    }
    
    
    
    /*
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST 요청을 받아서 교수 삭제 작업 수행
        String proCd = req.getParameter("proCd");

        if (proCd != null && !proCd.isEmpty()) {
            ServiceResult result = service.removeProffesor(proCd);

            // JSON 형식으로 응답 생성
            resp.setContentType("application/json;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            Map<String, Object> jsonResponse = new HashMap<>();

            if (result == ServiceResult.OK) { 
                jsonResponse.put("message", "교수 삭제에 성공했습니다.");
                jsonResponse.put("result", true);
            } else {
                jsonResponse.put("message", "교수 삭제에 실패했습니다.");
                jsonResponse.put("result", false);
            }

            // JSON 응답 전송
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(out, jsonResponse);
        } else {
            // 유효하지 않은 요청
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "교수 코드가 올바르지 않습니다.");
        }
    }
    */
}
