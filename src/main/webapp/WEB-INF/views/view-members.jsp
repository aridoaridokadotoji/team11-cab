<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
	<h3>Manage Members</h3>
	<div class="row">
		<table id="myTable" style="width: 100%"
			class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>Contact No</th>
					<th>Date of Birth</th>
					<th>Active</th>
					<th>Admin Rights</th>
					<th></th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>