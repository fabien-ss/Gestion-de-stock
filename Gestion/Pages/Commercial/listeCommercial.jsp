<%@page import="java.util.Vector, objet.Commercial" contentType="text/html" pageEncoding="UTF-8"%>

<%
    Vector<Commercial> commercials = (Vector) request.getAttribute("commercials");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Gestion/assets/css/bootstrap.css">
    <title>Document</title>
</head>
<body>
    <jsp:include page="../INDEX/Action.jsp" flush="true"/>
    <style>
        .nav-item {
            margin-right: 1%;
        }
        .nav-item li {
            list-style: square;
        }
    </style>
    <div class="container" style="margin-top: 5rem;">
        <h1>Liste des commercials</h1>
        <table class="table">
            <tr>
                <th>Nom</th>
                <th>Entree</th>
                <th>Sortie</th>
            </tr>
            <% for (int i = 0; i < commercials.size(); i++) { %>
            <div class="row">
                <tr>
                    <td><%=commercials.get(i).getDesignation()%></td>
                    <td><a href="/Gestion/formulaire-entree.st?idcommercial=<%=commercials.get(i).getId()%>">Entree produit</a></td>
                    <td><a href="/Gestion/formulaire-sortie.st?idcommercial=<%=commercials.get(i).getId()%>">Sortie produit</a></td>
                </tr>
            </div>
            <% } %>
        </table>
    </div>
</body>
</html>