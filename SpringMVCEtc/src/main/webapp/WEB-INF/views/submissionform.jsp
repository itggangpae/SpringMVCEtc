<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리포트 제출</title>
</head>
<body>
	<h3>MultipartHttpServletRequest 사용</h3>
	<form action="fileupload2.action" method="post"
		enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br /> 리포트파일: <input
			type="file" name="report" /> <br /> <input type="submit" />
	</form>

	<h3>@RequestParam 사용</h3>
	<form action="fileupload1.action" method="post"
		enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br /> 리포트파일: <input
			type="file" name="report" /> <br /> <input type="submit" />
	</form>

	<h3>커맨드 객체 사용</h3>
	<form action="fileupload3.action" method="post"
		enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br /> 리포트파일: <input
			type="file" name="report" /> <br /> <input type="submit" />
	</form>

</body>
</html>
