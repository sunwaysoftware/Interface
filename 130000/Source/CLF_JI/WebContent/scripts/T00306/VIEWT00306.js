$(document).ready(function(){
	
	$("#btnUpd").click(function(){
		if($("#uploadForm").valid()){
			$("#loading").show();
			$("#uploadForm").submit();
		}
	});
});

