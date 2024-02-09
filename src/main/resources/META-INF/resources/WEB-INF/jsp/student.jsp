<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h1 class="mb-4">Enter Student Details</h1>
            <form:form method="post" modelAttribute="student">
                <fieldset class="mb-4">
                    <div class="form-group">
                        <form:label path="name">Student Name</form:label>
                        <form:input type="text" path="name" class="form-control" required="required" />
                        <form:errors path="name" cssClass="text-warning" />
                    </div>
                </fieldset>
                
                <fieldset class="mb-4">
                    <div class="form-group">
                        <form:label path="rollno">Roll No</form:label>
                        <form:input type="number" path="rollno" class="form-control" required="required" />
                        <form:errors path="rollno" cssClass="text-warning" />
                    </div>
                </fieldset>

                <fieldset class="mb-4">
                    <div class="form-group">
                        <form:label path="marks1">DSA</form:label>
                        <form:input type="number" path="marks1" class="form-control" required="required" />
                        <form:errors path="marks1" cssClass="text-warning" />
                    </div>
                </fieldset>
                <fieldset class="mb-4">
                    <div class="form-group">
                        <form:label path="marks2">DBMS</form:label>
                        <form:input type="number" path="marks2" class="form-control" required="required" />
                        <form:errors path="marks2" cssClass="text-warning" />
                    </div>
                </fieldset>
                <fieldset class="mb-4">
                    <div class="form-group">
                        <form:label path="marks3">DMS</form:label>
                        <form:input type="number" path="marks3" class="form-control" required="required" />
                        <form:errors path="marks3" cssClass="text-warning" />
                    </div>
                </fieldset>
                 
                <form:input type="hidden" path="id" />

                <button type="submit" class="btn btn-success">Submit</button>
            </form:form>
        </div>
    </div>
</div>

<%@ include file="common/footer.jspf" %>
