package kr.or.ddit.paging;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import kr.or.ddit.vo.PaginationInfo;

@JsonSerialize
public class BootstrapPaginationRenderer implements PaginationRenderer {
	
	private final String PATTERN =" <li class=\"page-item\"><a class=\"page-link\" href=\"javascript:;\" onclick=\"fn_paging(%d);\">%s</a></li>\r\n"
			+ "    <li class=\"page-item active\" aria-current=\"page\">\r\n"
//			+ "      <a class=\"page-link\" href=\"#\">2</a>\r\n"
			+ "    </li>";
	
	private final String PATTERN_active =" <li class=\"page-item active\"><a class=\"page-link\" href=\"javascript:;\" onclick=\"fn_paging(%d);\">%s</a></li>\r\n"
			+ "    <li class=\"page-item active\" aria-current=\"page\">\r\n"
//			+ "      <a class=\"page-link\" href=\"#\">2</a>\r\n"
			+ "    </li>";
	
	@Override
	public String renderPagination(PaginationInfo<?> paging) {
		int startPage = paging.getStartPage();
		int endPage = paging.getEndPage();
		int totalPage = paging.getTotalPage();
		int currentPage = paging.getCurrentPage();
		
		StringBuffer html = new StringBuffer();
		html.append(String.format("				<nav aria-label=\"...\">\r\n"
				+ "				  <ul class=\"pagination nav justify-content-center\">\r\n"
				+ "				"));

		if(startPage > 1 ) {
			html.append(
					String.format(PATTERN,startPage-1, "<<이전")
			
				);
		}
		
		for(int page = startPage; page <= endPage; page++) {
			if(page==currentPage) {
				html.append(
					String.format(PATTERN_active,page,page)	
				);
			}else {
				html.append(
					String.format(PATTERN, page, page)
				);
			}
			
		}
		
		if(endPage < totalPage) {
			html.append(
					String.format(PATTERN, endPage+1, "다음>>")
				);
		}
		html.append("  </ul>\r\n"
				+ "</nav>");
		
		return html.toString();
		
	}

}
