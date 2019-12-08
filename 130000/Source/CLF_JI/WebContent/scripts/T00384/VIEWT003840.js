$(document).ready(function() {
	//$("#scroll2").grid();
//	//查询
//	$("#btnSearch").click(function(){
//		//findShReason();
//	});	
});


/**
 * 彈出追加參數窗體
 * @param value 審核類型
 */

function showParamWin(value){
	var randomnumber=Math.floor(Math.random()*100000);
	window.parent.addTabflash('信息数据变更',encodeURI(value+ "&rand="+randomnumber),'FrameSHBG');

}


