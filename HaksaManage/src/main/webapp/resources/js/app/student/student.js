/**
 * 
 */
$(()=>{
	const cPath = $(document.body).data('contextPath');
	const baseUrl = `${cPath}/student`;
	$('#lectureList').parents('div').removeClass('d-flex');
	
	
	$.getJSON(`${cPath}/student`)
		.done(function(resp){
			trTags = "";
			mytrTags = "";
			let list = resp.lectureList;
			let myList = resp.myList;
			if(list.length > 0){
				$.each(list,function(i,v){
					trTags += makeLectureListTrTag(v);
				})
			}else{
				trTags = "<tr><td colspan='8'>수강신청 가능한 강의 목록이 없습니다.</td></tr>"
			}
			if(myList.length > 0){
				$.each(myList,function(i,v){
					mytrTags += makeMyListTrTag(v);
				})
			}else{
				mytrTags = "<tr><td colspan='8'>수강신청한 강의 목록이 없습니다.</td></tr>"
			}
			$('#lectureList').html(trTags);
			$('#currList').html(mytrTags);
		});
	
	// 수강신청 취소 버튼
	$(currList).on("click", ".cancelBtn", function(){
		let flag = confirm("정말로 취소하시겠습니까?")
		if(!flag) return false;
		let stTr = $(this).parents("tr:first");
		let $stTr = $(stTr);
		let stNo = $stTr.data("lecCd");
		let url = `${baseUrl}/${stNo}`;
		let settings = {
			url: url,
			method: "post",
			dataType : "json"
		};
		$.ajax(settings)
			.done(function(resp){
				if(resp.result){
					$stTr.remove();
					let lecture = resp.lecture;
					let code = makeLectureListTrTag(lecture);
					$('#lectureList').append(code);
				}else{
					alert(resp.message);
				}
		})
	});
	
	// 수강신청 버튼
	$('#lectureList').on('click','.enrollBtn',function(event){
		let $targetTrTag = $(event.target).parents('tr');
		let lecCd = $targetTrTag.data('lecCd');
		
		let method = "post";
		let settings = {
			url : baseUrl,
			method : method,
			data : {"lecCd": lecCd },
			dataType : "json"
		};
		$.ajax(settings)
			.done(function(resp){
				if(resp.result){
					let lectureVO = resp.lecture;
					let code = makeMyListTrTag(lectureVO);
					$('#currList').append(code);
					$targetTrTag.remove();
				}else{
					alert(resp.message);
				}
			});
	});
})

const weeks = ["월","화","수","목","금"];

var makeLectureListTrTag = (lectureVO) =>{
	let code = `<tr data-lec-cd="${lectureVO.lecCd}">`;
	if(lectureVO.currPerson == lectureVO.lecPerson){
		code += `<td><span class="text-red">수강인원제한</span></td>`;
	}else{
		code += `<td><button type="button" class="enrollBtn">수강신청</button></td>`;
	}
	code +=`
		<td>${lectureVO.subjectVO.subGrade}</td>
		<td>${lectureVO.subjectVO.subName}</td>
		<td>${lectureVO.professorVO.proName}</td>
		<td>${lectureVO.lecRoom}</td>
		<td>${lectureVO.lecTime}</td>
		<td>${weeks[lectureVO.lecWeek-1]}</td>
		<td>${lectureVO.lecPerson}</td>
		<td>${lectureVO.currPerson}</td>
	</tr>
	`;
	return code;
}
var makeMyListTrTag = (lectureVO) =>{
	let code = `<tr data-lec-cd="${lectureVO.lecCd}">`;
	code += `<td><button type="button" class="cancelBtn">수강 취소</button></td>`;
	code +=`
		<td>${lectureVO.subjectVO.subGrade}</td>
		<td>${lectureVO.subjectVO.subName}</td>
		<td>${lectureVO.professorVO.proName}</td>
		<td>${lectureVO.lecRoom}</td>
		<td>${lectureVO.lecTime}</td>
		<td>${weeks[lectureVO.lecWeek-1]}</td>
		<td>${lectureVO.lecPerson}</td>
		<td>${lectureVO.currPerson}</td>
	</tr>
	`;
	return code;
}

