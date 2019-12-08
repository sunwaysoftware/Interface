<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>版本更新信息</title>
<link href="css/screen.css" rel="stylesheet" type="text/css" />
<style>
.content {
	text-align: left;
}
.content h2 {
	margin: 0 0 0 20px;
}
.content ol {
	margin: 5px 0 20px 44px;
	list-style-position: outside;
	line-height: 18px;
	list-style: decimal;
	color: #808080;
}
</style>
</head>
<body>
	<div class="content">
		<h2>
			Version 1.6<span>(2015.07.30)</span>
		</h2>
		<ol>
			<li>新增：评估结果通知单数据传入金税三期系统</li>
			<li>新增：完税认定读取金税三期完税税额</li>
                        <li>删除：评估结果通知单数据传入大集中系统</li>
                        <li>删除：完税认定读取大集中完税税额</li>
		</ol>	            
		<h2>
			Version 1.5<span>(2014.07.20)</span>
		</h2>
		<ol>
			<li>新增：查询统计中增加[分税种统计]模块</li>
		</ol>	            
		<h2>
			Version 1.4<span>(2013.05.14)</span>
		</h2>
		<ol>
			<li>新增：查询统计中增加[征收单位统计]模块</li>
			<li>修正：[查询统计]权限在采集评估岗位中去除</li>
		</ol>		
		<h2>
			Version 1.3<span>(2013.05.06)</span>
		</h2>
		<ol>
			<li>修正：[数据采集]房屋类型对总楼层的限制</li>
		</ol>	
		<h2>
			Version 1.2<span>(2013.04.18)</span>
		</h2>
		<ol>
			<li>修正：[已认定的数据查询]更新日期查询失效</li>
			<li>修正：[已认定的数据查询]中个别数据导出缴税信息为0</li>
		</ol>
		<h2>
			Version 1.1<span>(2013.03.11)</span>
		</h2>
		<ol>
			<li>修正：个案评估原因可以为空</li>
			<li>优化：估价分区图片批量上传</li>
			<li>新增：已认定的数据导出信息列[个案原因]</li>
			<li>新增：系统更新内容日志</li>
		</ol>
	</div>
</body>
</html>