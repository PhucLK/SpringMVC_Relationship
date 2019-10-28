<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create A New Book</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<style>
.required {
	color: red;
}
</style>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12" style="text-align: center">
				<h3>Add Book</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<mvc:form action="${pageContext.request.contextPath}/${action}"
					method="post" modelAttribute="book">
					<c:if test="${action == 'edit-book'}">
						<input hidden name="id" value="${book.id}" />
						<input hidden name="bookDetail.id" value="${book.bookDetail.id}" />
					</c:if>

					<div class="form-group">
						<label for="nameId" class="control-label col-sm-2"> Name <span
							class="required">(*)</span>
						</label>
						<div class="col-sm-10">
							<input id="nameId" name="name" class="form-control" type="text"
								required value="${book.name}" />
							<mvc:errors path="name" cssClass="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="authorId" class="control-label col-sm-2">
							Author <span class="required">(*)</span>
						</label>
						<div class="col-sm-10">
							<input id="authorId" name="author" class="form-control"
								type="text" required value="${book.author}" />
							<mvc:errors path="author" cssClass="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="isbnId" class="control-label col-sm-2"> ISBN <span
							class="required">(*)</span>
						</label>
						<div class="col-sm-10">
							<input id="isbnId" name="bookDetail.isbn" class="form-control"
								type="text" required value="${book.bookDetail.isbn}" />
							<mvc:errors path="bookDetail.isbn" cssClass="required" />
						</div>
					</div>

					<div class="form-group">
						<label for="numberOfPageId" class="control-label col-sm-2">
							Number Of Page </label>
						<div class="col-sm-10">
							<input id="numberOfPageId" name="bookDetail.numberOfPage"
								class="form-control" type="text"
								value="${book.bookDetail.numberOfPage}" />
						</div>
					</div>

					<div class="form-group">
						<label for="priceId" class="control-label col-sm-2"> Price
						</label>
						<div class="col-sm-10">
							<input id="priceId" name="bookDetail.price" class="form-control"
								type="number" value="${book.bookDetail.price}" />
						</div>
					</div>

					<div class="form-group">
						<label for="publishDateId" class="control-label col-sm-2">
							Publish Date </label>
						<div class="col-sm-10">
							<input id="publishDateId" name="bookDetail.publishDate"
								class="form-control" type="date"
								value="${book.bookDetail.publishDate}" placeholder="DD/MM/YYYY"/>
						</div>
					</div>

					<div class="form-group">
						<label for="descriptionId" class="control-label col-sm-2">
							Description </label>
						<div class="col-sm-10">
							<textarea id="descriptionId" name="bookDetail.description"
								class="form-control">${book.bookDetail.description}</textarea>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2"> Category </label>
						<div class="col-sm-10">
							<select name="category.id" class="form-control">
								<c:forEach items="${categories}" var="c">
									<c:if test="${c.id == book.category.id}">
										<option value="${c.id}" selected>${c.name}</option>
									</c:if>
									<c:if test="${c.id != book.category.id}">
										<option value="${c.id}">${c.name}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<button class="btn btn-default" type="submit">Submit</button>
					</div>

				</mvc:form>
			</div>
		</div>
	</div>
</body>
</html>