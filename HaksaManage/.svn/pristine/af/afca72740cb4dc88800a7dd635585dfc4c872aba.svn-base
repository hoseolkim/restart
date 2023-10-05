/**
 * 
 */
$(function() {

	const cPath = $(".sidebar-sticky").data("contextPath");

	let makeLiTag = function(lectureVO) {
		let makeLiTag = `
			<li class="nav-item">
				<p class="nav-link active" data-lecture-code='${lectureVO.lecCd}'>${lectureVO.subjectVO.subName}</p>
			</li>
			`;
		return makeLiTag;
	}; //makeTags end
	
	let makeInfoTag = function(lectureVO) {
		let makeInfoTag = `
				<li class="nav-item">교수코드: ${lectureVO.professorVO.proCd}</p>
				<li class="nav-item">교수명: ${lectureVO.professorVO.proName}</p>
				<li class="nav-item">전공: ${lectureVO.professorVO.proMajor}</p>
				<li class="nav-item">소속학과: ${lectureVO.professorVO.proDeptno}</p>
				<li class="nav-item">교수연락처: ${lectureVO.professorVO.proTelno}</p>
			`;
		return makeInfoTag;
	}; //makeInfoTag end	

	const baseUrl = `${cPath}/professor`;

	$.getJSON(baseUrl, function(resp) {
		let lectureList = resp.lectureList;
		lectureTrTags = "";
		infoTrTags = "";
		
		if (lectureList?.length > 0) {			//adrList가 있고 length가 0보다 크다
			$.each(lectureList, function() {
				lectureTrTags += makeLiTag(this);
				infoTrTags += makeInfoTag(this);
			});
		} else {
			lectureTrTags += `
			<li class="nav-item">
				목록이 없습니다.
			</li>
			`;
		}// if ~ else end

		$("#lectureList").html(lectureTrTags);
		$("#professorInfo").html(infoTrTags);
	});// getJSON end



	$(document).on("click", ".nav-link", function() {
		let listUrl = `${baseUrl}/studentList`;
		var lecCode = $(this).data("lectureCode");

		$.ajax({
			url:listUrl,
			type:'get',
			dataType:'json',
			data: { 'lecCode': lecCode },
			success:function(resp) {

				let student = resp.paging;
				let lectureTrTag = "";
				
				if (student.length != 0) {
					$.each(student, function(i,v) {
						lectureTrTag += `
							<tr data-lecture-hakjum=${v.clsScore}>
								<td>${v.lectureVO.subCd}</td>
								<td>${v.studentVO.stdNo}</td>
								<td>${v.studentVO.stdName}</td>
								<td>${v.studentVO.stdId}</td>
								<td>${v.studentVO.stdTelno}</td>
								<td>${v.studentVO.stdAdd}</td>
								<td><input id="lectureHakjum" data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-danger" type="button" value="학점관리"/></td>
							</tr>
						`;
					})//$.each
					$("#studentListBody").html(lectureTrTag);
				} else {
					trTag += `
						<tr>
							<td colspan="5">수강중인 학생이 없습니다.</td>
						</tr>
					`;
				}
			},
			error:function(xhr) {
				alert("status : " + xhr.status);
			}
		});
	});
	

	$(exampleModal).on("hidden.bs.modal",function(){
		$(this).find("form")[0].reset();
	});
	
	$(document).on("click","#lectureHakjum",function(){
		let studentTr = $(this).parents("tr:first");
		let $studentTr = $(studentTr);
		let hakjum = $studentTr.data("lectureHakjum");
		
		$("#hakjum").text(hakjum);
	});
	
	
	$("#modify").on('click', function() {
		let flag = confirm("학점을 재등록 하시겠습니까?");
		if (!flag) {return false;}
		
		let data = $("#hakjumModify").serializeJSON();
		let json = JSON.stringify(data);
		
		console.log(json);
		let settings = {
			url: `${cPath}/professor/studentList`,
			method: "post",
			data: json,
			contentType: 'application/json;charset=utf-8',
			dataType: 'json'
		};
		
		$.ajax(settings)
			.done(function(resp) {
				if (resp.success) {
					 $(hakjumModify).reset();
				} else {
					alert(resp.message);
				}
			});

	});


});