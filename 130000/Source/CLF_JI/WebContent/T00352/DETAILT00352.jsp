<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../scripts/ad-gallery/jquery.ad-gallery.css">
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/ad-gallery/jquery.ad-gallery.js"></script>
<script type="text/javascript">
function showimg(zpid){
	window.open(zpid);
}
$(function() { 	
	
    $('.ad-gallery').adGallery();
     
  });
</script>
 <style type="text/css">
  * {
    font-family: "宋体","Lucida Grande", "Lucida Sans Unicode", "Lucida Sans", Verdana, Arial, sans-serif;
    color: #333;
    line-height: 140%;
  }
  select, input, textarea {
    font-size: 1em;
  }
  body {
  	font-size: 70%;
    width: 800px;
    margin: 0;
    padding: 0;
  }
  h2 {
    margin-top: 1.2em;
    margin-bottom: 0;
    padding: 0;
    border-bottom: 1px dotted #dedede;
  }
  h3 {
    margin-top: 1.2em;
    margin-bottom: 0;
    padding: 0;
  }
  .example {
    border: 1px solid #CCC;
    background: #f2f2f2;
    padding: 10px;
  }
  ul {
    list-style-image:url(list-style.gif);
  }
  pre {
    font-family: "Lucida Console", "Courier New", Verdana;
    border: 1px solid #CCC;
    background: #f2f2f2;
    padding: 10px;
  }
  code {
    font-family: "Lucida Console", "Courier New", Verdana;
    margin: 0;
    padding: 0;
  }

  #gallery {
    padding: 20px;
    background: #e1eef5;
  }  
  #descriptions {
    position: relative;
    height: 50px;
    background: #EEE;
    margin-top: 10px;
    width: 640px;
    padding: 10px;
    overflow: hidden;
  }
    #descriptions .ad-image-description {
      position: absolute;
    }
      #descriptions .ad-image-description .ad-description-title {
        display: block;
      }
  </style>
</head>
<body>
	<div id="container">
	<div id="gallery" class="ad-gallery">
      <div class="ad-image-wrapper">
      </div>
      <div class="ad-controls">
      </div>
      <div class="ad-nav">
        <div class="ad-thumbs">
          <ul class="ad-thumb-list">
          <s:if test="%{tabList.size != 0}">
          <s:iterator status="index" value="tabList">
            <li>
            	<s:property value="note" /><s:if test='%{null == zpid || "" == zpid}'><a href="../images/noPic.gif">
					<img src="../images/MinnoPic.gif" alt="<s:property value="note" />" />
				</a>
			  </s:if>
			  <s:else>
				 <a href="<s:property value="zplj" />">
					<img src="<s:property value="zpljMin" />" alt="<s:property value="note" />" />
				</a>
			  </s:else>			  
			  <s:if test="%{zplx == 1}">
<!--			  <img onclick="window.parent.addTabflash('楼房相关','xtwh/FRAMET00306.action?zpFk=<s:property value="cd00352xqdm" />','mainFrameframe00306');" src="../images/ico/xx.gif" style="cursor: hand;" title="楼房相关信息" alt="楼房相关信息" width="16" height="16" align="absmiddle" />   -->
			  </s:if>			  
			  <s:else>
<!-- 			  <img onclick="window.parent.setXqxxByPic('<s:property value="SZQY" />','<s:property value="txtXQDM" />');" src="../scripts/easyui/themes/icons/edit_add.gif" style="cursor: hand;" title="房产录入" alt="房产录入" width="16" height="16" align="absmiddle" />   -->
			  </s:else>
			  <img onclick="showimg('<s:property value="zpLjdownLoad" />')" src="../images/ico/light.gif" style="cursor: hand;" title="查看原始图片" alt="查看原始图片" width="16" height="16" align="absmiddle" />  			  
            </li>            
            </s:iterator>   
            </s:if>     
            <s:else>
             <a href="../images/noPic.gif"><img src="../images/MinnoPic.gif" alt="<s:property value="note" />" /></a>
            </s:else>   
		   </ul>
        </div>
      </div>
    </div>		
    
	</div>
</body>
</html>