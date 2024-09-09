<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="home.jsp" />
<div class=container>
<div class=row>
<div class="col-md-11 offset-md-1">
<div class=card>
<div class="card-header text-center">
         Employee Details
</div>
<c:if test="${not empty msg }">
<h5>${msg }</h5>
<c:remove var="msg"/>
</c:if>
<div class=card-body>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Fullname</th>
      <th scope="col">Email</th>
      <th scope="col">Address</th>
      <th scope="col">Password</th>
      <th scope="col">Designation</th>
      <th scope="col">Salary</th>
      <th scope="col">Action</th>
      
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${emplist}" var="e">
    <tr>
      <th scope="row">${e.id }</th>
      <td>${e.fullname }</td>
      <td>${e.address }</td>
      <td>${e.password }</td>
      <td>${e.email }</td>
      <td>${e.designation }</td>
      <td>${e.salary }</td>
      <td>
        <a href="edit/${e.id }" class="btn btn-sm btn-primary">Edit</a>
        <a href="delete/${e.id }" class="btn btn-sm btn-danger">Delete</a>
        
      </td>
    </tr>
   </c:forEach>
  </tbody>
</table>


</div></div></div></div></div>
</body>
</html>