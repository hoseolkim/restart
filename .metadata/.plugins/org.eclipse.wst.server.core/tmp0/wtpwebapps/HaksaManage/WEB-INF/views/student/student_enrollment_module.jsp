<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table class="table" >
	<thead>
		<tr>
			<th>수강신청</th>
			<th>수강학점</th>
            <th>강의명</th>
            <th>교수명</th>
            <th>강의실</th>
            <th>강의시간</th>
            <th>강의요일</th>
            <th>수강인원</th>
            <th>현재수강인원</th>
		</tr>
	</thead>
	<tbody id="lectureList">
	</tbody>
</table>
<hr/>
<table class="table" >
	<thead>
		<tr>
			<th>수강신청</th>
			<th>수강학점</th>
            <th>강의명</th>
            <th>교수명</th>
            <th>강의실</th>
            <th>강의시간</th>
            <th>강의요일</th>
            <th>수강인원</th>
            <th>현재수강인원</th>
		</tr>
	</thead>
	<tbody id="currList">
	</tbody>
</table>
<script src="${pageContext.request.contextPath }/resources/js/app/student/student.js"></script>