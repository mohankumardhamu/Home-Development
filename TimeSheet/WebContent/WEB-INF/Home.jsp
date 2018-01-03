<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h2>Home Page</h2>
	<form:form id="userform" modelAttribute="User" action="timeSheet"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="date">Date: </form:label></td>
				<td><form:input path="date" id="date" type="date"/></td>
			</tr>
			<tr>
				<td><form:label path="starttime">Start Time:</form:label></td>
				<td><form:input type="time" path="starttime" id="startTime" /></td>
			</tr>
			<tr>
				<td><form:label path="endtime">End Time:</form:label></td>
				<td><form:input type="time" path="endtime" id="endTime" /></td>
			</tr>
			<tr>
				<td><form:label path="projectname">Project Name:</form:label></td>
				<td><form:input type="text" path="projectname" id="projectName" /></td>
			</tr>
			<tr>
				<td><form:label path="taskname">Task Name:</form:label></td>
				<td><form:input type="text" path="taskname" id="taskName" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button id="submit" name="submit">Submit</form:button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>