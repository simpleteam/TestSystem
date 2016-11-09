<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/styles/style.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	<div id="header"></div>

	<div id="left"></div>

	<div id="right"></div>

	<div id="center">
	
		<div id="reg">
		
			<form:form method="POST" modelAttribute="answers">
		 	
			 	<c:forEach var="i" begin="0" end="${answers.size() - 1}" >
			 		
			 		<c:if test="${answers.attribs[i].question.kind == 'string' }">
				
						${answers.attribs[i].question.question}
						<br>
						<br>
				
						<form:input path="attribs[${i}].answers[${0}].answer" />
						<form:hidden path="attribs[${i}].question.id"  value="${answers.attribs[i].question.id}" />
						<form:hidden path="attribs[${i}].question.question"  value="${answers.attribs[i].question.question}" />
						<form:hidden path="attribs[${i}].question.kind"  value="${answers.attribs[i].question.kind}" />
						
						<br>
						<br>
						<br>
								
					</c:if>
				
			  		<c:if test="${answers.attribs[i].question.kind == 'one' }"> 
					
						${answers.attribs[i].question.question}
					
						<br>
						<br>
				
						<c:forEach items="${answers.attribs[i].question.answers}" var="a">
						
							<form:radiobutton  path="attribs[${i}].answers[${0}].answer" value="${a.answer}"/>
							<form:hidden path="attribs[${i}].question.id"  value="${answers.attribs[i].question.id}" />
							<form:hidden path="attribs[${i}].question.question"  value="${answers.attribs[i].question.question}" />
							<form:hidden path="attribs[${i}].question.kind"  value="${answers.attribs[i].question.kind}" />
							
							${a.answer}
						
							<br>
							
						</c:forEach>
					
					<br>
					<br>
					<br>
			
		  			</c:if>  
				
					<c:if test="${answers.attribs[i].question.kind == 'many' }">
				
						${answers.attribs[i].question.question}
					
						<br>
						<br>
					
						<c:set var="index" value="${0}" />
					
						<c:forEach items="${answers.attribs[i].question.answers}" var="b" >
						
							<form:checkbox path="attribs[${i}].answers[${index}].answer" value="${b.answer}"/>
							<form:hidden path="attribs[${i}].question.id"  value="${answers.attribs[i].question.id}" />
							<form:hidden path="attribs[${i}].question.question"  value="${answers.attribs[i].question.question}" />
							<form:hidden path="attribs[${i}].question.kind"  value="${answers.attribs[i].question.kind}" />
							
							${b.answer}
							
							<br>
						
							<c:set var="index" value="${index + 1}" />
					
						</c:forEach>
						
						<br>
						<br>
						<br>
				
					</c:if>		
				
		 	 	</c:forEach>		
						
				<input type="submit" />
		
			</form:form>
	
		</div>
		
	</div>

</body>
</html>