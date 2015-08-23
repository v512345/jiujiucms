<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8" />
	<title>${pd.SYSNAME}</title>
	<meta name="description" content="overview & stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- basic styles -->
	<link href="static/css/bootstrap.min.css" rel="stylesheet" />
	<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<!-- page specific plugin styles -->
	<!-- 下拉框-->
	<link rel="stylesheet" href="static/css/chosen.css" />
	<!-- ace styles -->
	<link rel="stylesheet" href="static/css/ace.min.css" />
	<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
	<link rel="stylesheet" href="static/css/ace-skins.min.css" />
	
	
	<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
	
	<!--引入弹窗组件start-->
	<script type="text/javascript" src="plugins/attention/zDialog/zDrag.js"></script>
	<script type="text/javascript" src="plugins/attention/zDialog/zDialog.js"></script>
	<!--引入弹窗组件end-->

	<!-- 引入ztree 开始 -->
	<link rel="stylesheet" href="plugins/zTree/3.5/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="static/js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="plugins/zTree/3.5/jquery.ztree.core-3.5.js"></script>
	<!-- 引入ztree 结束 -->
	</head>
<body>		
<div class="container-fluid" id="main-container">
<table style="width:100%;" border="0">
<tr>
		<td style="width:15%;" valign="top" bgcolor="#F9F9F9">
			 <ul class="nav nav-tabs" id="myTab">
              <li class="active"><a data-toggle="tab" href="javascript:void(0);"><i class="green icon-home bigger-110"></i> 栏目</a></li>
              <li><a data-toggle="tab" href="javascript:void(0);"><i class="green icon-home bigger-110"></i> 编辑</a></li>
            </ul>
            
            <div class="tab-content" id="tab-content1">
			  <div id="home" class="tab-pane in active">
				<div style="width:15%;">
					<ul id="leftTree" class="ztree"></ul>
				</div>
			  </div>
			  <div id="profile" class="tab-pane">
				<div>
					<p>栏目菜单管理=======>>>></p>
				</div>
			  </div>
            </div>
			<script type="text/javascript">
				$("#myTab li").each(function(){
					$(this).click(function(){
						$(this).addClass("active").siblings().removeClass("active");
						if($(this).index() == 0){
							$("#home").attr("class","tab-pane in active");
							$("#profile").attr("class","tab-pane");
							$("#treeFrame").attr("src","/happuser/listUsers.do");
						}else{
							$("#profile").attr("class","tab-pane in active");
							$("#home").attr("class","tab-pane");
							$("#treeFrame").attr("src","/template/parentTemplateList.do");
						}
					});
					
				});
			</script>
		</td>
		<td style="width:85%;" valign="top" >
			<iframe name="treeFrame" id="treeFrame" frameborder="0" src="<%=basePath%>/happuser/listUsers.do" style="margin:0 auto;width:100%;height:100%;"></iframe>
		</td>
	</tr>
</table>
</div><!--/.fluid-container#main-container-->
		
<SCRIPT type="text/javascript">
		
var setting = {
	view: {
		showIcon: showIconForTree
	},
	data: {
		simpleData: {
			enable: true
		}
	}
};

var zNodes =eval("("+'${s}'+")");
		
function showIconForTree(treeId, treeNode) {
	return !treeNode.isParent;
};

$(document).ready(function(){
	$.fn.zTree.init($("#leftTree"), setting, zNodes);
});
			
/**控制tree的位置**/		
function treeFrameT(){
	var hmainT = document.getElementById("treeFrame");
	var bheightT = document.documentElement.clientHeight;
	hmainT .style.width = '100%';
	hmainT .style.height = (bheightT-7) + 'px';
}
treeFrameT();
/**窗口大小改变**/
window.onresize=function(){  
	treeFrameT();
};
	</SCRIPT>
	</body>
</html>

