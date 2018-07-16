<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>session list</title>
</head>
<body>

	<table>
		<c:forEach items="${sessionSet}" var="sessionInfo">
			<tr>
				<td>${sessionInfo.sessionID}</td>
				<td><a href="${pageContext.request.contextPath}/messenger/sendMessage/${sessionInfo.sessionID}"
		id="newMessage">send message</a></td>
			</tr>
		</c:forEach>
	</table>



	
</body>
</html>