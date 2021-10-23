<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Welcome</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="css/custom.css"
		rel="stylesheet">
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Your todos are</caption>
			<thead>
				<tr>
					<th>id</th>
					<th>Name</th>
					<th>Account Number</th>
				</tr>
			</thead>
			<tbody>
                <c:forEach items="${customer}" var="book">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.name}</td>
                        <td>${customer.accountNumber}</td>
                    </tr>
                </c:forEach>
            </tbody>
			<tbody>
					<tr>
						<td>Prem</td>
						<td>10/12/2017</td>
						<td>1000</td>
						<!-- <td><a class="btn btn-warning" href="/edit-todo">Edit Todo</a></td>
						<td><a class="btn btn-warning" href="/delete-todo">Delete Todo</a></td> -->
					</tr>
			</tbody>
		</table>
		<div>
			<a class="btn btn-default" href="/submit">Submit</a>
			
		</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<!-- <script src="js/custom.js"></script> -->
	</div>
</body>
</html>
