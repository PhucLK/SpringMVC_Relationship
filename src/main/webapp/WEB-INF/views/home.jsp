<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Product</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h2 style="margin-top: 5%; margin-bottom: 5%; text-align: center;">List
					Product</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<button class="btn btn-primary"
					onclick="location.href='<c:url value="/add-book"/>'">Add
					Book</button>
				<div class="table-responsive">
					<table class="table table-bordered table-hover">

						<thead class="thead-light">
							<tr>
								<th>Name</th>
								<th>Author</th>
								<th>Category</th>
								<th>Price</th>
								<th>Publish</th>
								<th>ISBN</th>
								<th>Description</th>
								<th>Number of Page</th>
							</tr>
						</thead>

						<tr>
							<c:forEach var="b" items="${books}">
								<td>${b.name}</td>
								<td>${b.author}</td>
								<td>${b.category.name}</td>
								<td><fmt:formatNumber type="number" pattern="###,###"
										value="${b.bookDetail.price}" />VND</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${b.bookDetail.publish}" /></td>
								<td>${b.bookDetail.isbn}</td>
								<td>${b.bookDetail.description}</td>
								<td>${b.bookDetail.numberOfPage}</td>
								<td>
									<button class="btn btn-primary"
										onclick="location.href = '<c:url value="/edit-book/${b.id}"/>'">
										Edit</button>
									<button class="btn btn-danger"
										onclick="location.href = '<c:url value="/delete-book/${b.id}"/>'">
										Delete</button>
								</td>
							</c:forEach>
						</tr>

					</table>

				</div>
			</div>
		</div>
	</div>
</body>
</html>