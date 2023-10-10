package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.controller.ProdListController;
import kr.or.ddit.prod.controller.ProdListController_Case2;
import kr.or.ddit.prod.controller.ProdListDataController;
import kr.or.ddit.prod.controller.ProdViewController;

/**
 * Front Controller Pattern 구조의 fornt controller
 * command handler 에 대해 사전 작업과 사후 작업을 처리할 수 있는 front
 */
public class DispatcherServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		String viewName = null;
		
		uri = uri.substring(req.getContextPath().length());
		uri = uri.split(";")[0];
		
		if("/prod/prodList.do".equals(uri)) {
			ProdListController controller = new ProdListController();
			viewName = controller.prodList(req, resp);
		}else if("/prod/prodView.do".equals(uri)){
			ProdViewController controller = new ProdViewController();
			viewName = controller.prodView(req, resp);
		}else if("/prod/ajax/prodListUI.do".equals(uri)){
			ProdListController_Case2 controller = new ProdListController_Case2();
			viewName = controller.listUI(req, resp);
		}else if("/prod/ajax/prodListData.do".equals(uri)){
			ProdListDataController controller = new ProdListDataController();
			viewName = controller.prodList(req, resp);
		}else {
			resp.sendError(404, "처리할 수 없는 요청임.");
		}
		
		if(viewName != null) {
			new ViewResolverComposite().resolveView(viewName, req, resp);
		}else {
			if(!resp.isCommitted()) {
				resp.sendError(500,"logical view name 이 결정되지 않았음.");
			}
		}
	}
}