<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <nav id="sidebarMenu" class="col-md-2 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="sidebar-sticky pt-3">
      <c:url value="/staff/studentList" var="studentViewURL">
      </c:url>
       <c:url value="/staff/professorList" var="professorViewURL"></c:url>
        <ul class="nav flex-column">      
			<li class="nav-item">
            <a class="nav-link active" href="${professorViewURL}">교수</a>
         </li>
			<li class="nav-item">
				<a class="nav-link active" href="${studentViewURL }">학생</a>
			</li>	
        </ul>
      </div>
    </nav>