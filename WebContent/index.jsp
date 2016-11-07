<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="styles.css">
	<link href="https://fonts.googleapis.com/css?family=Merriweather" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Presidents</title>
</head>
<body>

	<div id="container">
		<h1>Presidents</h1>
		
		<div id="presName">
			<p>Featured President: ${President.allPresidents[PresNum].firstName } ${President.allPresidents[PresNum].lastName}</p>
		</div>
		
		<form action="index.do" method="GET">
			Term Number: <input type="text" name="presNum" value="${TermNum}"><br />
			<button class="button" name="submit" value="userInput">Submit</button>
			<div id="photo">
				<img src="${President.allPresidents[PresNum].presidentPic}" />
			</div>
			<button class="button" name="submit" value="prev">Prev</button>
			<button class="button" name="submit" value="next">Next</button>
		</form>
			<div id="photoInfoContainer">
	
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
						<li>Electoral Votes: <fmt:formatNumber value="${President.allPresidents[PresNum].electoralVotes}" type="number" maxFractionDigits="0"/></li>
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
		</div>
		<div id="footer">
			<div id="filter"><form action="index.do" method="GET">
			Years in Office From: <input type="text" name="yearsInOfficeMin"><br />
			Years in Office To:<input type="text" name="yearsInOfficeMax"><br />
			Presidents from Year:<input type="text" name="rangeYearMin"><br />
			Presidents to Year:<input type="text" name="rangeYearMax"><br />
			President age from:<input type="text" name="ageAtInAugMin"><br />
			President age to:<input type="text" name="ageAtInAugMax"><br />
			State Elected:<select>
							<c:forEach var="states" items="${statesMenu}">
								<option value="${states}">${states}</option>
							</c:forEach>
						  </select><br />
			Electoral Votes from:<input type="text" name="totalElectoralVotesMin"><br />
			Electoral Votes to:<input type="text" name="totalElectoralVotesMax"><br />
			Rating Points from:<input type="text" name="ratingPointsMin"><br />
			Rating Points to:<input type="text" name="ratingPointsMax"><br />
			Federalist <input type="radio"  name="party" value="federalist">
			Democratic-Republican<input type="radio"  name="party" value="democratic-Republican">
			Republican <input type="radio"  name="party" value="republican">
			Democrat: <input type="radio"  name="party" value="democrat">
			Whig: <input type="radio"  name="party" value="whig">
			Unaffiliated: <input type="radio"  name="party" value="none"><br />
			
			
			<button class="button" name="submit" value="userInput">Submit</button>
			<button class="button" name="submit" value="reset">Reset</button>
			
			</form>
		</div>
		<p>Created November 2016. Jonathan Borgia, Jonathan Edwards, Yvette Menase. SD7.</p>
		</div><!-- #footer -->
	</div>

</body>
</html>