<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.*"%>
<%@page import="com.entity.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Old Book</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>

<%@include file="all_component/navbar.jsp"%>

	<c:if test="${not empty succMsg }">
		<div class="alert alert-success">${succMsg }</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<div class="container p-5" >
<table class="table table-striped">
  <thead class="bg-primary text-white">
    <tr>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
      <th scope="col">Category</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  <%
  User u = (User) session.getAttribute("userobj");
  String email = u.getEmail();
  BookDAOImpl dao = new BookDAOImpl(DBconnect.getConn());
 List<BookDtls> list=  dao.getBookByOld(email, "Old");
 
 for(BookDtls b: list) { %>
	
	<tr>
      <td><%=b.getBookName() %></td>
      <td><%=b.getAuthor() %></td>
      <td><%=b.getPrice() %></td>
      <td><%=b.getBookCategory() %></td>
      <td><a href="delete_old_book?em=<%=email %>&&id=<%=b.getBookId() %>" class="btn btn-sm btn-danger">Delete</a></td>
    </tr>
	
	
  <%	 
  }
  %>

    
  </tbody>
</table>
</div>

</body>
</html>