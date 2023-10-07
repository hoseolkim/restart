/**
 * 
 */
$(function() {
	const baseURL = $(document.body).data('contextPath');
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