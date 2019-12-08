$(document).ready(function() {
	// checkbox
	$(".rootCheck").click(function() {
		$(".childCheck").each(function() {
			$(this)[0].checked = $(".rootCheck")[0].checked;
		});
	});
	$(".childCheck").click(function() {
		var b = true;
		$(".childCheck").each(function() {
			if (!$(this)[0].checked) {
				b = false;
			}
		});
		$(".rootCheck")[0].checked = b;
	});
});