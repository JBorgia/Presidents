<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presidents</title>
</head>
<body>
<h1>President Crap</h1>
<form action="index.do" method="GET">
Term Number: <input type="text" name="presNum">
<div>President Information</div>
<button name="submit" value="next">Next</button>
<button name="submit" value="back">Prev</button>
<input type="submit">
</form>

<p>${President.allPresidents[1]}</p>
<select>
	<c:forEach var="entry" items="${applicationScope.President.allPresidents}">
		<%--Key: <c:out value="${entry.key}"/>--%> 		
		<option value="${entry.key}"/>${entry.value.first} </option>
	</c:forEach>
</select>

</body>
</html>