<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
#studentTR{
	cursor: pointer;
}
</style>

<table class="table table-bordered">
	<thead>
		<tr>
			<td colspan="7"><button id="studentForm" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" >학생 등록</button></td>
		</tr>
		<tr>
			<th>학생번호</th>
			<th>학생명</th>
			<th>주민등록번호</th>
			<th>연락처</th>
			<th>주소</th>
			<th>담당교수</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${not empty studentList }">
				<c:forEach items="${studentList }" var="student">
					<tr>
						<td data-std-no="${student.stdNo }">${student.stdNo }</td>
						<td>${student.stdName }</td>
						<td>${student.stdId }</td>
						<td>${student.stdTelno }</td>
						<td>${student.stdAdd }</td>
						<td data-pro-cd="${student.proVO.proCd }">${student.proVO.proName }</td>
						<td>
							<button id="stdUdtBtn" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#studentDetail" >수정</button>
							<button id="stdDelBtn" class="btn btn-primary" data-bs-toggle="modal" >삭제</button>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="7">학생 정보가 없음</td>
				</tr>
			</c:otherwise>
		</c:choose>
		
	</tbody>
</table>



<!-- Update Modal -->
<div class="modal fade" id="studentDetail" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Student Detail</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
			<table class="table table-bordered">				
        		<tr>
        			<th>학생번호</th>
        			<td><input type="text" id="stdNo" name="stdNo" class="form-control" required readonly /></td>
        		</tr>
        		<tr>
        			<th>학생명</th>
        			<td><input type="text" id="stdName" name="stdName" class="form-control" required /></td>
        		</tr>
        		<tr>
        			<th>주민등록번호</th>
        			<td><input type="text" id="stdId" name="stdId" class="form-control" required /></td>
        		</tr>
        		<tr>
        			<th>연락처</th>
        			<td><input type="text" id="stdTelno" name="stdTelno" class="form-control" required /></td>
        		</tr>
        		<tr>
        			<th>주소</th>
        			<td><input type="text" id="stdAdd" name="stdAdd" class="form-control" required /></td>
        		</tr>
        		<tr>
        			<th>담당교수</th>
        			<td>
        				<select name="proCd" id="proCd" class="form-control">
        					<option value>교수 선택</option>
        					<c:choose>
					        	<c:when test="${not empty professorList }">
									<c:forEach items="${professorList }" var="professor">
										<option value="${professor.proCd }">${professor.proName }</option>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<option value>교수 정보가 없음</option>
								</c:otherwise>
        					</c:choose>
        				</select>
        			</td>
        		</tr>
        		<tr>
        			<td colspan="2"><input type="submit" class="btn btn-primary" value="수정" /></td>
        		</tr>
        	</table> 
      </div>
      <div class="modal-footer">        
      </div>     
    </div>
  </div>
</div>




<!-- Insert Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Insert Student</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form id="studentInsertForm" method="post" action="<%=request.getContextPath() %>/staff/student">
        	<table class="table table-bordered">
        		<tr>
        			<th>학생명</th>
        			<td><input type="text" name="stdName" class="form-control" placeholder="학생명" required /></td>
        		</tr>
        		<tr>
        			<th>주민등록번호</th>
        			<td><input type="text" name="stdId" class="form-control" placeholder="주민등록번호" required /></td>
        		</tr>
        		<tr>
        			<th>연락처</th>
        			<td><input type="text" name="stdTelno" class="form-control" placeholder="연락처" required /></td>
        		</tr>
        		<tr>
        			<th>주소</th>
        			<td><input type="text" name="stdAdd" class="form-control" placeholder="주소" required /></td>
        		</tr>
        		<tr>
        			<th>담당교수</th>
        			<td>
        				<select name="proCd" class="form-control">
        					<option value>교수 선택</option>
        					<c:choose>
					        	<c:when test="${not empty professorList }">
									<c:forEach items="${professorList }" var="professor">
										<option value="${professor.proCd }">${professor.proName }</option>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<option value>교수 정보가 없음</option>
								</c:otherwise>
        					</c:choose>
        				</select>
        			</td>
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

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/app/staff/staff.js"></script>






















