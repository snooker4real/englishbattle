<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cindanojonathan
  Date: 04/08/2021
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
    <title>English Battle - Inscription</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <h1>Inscription English Battle</h1>
    <form action="inscription" method="post">

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">#</span>
            </div>
            <input type="text" name="LASTNAME" class="form-control" placeholder="Nom" aria-label="Username" aria-describedby="basic-addon1" pattern="[A-ZA-z]*" required="">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon2">#</span>
            </div>
            <input type="text" name="FIRSTNAME" class="form-control" placeholder="Prénom" aria-label="Username" aria-describedby="basic-addon1" pattern="[A-ZA-z]*" required="">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon3">@</span>
            </div>
            <input type="email" name="EMAIL" class="form-control" placeholder="Email" aria-label="Username" aria-describedby="basic-addon1" required="">
        </div>


        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon4">***</span>
            </div>
            <input type="password" name="PASSWORD" class="form-control" placeholder="Mot de passe" aria-label="Username" aria-describedby="basic-addon1" required="">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Niveau</label>
            </div>
            <select name="LEVEL" required class="custom-select" id="inputGroupSelect01">
                <option selected>Choisi un niveau...</option>
                <c:forEach var="niveau" items="${niveaux}">
                    <option value="${niveau.id}">${niveau.nom}</option>
                </c:forEach>
            </select>
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Ville</label>
            </div>
            <select name="CITY" required class="custom-select" id="inputGroupSelect02">
                <option selected>Choisi une ville...</option>
                <c:forEach var="ville" items="${villes}">
                    <option value="${ville.id}">${ville.nom}</option>
                </c:forEach>
            </select>
        </div>

        <input type="submit" class="btn btn-primary" value="Inscription">
    </form>
</body>
</html>