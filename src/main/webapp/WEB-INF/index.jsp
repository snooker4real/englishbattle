<%--
  Created by IntelliJ IDEA.
  User: cindanojonathan
  Date: 04/08/2021
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8" />
    <title>English Battle</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <h1>English Battle</h1>

    <form action="connexion" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">Adresse Em@il</label>
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
        <button type="submit" class="btn btn-primary">Valider</button>
    </form>
</body>
</html>
