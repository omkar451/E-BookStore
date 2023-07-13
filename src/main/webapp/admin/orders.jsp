<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.*"%>
<%@page import="com.entity.*"%>
<%@page import="com.DB.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: All Order</title>
<%@include file="allCss.jsp"%>
</head>
<body>

<!-- security purpose without login not access  -->
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<%@include file="navbar.jsp"%>

	<h3 class="text-center">Hello Admin</h3>

	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Order Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Ph No</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Payment type</th>
			</tr>
		</thead>
		<tbody>

			<%
              User u =(User)session.getAttribute("userobj");
              BookOrderImpl dao = new BookOrderImpl(DBconnect.getConn());
              List<Book_Order> blist = dao.getAllOrder();
              for(Book_Order b: blist) { %>

			<tr>
				<th scope="row"><%=b.getOrderId() %></th>
				<td><%=b.getUserName() %></td>
				<td><%=b.getEmail() %></td>
				<td><%=b.getFulladd() %></td>
				<td><%=b.getPhno() %></td>
				<td><%=b.getBookName() %></td>
				<td><%=b.getAuthor() %></td>
				<td><%=b.getPrice() %></td>
				<td><%=b.getPaymentType() %></td>
				
			</tr>
			
			<%} %>
		</tbody>
	</table>
	
	<div style="margin-top: 315px;"><%@include file="footer.jsp" %></div>

</body>
</html>