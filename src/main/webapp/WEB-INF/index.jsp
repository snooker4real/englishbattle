<%--
  Created by IntelliJ IDEA.
  User: cindanojonathan
  Date: 04/08/2021
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
    <title>English Battle</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <h1>English Battle</h1>

    <form action="connexion" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Adresse Email</label>
            <input type="email" name="EMAIL" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Entrer votre em@il">
            <small id="emailHelp" class="form-text text-muted">Nous ne partagerons jamais vos données à quiconque.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Mot de passe</label>
            <input type="password" name="PASSWORD" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Se souvenir de moi</label>
        </div>
        <button type="submit" class="btn btn-success">Valider</button>
    </form>
    <a href="inscription"><button class="btn btn-primary" type="inscription">Inscription</button></a>


    <h2>Hall of Fame</h2>
    <table>
        <c:forEach var="joueur" items="${joueurs}">
            <tr>
                <td><h3>${joueur.prenom} ${joueur.nom}<c:if test="${joueur.estEnLigne}"> (connecté)</c:if></h3></td>
                <td><h2>${joueur.meilleurScore}</h2></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
