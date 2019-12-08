var flashPlayer=null;
  function pageInit() 
  {
  	flashPlayer=getFlashPlayer("ArcGisMap");
 	//alert(flashPlayer);
  }
  
  function getFlashPlayer(swfName) 
  {
      if (navigator.appName.indexOf("Microsoft") != -1) 
      {
          return window[swfName];
      } 
      else 
      {
          return document[swfName];
      }
  }  

	//放大
	function zoomIn() 
	{
		if(flashPlayer!=null)flashPlayer.mapZoomIn();
	}
	//平移
	function pan() 
	{
		if(flashPlayer!=null)flashPlayer.mapPan();     
	}
	//缩小
	function zoomOut() 
	{
		if(flashPlayer!=null)flashPlayer.mapZoomOut();
	}
	//全图
	function fullExtent()
	{	
		if(flashPlayer!=null)flashPlayer.mapFullExtent();
	}
  
  //前视图
  function forward()
  {
	if(flashPlayer!=null)flashPlayer.mapForward();
  }
	
  //后视图
  function backward()
  {
	if(flashPlayer!=null)flashPlayer.mapBackward();     
  }
  
  //点定位,输入X,Y坐标
  function mapCenterAt()
  {
  	if(flashPlayer!=null)flashPlayer.mapCenterAt(1576628.9450670918,5014024.992840381);
  }
  
//是否地图测量
//var bMeasureLength=false;
function isMeasureLength()
{
	if(flashPlayer!=null)flashPlayer.MapMeasureLength();
}
  
  //是否点查询？
  function isIdentify()
  {
  	if(flashPlayer!=null)flashPlayer.MapIdentify();
  }
  //显示点查询结果
  function showIdentifyInfo(info)
  {
	var strCODE = "CODE:";//要得到参数
	var CODE = "";
	var arr = info.split(",");	
	$.each(arr, function(i, n){
		if (n.indexOf(strCODE)!=-1)
		{	
			CODE = n.substr(strCODE.length, n.length);
		}
	});	
	//alert(CODE);
	$.ajax({
	     type:'GET',url:'FindMaxMinSLK.action',data:'XQDM=' + CODE,
	     success:function(res){			
		 	if(flashPlayer!=null) flashPlayer.Msgbox(res,"小区价格");
 			},
	     error:function(){alert('意外错误导致失败!');}
	});
  }	
  
  $(document).ready(function() {	
		pageInit();		
	});
  