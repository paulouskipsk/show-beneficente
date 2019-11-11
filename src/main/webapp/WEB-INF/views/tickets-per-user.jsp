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
		<div class="center"><h1 class="title-page">Listar Pedidos de Ingresso por Usuário</h1></div>
		<form class="form-group" method="post" action="ingressos-por-usuario">
			<div class="row justify-content-left">
				<div class="col-md-6">
					<div class="form-group">
						<label for="user">Selecione o Usuario:</label> 
						<select class="custom-select" name="usrId">
							<c:forEach var="user" items="${users}">
							   <option value="${ user.id }" ${ user.id == ticketsRequest[0].user.id ? "selected" : ""}>${ user.name}</option>
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
				<tr>
					<th scope="col">COD.</th>
					<th scope="col">Quantidade</th>
					<th scope="col">VLR Doação</th>
					<th scope="col">Show</th>
					<th scope="col">Data do Show</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ ticketsRequest }" var="ticketRequest">
					<tr>
						<td>${ ticketRequest.id }</td>
						<td>${ ticketRequest.quantity }</td>
						<td>R$ <fmt:formatNumber type = "number" value = "${ ticketRequest.donationAmount }" /></td>
						<td>${ ticketRequest.show.band }</td>
						<td><fmt:formatDate value="${ ticketRequest.show.date }" pattern="dd-MM-yyyy"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>