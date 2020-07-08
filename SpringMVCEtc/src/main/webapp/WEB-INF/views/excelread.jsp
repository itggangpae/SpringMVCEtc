<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>엑셀 파일 읽기</title>
</head>
<body>
	<table align="center" border="1">
		<tr>
			<th>이름</th>
			<th>설명</th>
			<th>가격</th>
		</tr>
		
		<c:forEach var="item" items="${list}">
			<tr>
				<th>${item.itemname}</th>
				<th>${item.description}</th>
				<th>${item.price}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
		