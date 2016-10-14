<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%response.setStatus(403);%>
<!DOCTYPE html>
<html>
<head>
	<title>403 - 用户权限不足</title>
</head>
<body>
	<h3>403 - 用户权限不足:${exception}</h3>
</body>
</html>