<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			.center{
				text-align: center;
			}
		
		</style>
	<title>Show Beneficente</title>
</header>
<body>
	<div class="container">
		<div class="center"><h1 class="title-page">Listar Usuários por Show</h1></div>
		<form class="form-group" method="post" action="usuarios-por-show">
			<div class="row justify-content-left">
				<div class="col-md-6">
					<div class="form-group">
						<label for="user">Selecione o Show:</label> 
						<select class="custom-select" name="shwId">
							<c:forEach var="show" items="${shows}">
							   <option value="${ show.id }" ${ show.id == show.id ? "selected" : ""}>${show.id} - ${show.band }</option>
						    </c:forEach>
					    </select>
					</div>
				</div>
			</div>
			<div class="col-md-1">
				<button type="submit" class="btn btn-primary">Pesquisar</button>
			</div>
		</form>
		
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