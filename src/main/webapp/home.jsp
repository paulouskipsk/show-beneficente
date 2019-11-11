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
	button{
		width: 500px;
		margin: 10px;
	}
</style>
	<title>Show Beneficente</title>
</header>
<body>
	<div class="container">
		<div class="center">
			<h1 class="title-page">Show Beneficente UTFPR</h1>
		</div>
		
		<div class="center">
			<a href="alimentar-banco"><button type="button" class="btn btn-danger">Inicializar Banco de dados</button></a><br/>
			<a href="usuarios"><button type="button" class="btn btn-primary">Pesquisar Usuarios Cadastrados</button></a><br/>		
			<a href="ingressos-por-usuario"><button type="button" class="btn btn-info">Pesquisar Ingresso por Usuario</button></a><br/>
			<a href="usuarios-por-show"><button type="button" class="btn btn-dark">Pesquisar Usuários por Show</button></a><br/>
			<a href="ingressos-por-show"><button type="button" class="btn btn-secondary">Ingressos Vendidos por Show</button></a><br/>
			<a href="maior-doacao"><button type="button" class="btn btn-warning">Pesquisar Usuário com maior Doação</button></a><br/>
		</div>
</body>
</html>