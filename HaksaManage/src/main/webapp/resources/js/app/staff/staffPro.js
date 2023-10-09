/**
 * 
 */

function fn_paging(page){
	searchForm.page.value = page;
	searchForm.requestSubmit();
}

var makeProfessorListTrTag = (professor)=>{
	let trTag = 
	`
		<tr>
			<td>${professor.rnum }</td>
			<td>${professor.proCd }</td>
			<td>${professor.proName }</td>
			<td>${professor.proMajor }</td>
			<td>${professor.proDeptno }</td>
			<td>${professor.proTelno }</td>
			<td>
				<button type="button" class="btn btn-danger delBtn">삭제</button>
			</td>
		</tr>
	`;
	return trTag;
};

$(function() {
	const baseURL = $(document.body).data('contextPath');
	$(searchUI).on("click","#searchBtn",function(event){
		let inputs = $(this).parents('#searchUI').find(':input[name]');
		$.each(inputs,function(idx, ipt){
			let name = ipt.name;
			let value = $(ipt).val();
			$(searchForm).find(`:input[name=${name}]`).val(value);
		});
		
		$(searchForm).submit();
		
	});
	
	$(searchForm).on('submit',function(event){
		event.preventDefault();
		let url = this.action;
		let data = $(this).serialize();
		
		let settings = {
			url : url,
			data : data,
			dataType : 'json'
		}
		$.ajax(settings)
			.done(function(resp){
				let paging = resp.paging;
				let professorList = paging.dataList;
				let code = "";
				if(professorList?.length > 0){
					$.each(professorList,function(i,v){
						code += makeProfessorListTrTag(v);
					})
				}else{
					code += "<tr><td colspan='7'>교수 데이터가 없습니다</td></tr>";
				}
				let pagingCode = `${paging.pagingHTML}`;
				$(pagingHTML).html(pagingCode);
				$(profList).html(code);
			})
		
		return false;
	});
	
	$(searchForm).submit();
	
	$(".delBtn").on("click", function() {
		if (confirm("교수를 삭제하시겠습니까?")) {
			let $trTag = $(this).parents('tr');
			let proCd = $trTag.find('td:eq(1)').text();
			let url = `${baseURL}/staff/professor/${proCd}`;

			let settings = {
				url: url,
				method: 'post',
				data: { "proCd": proCd },
				dataType : 'json'
			};

			$.ajax(settings)
				.done(function(resp) {
					if (resp.result) {
						alert(resp.message); // 성공 또는 실패 메시지 표시
						$trTag.remove(); // 행 삭제
					} else {
						alert(resp.message); // 성공 또는 실패 메시지 표시
					}
				});
		}
		/*
			if (confirm("교수를 삭제하시겠습니까?")) {
				$.ajax({
					type: "POST",
					url: cPath + "/staff/professor/delete",
					data: { proCd: proCd },
					dataType: "json", // JSON 형식으로 응답을 예상함
					success: function (data) {
						if (data.result) {
							alert(data.message); // 성공 또는 실패 메시지 표시
							currentRow.remove(); // 행 삭제
						} else {
							alert(data.message); // 성공 또는 실패 메시지 표시
						}
					},
					error: function () {
						alert("서버 요청에 실패했습니다.");
					}
				});
			}*/
	});
	
	

})