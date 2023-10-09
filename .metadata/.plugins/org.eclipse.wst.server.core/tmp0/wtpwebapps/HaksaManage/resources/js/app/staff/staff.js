/**
 * 
 */
function fn_paging(page){
	searchForm.page.value = page;
	searchForm.requestSubmit();
}

var makeStudentListTrTag = (student) => {
	let trTag = `
	<tr>
		<td data-std-no="${student.stdNo }">${student.stdNo }</td>
		<td data-std-no="${student.stdNo }"><a href="javascript:;" data-bs-toggle="modal" data-bs-target="#studentDetailView">${student.stdName }</a></td>
		<td>${student.stdId }</td>
		<td>${student.stdTelno }</td>
		<td>${student.stdAdd }</td>
		<td data-pro-cd="${student.proVO.proCd }">${student.proVO.proName }</td>
		<td>
			<button id="stdUdtBtn" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#studentDetail" >수정</button>
			<button id="stdDelBtn" class="btn btn-primary" data-bs-toggle="modal" >삭제</button>
		</td>
	</tr>
	`;
	return trTag;
}

$(()=>{
	
	$(studentDetailView).on('show.bs.modal',function(event){
		let stdNo = $(event.relatedTarget).parent().data('stdNo');
		
		let url = `${cPath}/staff/studentDetailView`;
		let data = {who : stdNo};
		
		let settings = {
			url : url,
			data : data
		};
		
		$.ajax(settings)
			.done(function(resp){
				$(detailViewBody).html(resp);
			})
	}).on('hidden.bs.modal',function(){
				$(detailViewBody).empty();
	})
	
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
				let code = ""
				let paging = resp.paging;
				let dataList = paging.dataList;
				let paginationNav = paging.pagingHTML;
				if(dataList?.length > 0 ){
					$.each(dataList,function(i,v){
						code += makeStudentListTrTag(v);
					});
				}else{
					code += `
						<tr>
							<td colspan="7">
								학생 목록이 없습니다.
							</td>
						</tr>
					`;
				}
				$(paginationHTML).html(paginationNav);
				$(studentList).html(code);
				
			});
		
		return false;
	});
	$(searchUI).on("click","#searchBtn",function(event){
		let inputs = $(this).parents('#searchUI').find(':input[name]');
		$.each(inputs,function(idx, ipt){
			let name = ipt.name;
			let value = $(ipt).val();
			$(searchForm).find(`:input[name=\${name}]`).val(value);
		});
		
		$(searchForm).submit();
		
	});
	
	$(searchForm).submit();
	
	const cPath = $(document.body).data("contextPath");
	const baseUrl = `${cPath}/staff/student`;
	
	$(document).on("click", "#stdUdtBtn", function(event) {
	  let trTag = $(this).parents('tr');
	  
      let stdNo = trTag.find('td:eq(0)').text();
      let stdName = trTag.find('td:eq(1)').text();
      let stdId = trTag.find('td:eq(2)').text();
      let stdTelno = trTag.find('td:eq(3)').text();
      let stdAdd = trTag.find('td:eq(4)').text();
      let proCd = trTag.find('td:eq(5)').data("proCd");
      let $modal = $(this).parents();
      let url = `${cPath}/staff/student`;
     
      $("#stdNo").val(stdNo);
      $("#stdName").val(stdName);
      $("#stdId").val(stdId);
      $("#stdTelno").val(stdTelno);
      $("#stdAdd").val(stdAdd);
      $("#proCd").val(proCd);

   });
   
	$(document).on("click", "#stdDelBtn", function(event){
		let flag = confirm("정말 삭제 하시겠습니까?");
		if(!flag) return false;
		
		let stdTr = $(this).closest("tr");
		let $stdTr = $(stdTr);
		let stdNo = stdTr.find("td[data-std-no]").data("stdNo");
		let url = `${baseUrl}/${stdNo}`;
		let settings = {
			url : url,
			method : "post",
			dataType : "json"
		};
		
		$.ajax(settings)
			.done(function(resp){
				if(resp.result){
					$stdTr.remove();
				}else{
					alert(resp.message);
				}
			});

	});
	
});