<%--
  Created by IntelliJ IDEA.
  User: cindanojonathan
  Date: 04/08/2021
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>English Battle - Question</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

    <h1>English Battle - Jeu</h1>
    <h3>Utilisateur : ${sessionScope.partie.joueur.prenom} ${sessionScope.partie.joueur.nom} (${sessionScope.partie.joueur.niveau.nom})</h3>

</body>
