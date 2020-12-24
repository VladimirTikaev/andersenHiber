<!doctype html>
<title>Andersen trainee</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/anders-hiber/home">Andersen</a>
        <form action="mainServlet" method="post">
            <table>
                <tr>
                    <td>
                        <input type="text" class="form-control" name="name" aria-describedby="passwordHelpBlock"
                               placeholder="Name">
                    </td>
                    <td>
                        <input type="text" class="form-control" name="surname" aria-describedby="passwordHelpBlock"
                               placeholder="Last Name">
                    </td>
                    <td>
                        <button type="submit" class="btn btn-secondary">Create</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</nav>
<body>

<table class="table" >
    <thead class="thead-dark">
    <tr>
        <th scope="col">Username</th>
        <th scope="col">Email</th>
        <th scope="col"/>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${usersList}" var="myUser">
        <tr>
            <td style="width: 40%" scope="row">${myUser.name}</td>
            <td style="width: 40%" scope="row">${myUser.surname}</td>
            <td style="width: 20%">
                <form action="mainServlet" method="post">
                    <input type="hidden" name="user_id" value="${myUser.id}">
                    <button style="position: center" type="submit" class="btn btn-secondary">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>