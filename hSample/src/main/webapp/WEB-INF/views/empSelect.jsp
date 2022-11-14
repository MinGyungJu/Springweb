<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> 사원 정보 목록 보기</h2>

<table border='2'>

	<c:forEach items='${ result }' var='empVO'>
	<tr>
		<td>${empVO.empno }</td>
		<td>${empVO.ename }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>