<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="cPath" value="${pageContext.request.contextPath }" scope="application"/>



<div class="professorList">
	<table class="table table-bordered">
		<thead>
			<tr ><th colspan="7"><button id="studentForm" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" >교수 등록</button></th></tr>
			<tr>
				<th>일련번호</th>
				<th>교수코드</th>
				<th>이름</th>
				<th>전공과목</th>
				<th>부서번호</th>
				<th>전화번호</th>
				<th>삭제하기</th>
			</tr>
		</thead>
		<tbody id="profList">
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7">
				<div id="pagingHTML">
				</div>
					<div id="searchUI" class="text-center">
						<select name="searchType">
							<option value>전체</option>
							<option value="name">이름</option>
							<option value="major">전공</option>
						</select>
						<input type="text" name="searchWord" />
						<input type="button" value="검색" id="searchBtn" />
					</div>
				</td>
			</tr>
		</tfoot>
	</table>
</div>

<c:url value="/staff/professor" var="getList" />
<form id="searchForm" action="${getList }">
	<input type="hidden" name="searchType" />
	<input type="hidden" name="searchWord" />
	<input type="hidden" name="page" />
</form>

<!-- Insert Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Insert Professor</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      <c:url value="/staff/professor" var="insertUrl" />
        <form id="studentInsertForm" method="post" action="${insertUrl }" enctype="multipart/form-data">
        	<table class="table table-bordered">
        		<tr>
        			<th>교수번호</th>
        			<td><input type="text" name="proCd" class="form-control" placeholder="교수번호" required /></td>
        		</tr>
        	
        		<tr>
        			<th>교수명</th>
        			<td><input type="text" name="proName" class="form-control" placeholder="교수명" required /></td>
        		</tr>
        		<tr>
        			<th>전공</th>
        			<td><input type="text" name="proMajor" class="form-control" placeholder="학과" required /></td>
        		</tr>
        		<tr>
        			<th>학과코드</th>
        			<td><input type="text" name="proDeptno" class="form-control" placeholder="전화번호" required /></td>
        		</tr>
        		<tr>
        			<th>전화번호</th>
        			<td><input type="text" name="proTelno" class="form-control" placeholder="전화번호" required /></td>
        		</tr>
        		<tr>
        			<th>교수 사진</th>
        			<td><input type="file" name="proImage" class="form-control" /></td>
        		</tr>
        	
        	
        		<tr>
        			<td colspan="2"><input type="submit" class="btn btn-primary" value="등록" /></td>
        		</tr>
        	</table>    	
        </form>
      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
<script>
$(':input[name=searchType]').val("${paging.simpleCondition.searchType}");
$(':input[name=searchWord]').val("${paging.simpleCondition.searchWord}");
</script>
<script src="${pageContext.request.contextPath }/resources/js/app/staff/staffPro.js"></script>
