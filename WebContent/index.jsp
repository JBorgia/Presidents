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
	
	
	<div id="photo">
	<img src="${President.allPresidents[PresNum].presidentPic}" />
	</div>
	<div id="info">
	<ul>
		
		<c:if test="${President.allPresidents[PresNum].yearsInOffice != -1}">
		<li>Years In Office: <fmt:formatNumber value="${President.allPresidents[PresNum].yearsInOffice}" maxFractionDigits="0"/></li>
		</c:if>
		
		<c:if test="${President.allPresidents[PresNum].inaugYear != -1}">
		<li>Inauguration Year: <fmt:formatNumber pattern="####" value="${President.allPresidents[PresNum].inaugYear}" maxFractionDigits="0"/></li>
		</c:if>
		
		<c:if test="${President.allPresidents[PresNum].endYear != -1}">
		<li>End Year: <fmt:formatNumber pattern="####" value="${President.allPresidents[PresNum].endYear}" maxFractionDigits="0"/></li>
		</c:if>
		
		<c:if test="${President.allPresidents[PresNum].ageAtInaug != -1}">
		<li>Inauguration Age: <fmt:formatNumber value="${President.allPresidents[PresNum].ageAtInaug}" type="number" maxFractionDigits="0"/></li>
		</c:if>
		
		<c:if test="${!President.allPresidents[PresNum].stateElected.equals(\"\")}">
		<li>State Elected: ${President.allPresidents[PresNum].stateElected}</li>
		</c:if>
		
		<c:if test="${President.allPresidents[PresNum].electoralVotes != -1}">
		<li>ElectoralVotes: <fmt:formatNumber value="${President.allPresidents[PresNum].electoralVotes}" type="number" maxFractionDigits="0"/></li>
		</c:if>
		
		<c:if test="${President.allPresidents[PresNum].popularVotes != -1}">
		
		<li>Popular Votes: <fmt:formatNumber value="${President.allPresidents[PresNum].popularVotes}" type="number" maxFractionDigits="0"/></li>
		</c:if>
		
		<c:if test="${President.allPresidents[PresNum].totalPopularVotes != -1}">
		<li>Total Popular Votes: <fmt:formatNumber value="${President.allPresidents[PresNum].totalPopularVotes}" type="number" maxFractionDigits="0"/></li>
		</c:if>
		
		<c:if test="${President.allPresidents[PresNum].totalElectoralVotes != -1}">
		
		<li>Total Electoral Votes: <fmt:formatNumber value="${President.allPresidents[PresNum].totalElectoralVotes}" type="number" maxFractionDigits="0"/></li>
		</c:if>
		
		<c:if test="${President.allPresidents[PresNum].ratingPoints != -1}">
		
		<li>Rating Points: <fmt:formatNumber value="${President.allPresidents[PresNum].ratingPoints}" type="number" maxFractionDigits="0"/></li>
		</c:if>
		
		<c:if test="${!President.allPresidents[PresNum].party.equals(\"\")}">
		<li>Party: ${President.allPresidents[PresNum].party}</li>
		</c:if>
		
		<c:if test="${!President.allPresidents[PresNum].occupation.equals(\"\")}">
		<li>Occupation: ${President.allPresidents[PresNum].occupation}</li>
		</c:if>
		
		<c:if test="${!President.allPresidents[PresNum].college.equals(\"\")}">
		<li>College: ${President.allPresidents[PresNum].college}</li>
		</c:if>
		
		<c:if test="${!President.allPresidents[PresNum].electoralPercentage.equals(\"\")}">
		<li>Electoral Percentage: ${President.allPresidents[PresNum].electoralPercentage}%</li>
		</c:if>
		
		<c:if test="${!President.allPresidents[PresNum].popularPercentage.equals(\"\")}">
		<li>Popular Percentage: ${President.allPresidents[PresNum].popularPercentage}%</li>
		</c:if>
	</ul>
	
	</div>



</body>
</html>