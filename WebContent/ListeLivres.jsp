<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>
</head>
<body>
	<div class="jumbotron text-center"
		style="margin-bottom: 0; background-image: url('images/tof12.jpg'); background-repeat: no-repeat;">
	</div>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<form method="post" action="getLivres">
				<ul class="navbar-nav">
					<li class="nav-item"><a href="index.jsp" class="btn btn-dark">Accueil</a></li>
					<li class="nav-item"><input type="submit" class="btn btn-dark"
						value="Liste Des Livres"></li>
				</ul>
			</form>

		</div>
	</nav>

	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-4">
				<h2>Librairie E-Commerce</h2>
				<div class="fakeimg img-thumbnail"
					style="background-image: url('images/tof3.jpg'); background-repeat: no-repeat;"></div>
				<p></p>
				<hr class="d-sm-none">
			</div>
			<div class="col-sm-8">
				<br>
				<table class="table table-dark table-hover">
					<thead>
						<tr>
							<th>Description</th>
							<th>Prix</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="${LisLiv}">
							<tr>
								<td>${i.getDescription() }</td>
								<td>${i.getPrix() }</td>
								<td>
									<form action="Chariot" method="post">
										<input type="hidden" value="${i.getId_Livre() }"
											name="IdLivre"> <input type="submit"
											value="Add To Cart" class="btn btn-success" name="action">
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p></p>
	</div>
</body>
</html>