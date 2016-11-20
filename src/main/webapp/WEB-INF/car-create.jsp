<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!-- spring form for tags -->
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>

<c:url value="/car-create" var="carCreateURL"/>
<c:url value="/car-create/cancel" var="carCancelURL"/>


<div class="container">

    <c:if test="${car.id == null}">
        <h1>Create car</h1>
    </c:if>

    <c:if test="${car.id != null}">
        <h1>Edit car</h1>
    </c:if>


    <div class="row">
        <form:form commandName="book" action ="${carCreateURL}" method="post" role="form" class="form-horizontal"><!-- adding form commandName spring documentation-->
            <form:hidden path="id" />
                <div class="form-group">
                <label class="control-label col-sm-2" for="mark">Mark:</label>
                <div class="col-sm-6">
                    <form:input path"mark" type="text" id="mark" class="form-control" placeholder="Enter mark" autofocus>
                    <form:errors path="mark" cssStyle="color: red" /> <!-- validations -->
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="model">Model:</label>
                <div class="col-sm-6">
                    <form:input path"model" type="text" id="model" class="form-control" placeholder="Enter model">
                    <form:errors path="model" cssStyle="color: red" />
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="available">Availabilty:</label>
                <div class="col-sm-6">
                    <form:input path"avaible" type="number" id="available" class="form-control" placeholder="Enter available">
                    <form:errors path="avaible" cssStyle="color: red" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <a href="{$carCancelURL}" class="btn btn-danger">Cancel</a>
                </div>
            </div>
        </form>
    </div>

</div>