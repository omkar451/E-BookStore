<%@page import="com.DB.*" %>
<%@page import="com.DAO.*" %>
<%@page import="com.entity.*" %>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>	

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>
	
	<!-- security purpose without login not access  -->
	<c:if test="${empty userobj }">
	<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	
	<!-- remove book karne e=keliye -->
	<c:if test="${not empty succMsg }">
	<div class="alert alert-success" role="alert"> ${succMsg }
	</div>
	<c:remove var="succMsg" scope="session" />
	</c:if>
	
	<c:if test="${not empty failedMsg }">
	<div class="alert alert-danger text-center" role="alert">${failedMsg }
	</div>
	<c:remove var="failedMsg" scope="session" />
	</c:if>
	<!-- end of remove bok -->

	<div class="container">
		<div class="row p-2">
			<div class="col-md-6">

				<div class="card bg-white">
					<div class="card-body">
						<h3 class="text-center text-success">Your Selected Item</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">BookName</th>
									<th scope="col">Author</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
							
							<%
							User u =(User)session.getAttribute("userobj");
							CartDAOImpl dao = new CartDAOImpl(DBconnect.getConn());
							List<Cart> cart = dao.getBookByUser(u.getId());
							Double totalPrice=0.00;
							for(Cart c : cart) { 
								totalPrice = c.getTotalPrice();
							%>
								<tr>
									<th scope="row"><%=c.getBookName() %></th>
									<td><%=c.getAuthor() %></td>
									<td><%=c.getPrice() %></td>
									<td>
									<a href="remove_book?bid=<%=c.getBid()%>&&uid=<%=c.getUserid()%>&&cid=<%=c.getCid() %>" class="btn btn-sm btn-danger">Remove</a>
									</td>
								</tr>	
							<%
							}
							%>
							<tr>
							<td>Total Price</td>
							<td></td>
							<td></td>
							<td><%=totalPrice %></td>
							</tr>
								
							</tbody>
						</table>

					</div>
				</div>

			</div>


			<div class="col-md-6">

				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Details for Order</h3>
						<form action="order" method="post">
						<input type="hidden" value="${userobj.id }" name="id">
						
						
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text" name ="username"
										class="form-control" id="inputEmail4" value="${userobj.name }" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input type="email" name="email"
										class="form-control" id="inputPassword4" value="${userobj.email }" required>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Phone Number</label> <input name="phno"
										type="number" class="form-control" id="inputEmail4" value="${userobj.phno }" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Address</label> <input type="text" name="address"
										class="form-control" id="inputPassword4" required>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Landmark</label> <input type="text" name="landmark"
										class="form-control" id="inputEmail4">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">City</label> <input type="text" name="city"
										class="form-control" id="inputPassword4">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">State</label> <input type="text" name="state"
										class="form-control" id="inputEmail4">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Pin code</label> <input type="text" name="pincode"
										class="form-control" id="inputPassword4" required>
								</div>
							</div>

							<div class="form-group">
								<label>Payment Mode</label> <select class="form control" name="payment">
									<option value="noselect">---Select---</option>
									<option value="COD">Cash On Delivery</option>
								</select>
							</div>
							
							
							<div class="text-center">
							<button class="btn btn-warning">Order Now</button>
							<a href="index.jsp" class="btn btn-success">Continue Shopping</a>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>

	</div>
</body>
</html>