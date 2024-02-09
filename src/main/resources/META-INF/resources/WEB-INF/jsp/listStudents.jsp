    <%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %> 
        <div class="container">
            <h1>Students Details</h1>

            <table class="table">
                <thead>
                    <tr>
                        <th>Roll No</th>
                        <th>Name</th> 
                        <th>DSA</th>
                        <th>DBMS</th>
                        <th>DMS</th>
                        <th>Percentage</th>
                        <th>Result</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${students}" var="student">
                        <tr> 
                            <td>${student.rollno}</td>
                            <td>${student.name}</td>
                            <td>${student.marks1}</td>
                            <td>${student.marks2}</td>
                            <td>${student.marks3}</td>
                            <td>${student.percentage}</td>
                            <td>${student.result}</td>
                            <td><a href="delete-student?id=${student.id}" class="btn btn-warning">Delete</a></td>
                            <td><a href="update-student?id=${student.id}" class="btn btn-success">Update</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-student" class="btn btn-success">Add Student</a>
        </div>
         <%@ include file="common/footer.jspf" %>