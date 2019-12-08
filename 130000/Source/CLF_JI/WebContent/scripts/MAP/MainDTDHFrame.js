
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
  
  //点查询
  function searchByPoint()
  {
  	if(flashPlayer!=null)
  	{
  		var result=flashPlayer.searchByPoint();
  	}
  }
  
  //框查询
  function searchByRect()
  {
  	if(flashPlayer!=null)
  	{
  		var result=flashPlayer.searchByRect();
  	}
  }
  
  //多边形查询
  function searchByPolygon()
  {
  	if(flashPlayer!=null)
  	{
  		var result=flashPlayer.searchByPolygon();
  	}
  }
  
  //是否地图测量
  //var bMeasureLength=false;
  function isMeasureLength()
  {
  	if(flashPlayer!=null)flashPlayer.MapMeasureLength();
  }
  
  //是否矩形查询
  //var bRectSel=false;
  function isRectSel()
  {
  	if(flashPlayer!=null)flashPlayer.MapRectSel();
  }
  
  //是否多边形查询
  //var bPolySel=false;
  function isPolySel()
  {
  	if(flashPlayer!=null)flashPlayer.MapPolySel();
  }  
  
  function CompareTDDJ()
  {
	  $("#DcxxID").empty();	
  	if(flashPlayer!=null)flashPlayer.CompareTDDJ();
  } 
  
  function CompareInfo(info)
  {
	  var strDCID = "DCID:";//要DCID参数
	  var strNSRMC = "NSRMC:";//要NSRMC参数
	  var strTTDDJ = "TTDDJ:";//要TTDDJ参数
	  var arrInfo = info.split(",");
	  var DCID = "";
		var NSRMC = "";
		var TTDDJ = "";
		var strHtml = "";
	  $.each(arrInfo, function(i, n){
			//得到地产ID
			if (n.indexOf(strDCID)!=-1)
			{
				DCID = n.substr(strDCID.length, n.length);			
			}
			//得到企业名称
			if (n.indexOf(strNSRMC)!=-1)
			{
				NSRMC = n.substr(strNSRMC.length, n.length);			
			}
			//得到企业名称
			if (n.indexOf(strTTDDJ)!=-1)
			{
				TTDDJ = n.substr(strTTDDJ.length, n.length);			
			}
		});
	//把选择的信息添加到列表中
		strHtml=$("#DcxxID").html() + "<a href=\"../sjcx/VIEWV120000.action?DCID=" + DCID + "\" title=\"" + NSRMC + "(" + TTDDJ + ")" + "\" target=\"_blank\">" + NSRMC+ "(" + TTDDJ + ")" + "</a></br>";
		$("#DcxxID").html(strHtml);
  }
  
  //显示矩形，多边形查询结果
  function showPoiInfo(info)
  {
	//$("#DcxxID").empty();	
	var strHtml = "";
	var strDCID = "DCID:";//要DCID参数
	var strNSRMC = "NSRMC:";//要NSRMC参数
	var strDCIDs = "";//地产ID
	if (info!="")
	{ 
		var arrInfo = info.split(";");		
		$.each(arrInfo, function(k, m){		
			var arr = m.split(",");	
			var DCID = "";
			var NSRMC = "";
			$.each(arr, function(i, n){
				//得到地产ID
				if (n.indexOf(strDCID)!=-1)
				{
					DCID = n.substr(strDCID.length, n.length);			
				}
				//得到企业名称
				if (n.indexOf(strNSRMC)!=-1)
				{
					NSRMC = n.substr(strNSRMC.length, n.length);			
				}
			});
			//把地产信息添加到列表中
			strDCIDs+="," + DCID;
			//把选择的信息添加到列表中
			strHtml+="<a href=\"../sjcx/VIEWV120000.action?DCID=" + DCID + "\" title=\"" + NSRMC + "\" target=\"_blank\">" + NSRMC + "</a></br>";
		});	
		
		$("#btnTj").show();
	}
	else
	{
		$("#btnTj").hide();		
	}
	$("#DcxxID").html(strHtml);
	$("#hidDCID").val(strDCIDs);	
  }
  
  //得到地图坐标
  function showMapXY(xy)
  {
	  var strX = "x:";//要DCID参数
	  var strY = "y:";//要NSRMC参数
	  var X = "";
	  var Y = "";
	  var DCID = $("#hidDCID").val();
	  var arr = xy.split(",");
	  $.each(arr, function(i, n){
			//得到地产ID
			if (n.indexOf(strX)!=-1)
			{		
				X = n.substr(strX.length, n.length);			
			}
			//得到企业名称
			if (n.indexOf(strY)!=-1)
			{
				Y = n.substr(strY.length, n.length);			
			}
		});	
	  $.ajax({
		     type:'GET',url:'UpdCBSYDCXX.action',data:'X='+ X + '&Y=' + Y + '&DCID=' + DCID,
		     success:function(res){
		  		addMarker(X,Y,"00002",DCID,"","");
	  			},
		     error:function(){alert('意外错误导致失败!');}
	  });
  }
  
  //添加点标注
  function addMarker(x,y,jjlx,dcid,nsrmc,swid)
  {
		var img="images/"+jjlx+".png";
		if(flashPlayer!=null)flashPlayer.addMarker(x,y,nsrmc,img,"DCID="+dcid+"&SWID="+swid);
	}
  
  //设置地图开始得到坐标
  var bShowMapXY=false;
  function getMapXY()
  {
  	bShowMapXY=!bShowMapXY;
  	if(flashPlayer!=null)
  	{
  		flashPlayer.isGetMapXY(bShowMapXY);     		
  	} 
  }
  
  function showIdentifyInfo(info)
  {
	alert(info);
	var DCID = "DCID:";//要得到参数
	var arr = info.split("/n");	
	$.each(arr, function(i, n){
		if (n.indexOf(DCID)!=-1)
		{		
			alert( "Name: " + i + ", Value: " + n.substr(DCID.length, n.length));
		}
	});	 
  }
  
	//设置地产位置信息
	function upDcxx(dcid) {        
	    $('#hidDCID').val(dcid);  
	    getMapXY();
	}
  
  $(document).ready(function() {	
		pageInit();
		//加载时让统计按钮不显示。
		$("#btnTj").hide();
		//统计信息
		$('#btnTj').click(function()
		{ 			
			var DCID=$("#hidDCID").val();
			if (DCID=="" || DCID==",") {alert("未找到统计的记录！");return;}
			Show('../sjcx/FindDcxxTotal.action?DCID='+DCID,200,300);			
		});
	});
  