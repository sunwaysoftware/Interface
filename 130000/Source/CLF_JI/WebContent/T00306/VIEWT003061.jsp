<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accordion - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="demo.css">
	<script type="text/javascript" src="../jquery-1.6.min.js"></script>
	<script type="text/javascript" src="../jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function select(){
			$('#aa').accordion('select','Title1');
		}
		var idx = 1;
		function add(){
			$('#aa').accordion('add',{
				title:'New Title'+idx,
				content:'New Content'+idx
			});
			idx++;
		}
		function remove(){
			var pp = $('#aa').accordion('getSelected');
			if (pp){
				var title = pp.panel('options').title;
				$('#aa').accordion('remove',title);
			}
		}
	</script>
</head>
<body>
	<h2>Accordion</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>Click on panel header to show its content.</div>
	</div>
	
	<div style="margin: 10px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="select()">Select</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="add()">Add</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="remove()">Remove</a>
	</div>
	
	<div id="aa" class="easyui-accordion" style="width:700px;height:300px;">
		<div title="Title1" iconCls="icon-ok" style="overflow:auto;padding:10px;">
			<h3 style="color:#0099FF;">Accordion for jQuery</h3>
			<p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web page more easily.</p>
		</div>
		<div title="Title2" iconCls="icon-reload" selected="true">
			<table class="easyui-datagrid"
					url="datagrid_data2.json" border="false"
					fit="true" fitColumns="true">
				<thead>
					<tr>
						<th field="itemid" width="80">Item ID</th>
						<th field="productid" width="100">Product ID</th>
						<th field="listprice" width="80" align="right">List Price</th>
						<th field="unitcost" width="80" align="right">Unit Cost</th>
						<th field="attr1" width="150">Attribute</th>
						<th field="status" width="50" align="center">Status</th>
					</tr>
				</thead>
			</table>
		</div>
		<div title="Title3" style="padding:10px;">
			content3
		</div>
	</div>
</body>
</html>