<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>add page</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/main/add">
		Lastname:<input type="text" name="lastname"> <br> Email:
		<input type="text" name="email"> <br> Birth: <input
			type="date" name="birth"> <br> Department:<select
			name="deptId">
			<c:forEach items="${depts}" var="dept">
				<option value="${dept.deptId}">${dept.name}</option>
			</c:forEach>
		</select> <br> <input type="submit" value="修改" />
	</form>
</body>
</html>