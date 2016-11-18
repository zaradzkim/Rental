<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>

<c:url value ="/lenders/delete" var = "deleteUserURL"/>
<c:url value ="/lenders/edit" var = "editUserURL" />

<div class="container">

    <h1>List of lenders</h1>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th class="text-center col-md-1">Id</th>
                    <th class="text-center">First Name</th>
                    <th class="text-center">Last Name</th>
                    <th class="text-center col-md-1">Email</th>
                    <th class="text-center col-md-1">Edit</th>
                    <th class="text-center col-md-1">Delete</th>
                </tr>
                </thead>
                <tbody>

                    <c:forEach items="${usersList}" var="user"> <!-- for each to add as many users as there are in the database  -->
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td> <a href="${editUserURL}/${user.id}" class="btn btn-primary">Edit</a></td>
                        <td> <a href="${deleteUserURL}/${user.id}" class="btn btn-danger">Delete</a></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>


<script>

    $(document).ready( function() {
        console.log("Strona zaladowana");

        $('.delete-btn').on('click', function(event) {
            event.preventDefault();
            console.log("Przycisk klienty, a jego href to: " + event.target.href); <!-- JQuery and JavaScript for metod POST to delete lender from list -->

            // $.
            // jQuery.

            setTimeout(function() {
                $.post(event.target.href)
                    .done(function() {
                        location.reload();
                    });
            }, 1000);
        });
    });
</script>
