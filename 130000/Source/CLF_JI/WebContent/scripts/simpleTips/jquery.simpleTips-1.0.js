var config = new Object();
Tip = function(source,title,content,twidth,millisec){
	UnTip();
	if (!twidth){twidth=200;}
    title = title || ' 提示↓&nbsp;';
	var $source = (typeof(source)== 'object') ? $(source) : $('#'+source);
	$source.css('cursor','pointer');
	
	var suffx = $source.attr('id') ? $source.attr('id') : new Date().getTime();
	config.jtipId = "Tip_" + suffx;
	var jtipContentId = "TipInner_" + suffx;
	
	var closeHTML = "<a href='javascript:void(0);' onclick='$(this).parent().parent().remove();' class='tips-titlebar-close'><span class='tips-icon'></span></a>";
	var thePos = $source.offset();
	
	var screenW = $(window).width();
	
	var arrowW = 11;
	
	
	var showTipOnRight = (screenW - thePos.left - $source.width() - arrowW)>twidth;
	var tipX = 0;
	
	if(showTipOnRight){
		$("body").append("<div id='" +config.jtipId+ "' class='Tip' style='width:"+twidth+"px'><div class='Tip_arrow_left'></div><div class='Tip_close_left'>"+title+closeHTML+"</div><div class='Tip_content' id='" +jtipContentId+ "'></div></div>");//right side
		var arrowOffset = $source.width() + arrowW;
		tipX = thePos.left + arrowOffset; //set x position
	}else{
		$("body").append("<div id='" +config.jtipId+ "' class='Tip' style='width:"+twidth+"px'><div class='Tip_arrow_right' style='left:"+twidth+"px'></div><div class='Tip_close_right'>"+title+closeHTML+"</div><div class='Tip_content' id='" +jtipContentId+ "'></div></div>");//left side
		tipX = thePos.left - twidth - arrowW + 1; //set x position
	}
	
	$('#'+config.jtipId).css({left: tipX+"px", top: thePos.top+"px"});
	$('#'+config.jtipId).fadeIn("slow");
	$('#'+jtipContentId).html(content);
	
	if(millisec)setTimeout("jTipHide('" +config.jtipId+ "')",millisec);
	
	jTipHide = function(objectId){
	  $('#'+objectId).fadeOut("slow",function(){
		 $(this).remove();
	  });
   }
};
UnTip = function(){	
	$('#'+config.jtipId).fadeOut("slow",function(){
		 $(this).remove();
	  });
};