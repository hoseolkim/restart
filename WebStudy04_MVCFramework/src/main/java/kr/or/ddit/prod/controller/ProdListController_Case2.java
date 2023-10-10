package kr.or.ddit.prod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;

public class ProdListController_Case2 {
	private OthersDAO othersDAO = new OthersDAOImpl();
	// Spring 의 AOP 방법론으로 해결 예정...
	private void addAtribute(HttpServletRequest req) {
		req.setAttribute("lprodList", othersDAO.selectLprodList());
		req.setAttribute("buyerList", othersDAO.selectBuyerList(null));
	}
	
	public String listUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addAtribute(req);
		return "prod/prodListUI";
	}
}