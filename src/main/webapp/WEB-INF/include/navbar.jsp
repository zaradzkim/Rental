<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url value="/lenders" var="lendersURL"/>
<c:url value="/lenders-create" var="createLenderURL"/>
<c:url value="/car-create" var="carCreateURL"/>
<c:url value="/cars" var="carsURL"/>
<c:url value="/rents" var="rentsURL"/>
<c:url value="/logout" var="loginURL"/>
<c:url value="/" var="mainURL"/>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${mainURL}">Rental</a>
    </div>
    <ul class="nav navbar-nav">

      <sec:authorize access="hasRole('ADMIN')"> <!-- show Lenders when user have role admin -->
      <li class="active"><a href="${rentsURL}">MyRents</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Lenders
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${createLenderURL}">Add...</a></li>
          <li><a href="${lendersURL}">Show all</a></li>
          </ul>
      </li>
      </sec:authorize>


      <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cars
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
           <li><a href="${carCreateURL}">Add...</a></li>
      <li><a href="${carsURL}">Show all</a></li>
    </ul>
  </li>
</ul>
     <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
            <sec:authentication property ="principal.username"/> <!-- show email user when log in -->
            <span class="caret"></span></a>
            <ul class="dropdown-menu">
            <li>
            <a href="${loginURL}"><span class="glyphicon glyphicon-log-in"></span>Logout</a>
            </li>
          </ul>
      </li>
    </ul>
  </div>
</nav>
