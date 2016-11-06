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
	<h1>Presidents</h1>
	<div id="presName">
	<p>${President.allPresidents[PresNum].firstName } ${President.allPresidents[PresNum].lastName}</p>
	</div>
	
	<form action="index.do" method="GET">
	Term Number: <input type="text" name="presNum" value="${TermNum}"><br />
	<input type="submit" name="submit" value="userInput">
	<button name="submit" value="prev">Prev</button>
	<button name="submit" value="next">Next</button>
	</form>
	
	<div id="photo"></div>
	
	<div id="info">
	
	<ul>
		<c:if test="${!President.allPresidents[PresNum].middleName.equals(\"\")}">
		<li>Middle Name: ${President.allPresidents[PresNum].middleName }</li>
		</c:if>
		<c:if test="${President.allPresidents[PresNum].yearsInOffice != null}">
		<li>Years In Office: ${President.allPresidents[PresNum].yearsInOffice}</li>
		</c:if>
		
		<li>Inauguration Year: ${President.allPresidents[PresNum].inaugYear}</li>
		<li>End Year: ${President.allPresidents[PresNum].endYear}</li>
		<li>Inauguration Age: ${President.allPresidents[PresNum].ageAtInaug}</li>
		<li>State Elected: ${President.allPresidents[PresNum].stateElected}</li>
		<li>ElectoralVotes: ${President.allPresidents[PresNum].electoralVotes}</li>
		<li>Popular Votes: ${President.allPresidents[PresNum].popularVotes}</li>
		<li>Total Popular Votes: ${President.allPresidents[PresNum].totalPopularVotes}</li>
		<li>Total Electoral Votes: ${President.allPresidents[PresNum].totalElectoralVotes}</li>
		<li>Rating Points: ${President.allPresidents[PresNum].ratingPoints}</li>
		<li>Party: ${President.allPresidents[PresNum].party}</li>
		<li>Occupation: ${President.allPresidents[PresNum].occupation}</li>
		<li>College: ${President.allPresidents[PresNum].college}</li>
		<li>Electoral Percentage: ${President.allPresidents[PresNum].electoralPercentage}</li>
		<li>Popular Percentage: ${President.allPresidents[PresNum].popularPercentage}</li>
	</ul>
	
	</div>



</body>
</html>