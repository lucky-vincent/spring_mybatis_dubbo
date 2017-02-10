<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>用户列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="../js/jquery/pagination.css">
<script type="text/javascript"
	src="../js/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript"
	src="../js/jquery/jquery.pagination.js"></script>

<script type="text/javascript">
	var total_size = 0;//总数据条数
	var page_size = 30;//每页显示数
	var pageIndex = 0;//当前页码
	$(document).ready(function() {
		//初始化分页，展示分页信息并动态获取总数据条数、每页展示条数
		initPagination(pageIndex);
		//初始化分页插件
		$("#Pagination").pagination(total_size, {
			callback : pageselectCallback,
			prev_text : '上一页',
			next_text : '下一页',
			link_to : 'javascript:void(0);',//分页的链接,默认“#”
			items_per_page : page_size,//每页显示的条目数           
			num_display_entries : 5,//连续分页主体部分显示的分页条目数   
			current_page : pageIndex,//当前选中的页面
			num_edge_entries : 1//两侧显示的首尾分页的条目数
		});
	});
	/**
	 *分页插件回调方法，page_index为当前页码
	 */
	function pageselectCallback(page_index, jq) {
		initPagination(page_index);
	}
	/**
	 *初始化分页，展示分页信息并动态获取总数据条数、每页展示条数
	 */
	function initPagination(page_index) {
		$.ajax({
			url : "../member/getList.html",
			data : {
				currentPage : page_index + 1,
				pageSize : page_size,
				totalSize : total_size
			},
			type : "GET",
			dataType : "json",
			async : false,
			success : function(data) {
				if (!$.isEmptyObject(data)) {
					page_size = data.pageSize;
					total_size = data.totalSize;
					var htmlStr = "";
					$.each(data.list, function(i, item) {
						htmlStr += "<li>ID:" + item.id + " 名称：" + item.memberName + " 密码：" + item.memberPassword +" 创建时间：" + item.createDate +"<li/>";
					});
					$("#list").html(htmlStr);
				} else {
					alert("系统异常！");
				}
			}
		});
	}
</script>

</head>

<body>
	<center>
		<ul id="list" style="list-style-type: none;">
		</ul>
		<div id="Pagination" class=""></div>
	</center>
</body>
</html>
