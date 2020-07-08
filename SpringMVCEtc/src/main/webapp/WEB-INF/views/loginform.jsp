<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="login.form.title" /></title>
</head>
<body>
	<!-- Spring 4.x 버전에서는 modelAttribute 대신에 commandName -->
	<form:form modelAttribute="command">
		<p>
			<label for="email"><spring:message code="email" /></label>:
			<form:input path="email" />
			<form:errors path="email" />
		</p>
		<p>
			<label for="password"><spring:message code="password" /></label>:
			<form:password path="pw" />
			<form:errors path="pw" />
		</p>
		<p>
			<form:select path="loginType" items="${loginTypes}" />
		</p>
		<p>
			생일:
			<form:input path="birthday" />
			<form:errors path="birthday" />
		</p>

		<input type="submit"
			value="<spring:message code="login.form.login" />">
	</form:form>

	<ul>
		<li><spring:message code="login.form.help" /></li>
	</ul>
</body>
</html>
