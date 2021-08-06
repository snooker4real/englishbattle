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
    <h2>Utilisateur : ${sessionScope.partie.joueur.prenom} ${sessionScope.partie.joueur.nom} (${sessionScope.partie.joueur.niveau.nom}), meilleur score: ${sessionScope.partie.joueur.getMeilleurScore()} verbes</h2>
    <h3>Question  : le verbe </h3>
    <h4>Il vous reste 60 seconde(s) pour répondre</h4>
    <form action="jeu" method="post">

        <table class="table">
            <tr>
                <!-- On récupère la dernière question de la partie qui est en session-->
                <!-- Sur cette question, on récupère le verbe puis sa base verbale (navigabilité)-->
                <td>${sessionScope.partie.getDerniereQuestion().verbe.baseVerbale}</td>
                <td><input type="text" name="PRETERIT" placeholder="preterit" required=""></td>
                <td><input type="text" name="PARTICIPE_PASSE" placeholder="Participe Passe" value="" required=""></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Envoyer" class="btn btn-info">
                </td>
            </tr>
        </table>

    </form>
</body>
