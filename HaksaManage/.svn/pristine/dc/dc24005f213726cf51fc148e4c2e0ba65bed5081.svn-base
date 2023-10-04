<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 

<div class="px-4 py-5 my-5 text-center"><h4 class="display-5 fw-bold text-body-emphasis">담당학생</h4></div>

<div class="col-lg-6 mx-auto">
<table class="table table-bordered">
<thead>
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>거주지</th>
	</tr>
</thead>
<tbody>
		<c:choose>
			<c:when test="${not empty studentList }">
				<c:forEach items="${studentList }" var="student">
					<tr>
						<td>${student.stdNo }</td>
						<td>${student.stdName }</td>
						<td>${student.stdTelno }</td>
						<td>${student.stdAdd }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">담당 학생이 없음</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
</div>
