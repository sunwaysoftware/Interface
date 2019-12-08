$(document).ready(function() {	

	$('.rootCheck').click(function(){ 		
		$(".childCheck").each(function(){	
			$(this)[0].checked=$('.rootCheck')[0].checked;
		});			
	});
	// 添加
	$("#tjLink").click(function() {
		var b = false;
		$(".childCheck").each(function() {
			if ($(this)[0].checked) {
				b = true;
			}
		});
		if (!b) {
			alert('请选择要添加的数据！');
			return;
		}
		$("#hidFlag").val(1);
		$("#editForm").attr("action", "EXECT00305W.action");
		$("#editForm").submit();
	});
});

