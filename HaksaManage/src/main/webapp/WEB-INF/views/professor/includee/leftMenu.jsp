<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <nav id="sidebarMenu" class="col-md-2 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="sidebar-sticky pt-3" data-context-path="${pageContext.request.contextPath}">
      	<h5>교수정보</h5>
      	<ol id="professorInfo" class="nav flex-column" >
      	</ol>
      	<br/>
      	<h5>강의목록</h5>
        <ul id="lectureList" class="nav flex-column">      
        </ul>
      </div>
    </nav>
 <script src="${pageContext.request.contextPath}/resources/js/app/professor/professor.js"></script>