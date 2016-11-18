<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>




<div class="container">

    <h1>Create car</h1>

    <div class="row">
        <form role="form" class="form-horizontal">
            <input type="hidden" name="id" value=""/>
            <div class="form-group">
                <label class="control-label col-sm-2" for="mark">Mark:</label>
                <div class="col-sm-6">
                    <input type="text" id="mark" class="form-control" placeholder="Enter mark" autofocus>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="model">Model:</label>
                <div class="col-sm-6">
                    <input type="text" id="model" class="form-control" placeholder="Enter model">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="available">Availabilty:</label>
                <div class="col-sm-6">
                    <input type="number" id="available" class="form-control" placeholder="Enter available">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <a href="" class="btn btn-danger">Cancel</a>
                </div>
            </div>
        </form>
    </div>

</div>