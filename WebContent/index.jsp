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
	<hPresNum>Presidents</hPresNum>
	<div id="presName">
	<p>${AllPresident[PresNum].firstName } ${AllPresident[PresNum].lastName}</p>
	</div>
	
	<form action="index.do" method="GET">
	Term Number: <input type="text" name="presNum"><br />
	<button name="submit" value="back">Prev</button>
	<button name="submit" value="next">Next</button>
	</form>
	
	<div id="photo"></div>
	
	<div id="info">
	
	<ul>
		<c:if test="${!AllPresident[PresNum].middleName.equals(\"\")}">
		<li>Middle Name: ${AllPresident[PresNum].middleName }</li>
		</c:if>
		<c:if test="${AllPresident[PresNum].yearsInOffice != null}">
		<li>Years In Office: ${AllPresident[PresNum].yearsInOffice}</li>
		</c:if>
		
		<li>Inauguration Year: ${AllPresident[PresNum].inaugYear}</li>
		<li>End Year: ${AllPresident[PresNum].endYear}</li>
		<li>Inauguration Age: ${AllPresident[PresNum].ageAtInaug}</li>
		<li>State Elected: ${AllPresident[PresNum].stateElected}</li>
		<li>ElectoralVotes: ${AllPresident[PresNum].electoralVotes}</li>
		<li>Popular Votes: ${AllPresident[PresNum].popularVotes}</li>
		<li>Total Popular Votes: ${AllPresident[PresNum].totalPopularVotes}</li>
		<li>Total Electoral Votes: ${AllPresident[PresNum].totalElectoralVotes}</li>
		<li>Rating Points: ${AllPresident[PresNum].ratingPoints}</li>
		<li>Party: ${AllPresident[PresNum].party}</li>
		<li>Occupation: ${AllPresident[PresNum].occupation}</li>
		<li>College: ${AllPresident[PresNum].college}</li>
		<li>Electoral Percentage: ${AllPresident[PresNum].electoralPercentage}</li>
		<li>Popular Percentage: ${AllPresident[PresNum].popularPercentage}</li>
	</ul>
	
	</div>


</body>
</html>