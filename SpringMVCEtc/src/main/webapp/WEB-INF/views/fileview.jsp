<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 목록</title>
</head>
<body>
<div align="center" class="body">
		<h2>파일 목록 화면</h2>
		<table border="1">
			<tr>
				<th width="200">파일명</th>
			</tr>

			<c:forEach var="item" items="${list}">
				<tr>
					<td><a href="download?filename=${item}">${item}</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
