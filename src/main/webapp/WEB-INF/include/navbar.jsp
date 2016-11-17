<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Rental</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Main</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Lenders
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Add...</a></li>
          <li><a href="#">Show all</a></li>
          <li><a href="#"></a></li> 
        </ul>
      </li>
      <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cars
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
           <li><a href="#">Add...</a></li>
      <li><a href="#">Show all</a></li>
    </ul>
  </li>
  <li><a href="#">My Rents</a></li>
</ul>
     <ul class="nav navbar-nav navbar-right">
    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
    </ul>
  </div>
</nav>
