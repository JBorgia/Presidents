<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<%-- 
<p>${President.allPresidents[1]}</p> --%>
<p>${AllPresident[1]}</p>

</body>
</html>