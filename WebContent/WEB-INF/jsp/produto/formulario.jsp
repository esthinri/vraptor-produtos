<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="error" items="${errors}">
    ${error.category} - ${error.message}<br />
	</c:forEach>
	<form action='<c:url value="/produto/adiciona" />' method="post">
		Nome: <input type="text" name="produto.nome" /> Descrição: <input
			type="text" name="produto.descricao" /> Preço: <input type="text"
			name="produto.preco" /> <input type="submit" value="Adicionar" />
	</form>
</body>
</html>