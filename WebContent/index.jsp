<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Insert title here</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {

		function showMessage() {
			var url = "${pageContext.request.contextPath}/messenger/getMessage";
			var args = {};
			$.post(url, args, function(data) {
				$("#messageBlock").text(data);
			});
		}
		setInterval(showMessage, 500);

	})
</script>

</head>
<body>
	<a href="${pageContext.request.contextPath}/main/list">list</a>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/main/addPage">add</a>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/main/selectEmployee">二级联动</a>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/messenger/sessionList">sessions</a>
	<br>
	<br>
	<div id="messageBlock"></div>
</body>
</html>