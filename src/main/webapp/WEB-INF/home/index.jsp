<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />

</head>
<body>

	<form id="formGet" method="get">
		<label>Métodos Get</label> <input type="text" name="" id="urlGet" />
		<button type="button" class="btn-get">
	</form>

	<form id="formPost" action="${path }/luizalabsWS/app/funcionario/adicionarFuncionario/" method="post">
	<label>Método Adição</label>
		<input type="text" name="funcionario" id="urlPost" placeholder='{ "dataCad": "19/04/2017", "cargo": "AC Sr", "cpf": "59984408701", "nome": "Aaron Aaby", "ufNasc": "RO", "salario": "5312.70", "status": "ATIVO" }' />
		<button type="button" class="btn-post">Método Inserir</button>
	</form>

	<form id="formDelete" action="${path }/luizalabsWS/app/funcionario//deleteFuncionarioCPF/{cpf}" method="delete">
		<input type="text" name="cpf" placeholder="32055774856" id="urlDelete" />
		<button type="button" class="btn-Delete">Delete</button>
	</form>

	<script type="text/javascript" src="${path}/static/js/home.js"></script>
</body>
</html>