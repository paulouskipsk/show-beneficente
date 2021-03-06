<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="pt-br">
<header>
	<meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<style rel="stylesheet">
.center {
	text-align: center;
}
</style>
	<title>Show Beneficente</title>
</header>
<body>
	<div class="container">
		<div class="center">
			<h1 class="title-page">Ingressos Por Usuário</h1>
		</div>
		
		<a href="home"><button type="button" class="btn btn-primary">Ir para Home</button></a>

		<table class="table table-striped">
			<thead class="bg-info">
				<!-- class="thead-dark"-->
				<tr>
					<th scope="col">COD.</th>
					<th scope="col">NOME</th>
					<th scope="col">IDADE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ users }" var="user">
					<tr>
						<td>${ user.id }</td>
						<td>${ user.name }</td>
						<td>${ user.age }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>