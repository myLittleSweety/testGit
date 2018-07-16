<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>select employees</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#deptSelector")
				.change(
						function() {
							$("#employeeSelector").find("option").remove();
							var deptId = $('#deptSelector option:selected')
									.val();

							if (deptId == 0) {
								return;
							}
							var url = "${pageContext.request.contextPath}/main/getEmployees/"
									+ deptId;
							var args = {};
							$
									.post(
											url,
											args,
											function(json) {
												var jsonarray = $
														.parseJSON(json);
												$(jsonarray)
														.each(
																function(index) {

																	$(
																			"#employeeSelector")
																			.append(
																					"<option>"
																							+ jsonarray[index].lastname
																							+ "</option>");
																});

											})

						})
	})
</script>


</head>
<body>
	<form action="#">
		Department:<select name="deptId" id="deptSelector">
			<option value="0" selected>请选择</option>
			<c:forEach items="${depts}" var="dept">
				<option value="${dept.deptId}">${dept.name}</option>
			</c:forEach>
		</select> <select name="employeeId" id="employeeSelector"></select>
	</form>
</body>
</html>