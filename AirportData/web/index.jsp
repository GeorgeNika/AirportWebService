<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="txt" dataSource="jdbc/glassfishrandomdata3">
  SELECT * FROM random
</sql:query>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
</head>
<body>
sadfsadf
<table>
  <c:forEach var="row" items="${txt.rows}">
    sss
    <tr><td><c:out value="${row.random2}"/></td></tr>
  </c:forEach>
</table>
</body>
</html>