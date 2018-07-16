<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>list</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {		
		$(".delete").click(function() {
			var a = $(this);
			var id = a.parent().parent().children()[0].innerHTML;
			var flag = confirm("您确认删除id为" + id + "的信息吗");
			if (flag) {
				var url = this.href;
				var args = {};
				$.post(url, args, function(data) {
					if (data == "success") {
						var tr = a.parent().parent();
						tr.remove();
					}
				})
			}
			return false;
		})
	})
</script>

</head>
<body>
	<table border="1" cellspacing="1">

		<tr>
			<td>ID</td>
			<td>LASTNAME</td>
			<td>EMAIL</td>
			<td>BIRTH</td>
			<td>CREATETIME</td>
			<td>DEPT</td>
			<td>DELETE</td>
			<td>EDIT</td>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.employeeId}</td>
				<td>${employee.lastname}</td>
				<td>${employee.email}</td>
				<td>${employee.birth}</td>
				<td>${employee.createTime}</td>
				<td>${employee.dept.name}</td>
				<td><a href="${pageContext.request.contextPath}/main/delete/${employee.employeeId}"
					class="delete">Delete</a></td>
				<td><a href="${pageContext.request.contextPath}/main/editPage/${employee.employeeId}">edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/main/addPage">add</a>
</body>
</html>