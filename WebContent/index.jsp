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
		
		<c:if test="${President.allPresidents[PresNum].yearsInOffice != -1}">
		<li>Years In Office: ${President.allPresidents[PresNum].yearsInOffice}</li>
		</c:if>
		
		<c:if test="${AllPresident[PresNum].inaugYear != \"-1\"}">
		<li>Inauguration Year: ${President.allPresidents[PresNum].inaugYear}</li>
		</c:if>
		
		<c:if test="${AllPresident[PresNum].endYear != -1}">
		<li>End Year: ${President.allPresidents[PresNum].endYear}</li>
		</c:if>
		
		<c:if test="${AllPresident[PresNum].ageAtInaug != -1}">
		<li>Inauguration Age: ${President.allPresidents[PresNum].ageAtInaug}</li>
		</c:if>
		
		<c:if test="${!AllPresident[PresNum].stateElected.equals(\"\")}">
		<li>State Elected: ${President.allPresidents[PresNum].stateElected}</li>
		</c:if>
		
		<c:if test="${AllPresident[PresNum].electoralVotes != -1}">
		<li>ElectoralVotes: ${President.allPresidents[PresNum].electoralVotes}</li>
		</c:if>
		
		<c:if test="${AllPresident[PresNum].popularVotes.equal('-1')}">
		<li>Popular Votes: ${President.allPresidents[PresNum].popularVotes}</li>
		</c:if>
		
		<c:if test="${AllPresident[PresNum].totalPopularVotes != -1}">
		<li>Total Popular Votes: ${President.allPresidents[PresNum].totalPopularVotes}</li>
		</c:if>
		
		<c:if test="${AllPresident[PresNum].totalElectoralVotes != -1}">
		<li>Total Electoral Votes: ${President.allPresidents[PresNum].totalElectoralVotes}</li>
		</c:if>
		
		<c:if test="${AllPresident[PresNum].ratingPoints != -1}">
		<li>Rating Points: ${President.allPresidents[PresNum].ratingPoints}</li>
		</c:if>
		
		<c:if test="${!AllPresident[PresNum].party.equals(\"\")}">
		<li>Party: ${President.allPresidents[PresNum].party}</li>
		</c:if>
		
		<c:if test="${!AllPresident[PresNum].occupation.equals(\"\")}">
		<li>Occupation: ${President.allPresidents[PresNum].occupation}</li>
		</c:if>
		
		<c:if test="${!AllPresident[PresNum].college.equals(\"\")}">
		<li>College: ${President.allPresidents[PresNum].college}</li>
		</c:if>
		
		<c:if test="${AllPresident[PresNum].electoralPercentage.equals(\"\")}">
		<li>Electoral Percentage: ${President.allPresidents[PresNum].electoralPercentage}</li>
		</c:if>
		
		<c:if test="${AllPresident[PresNum].popularPercentage.equals(\"\")}">
		<li>Popular Percentage: ${President.allPresidents[PresNum].popularPercentage}</li>
		</c:if>
	</ul>
	
	</div>



</body>
</html>