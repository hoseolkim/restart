<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- <table class = "table"> -->
<!-- 	<thead> -->
<!-- 		<tr> -->
<!-- 			<th>수강학점</th> -->
<!--             <th>강의명</th> -->
<!--             <th>교수명</th> -->
<!--             <th>강의실</th> -->
<!--             <th>강의시간</th> -->
<!--             <th>강의요일</th> -->
<!--             <th>수강인원</th> -->
<!-- 		</tr> -->
<!-- 	</thead> -->
<!-- 	<tbody> -->
<%-- 		<c:if test="${empty myList}"> --%>
<!-- 			<tr> -->
<!-- 				<td>수강중인 강의가 없습니다.</td> -->
<!-- 			</tr> -->
<%-- 		</c:if> --%>
<%-- 			<c:set value="${score }" var="score"></c:set> --%>
<%-- 		<c:if test="${not empty myList}"> --%>
<%-- 			<c:forEach items="${myList}" var="list"> --%>
<!-- 				<tr> -->
<%-- 					<td>${list.subjectVO.subGrade }</td> --%>
<%-- 					<td>${list.subjectVO.subName }</td> --%>
<%-- 					<td>${list.professorVO.proName }</td> --%>
<%-- 					<td>${list.lecRoom }</td> --%>
<%-- 					<td>${list.lecTime }</td> --%>
<%-- 					<td>${list.weeks }</td> --%>
<%-- 					<td>${list.lecPerson }</td> --%>
<!-- 				<tr> -->
<%-- 			</c:forEach> --%>
<%-- 		</c:if> --%>
<!-- 		<tr> -->
<!-- 			<th>총 수강학점</th> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<%-- 			<c:forEach items="${myList }" var="list"> --%>
<%-- 				<c:set value="${total+list.subjectVO.subGrade }" var="total"></c:set> --%>
<%-- 			</c:forEach> --%>
<%-- 			<td>${total }</td> --%>
<!-- 		</tr> -->
<!-- 	</tbody> -->
<!-- </table> -->
<table class="table">
	<thead>
		<tr>
			<th>수강학점</th>
			<th>교과명</th>
			<th>교수명</th>
			<th>성적</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${score }" var="classVO">
		<tr>
			<td>${classVO.lectureVO.subjectVO.subGrade }</td>
			<td>${classVO.lectureVO.subjectVO.subName }</td>
			<td>${classVO.lectureVO.professorVO.proName }</td>
			<td>${classVO.clsScore }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<hr/>
		
