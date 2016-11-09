<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="POST" modelAttribute="attributes">
	 	
	 	<c:forEach var="i" begin="0" end="${attributes.size}" >
	 		
	 		<c:if test="${attributes.attributes[i].question.kind == 'string' }">
		
			${attributes.attributes[i].question.question}
		
			<form:input path="attributes.attributes[i].answer.answer[0]" />
		
		</c:if>
		
		<c:if test="${attributes.attributes[i].question.kind == 'one' }">
			
			${attributes.attributes[i].question.question}
			
			<br>
		
			<c:forEach var="j" begin="0" end="${attributes.attributes[i].size}">
				
				${attributes.attributes[i].answers[j].answer}
				
				<form:radiobutton name="radio" path="attributes[${i}].answers[0].answer" value="attributes.attributes[i].answers[j].answer"/>
				
				<br>
			
			</c:forEach>
	
		</c:if>
		
		<c:if test="${attributes.attributes[i].question.kind == 'many' }">
		
			${attributes.attributes[i].question.question}
			
			<br>
			
			<c:forEach var="k" begin="0" end="${attributes.attributes[i].size}">
				
				${attributes.attributes[i].answers[k].answer}
				
				<form:checkbox path="attributes[${i}].answers[${k}].answer" value="attributes.attributes[i].answer[k].answer"/>
			
			</c:forEach>
		
		</c:if>		
	 	
	 	</c:forEach>		
				
		<input type="submit" />
	
	</form:form>

</body>
</html>