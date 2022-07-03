<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="/Prova/assets/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="/Prova/assets/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 60%; margin: 50px auto;">
		<div class="text-center">
			<h1>ADICIONAR VENDEDOR</h1>
		</div>
		<form action="adicionarVendedor" method="POST">
			<div class="form-group">
				<label>Nome:</label>
				<input name="name" class="form-control">
			</div>
			<div class="form-group">
				<label>Cidade:</label>
				<input name="city" class="form-control">
			</div>
			<div class="form-group">
				<label>Comissão:</label>
				<input name="commission" class="form-control">
			</div>
			
			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>
		<form action="/TPFINAL">
			<button class="btn btn-secondary mt-3" >Voltar</button>
		</form>
	</div>
</body>
</html>