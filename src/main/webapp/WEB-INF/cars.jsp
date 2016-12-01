<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>

<c:url value="/car/delete" var="deleteCarURL"/>
<c:url value="/car/edit" var="editCarURL"/>
<c:url value="rent/car" var="rentURL"/>

<c:if test="${cantRent}">
    <div class="alert alert-danger">
        You cant rent this car!
    </div>
</c:if>

<div class="container">

    <h1>List of cars</h1>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th class="text-center col-md-1">Id</th>
                    <th class="text-center">Mark</th>
                    <th class="text-center">Model</th>
                    <th class="text-center">Availability</th>
                    <th class="text-center col-md-1">Delete</th>
                    <th class="text-center col-md-1">Edit</th>
                    <th class="text-center col-md-1">Rent</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${carsList}" var ="car">
                    <tr>
                        <td>${car.id}</td>
                        <td>${car.mark}</td>
                        <td>${car.model}</td>
                        <td>${car.avaible}</td>
                        <td class ="text-center"> <a href="${deleteCarURL}/${car.id}" class="btn btn-danger delete-btn">Delete</a></td>
                        <td class ="text-center"> <a href="${editCarURL}/${car.id}" class="btn btn-primary">Edit</a></td>

                        <td class ="text-center">

                        <c:choose>
                            <c:when test="${book.available > 0}">
                                <a href="${rentURL}/${car.id}" class="btn btn-info btn-sm">Rent</a> <!-- hides btn rent when available is null -->
                            </c:when>
                            <c:otherwise>
                            empty
                            </c:otherwise>
                        </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

<script>

    $(function() {
        $('.delete-button').on('click', function(event) {
            console.log(event);
            event.preventDefault();
            var url = event.target.href;
            $.post(url)
            .done(function() {
                location.reload();
            });
        });
    });




</script>