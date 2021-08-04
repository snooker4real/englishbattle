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
    <title>Inscription English Battle</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <h1>Inscription English Battle</h1>
    <form action="InscriptionServlet" method="post">

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">#</span>
            </div>
            <input type="text" name="NOM" class="form-control" placeholder="Nom" aria-label="Username" aria-describedby="basic-addon1" pattern="[A-ZA-z]*" required="">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon2">#</span>
            </div>
            <input type="text" name="PRENOM" class="form-control" placeholder="Prénom" aria-label="Username" aria-describedby="basic-addon1" pattern="[A-ZA-z]*" required="">
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
            <input type="password" name="MOT_DE_PASSE" class="form-control" placeholder="Mot de passe" aria-label="Username" aria-describedby="basic-addon1" pattern="[A-ZA-z]*" required="">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Niveau</label>
            </div>
            <select name="ID_NIVEAU" required class="custom-select" id="inputGroupSelect01">
                <option selected>Choisi un niveau...</option>
                <option value="1">Débutant</option>
                <option value="2">Intermédiaire</option>
                <option value="3">Expert</option>
            </select>
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Ville</label>
            </div>
            <select name="ID_VILLE" required class="custom-select" id="inputGroupSelect02">
                <option selected>Choisi une ville...</option>
                <option value="1">Paris</option>
                <option value="2">Marseille</option>
                <option value="3">Lyon</option>
                <option value="4">Lille</option>
            </select>
        </div>

        <button type="button" class="btn btn-primary">Primary</button>

        <input type="submit" value="Inscription">
    </form>
</body>
</html>
