<%@page import="java.util.Vector, objet.Produit, objet.Commercial" contentType="text/html" pageEncoding="UTF-8"%>

<%
    Vector<Produit> produits = (Vector) request.getAttribute("produits");
    Commercial commercial = (Commercial) request.getAttribute("commercial");
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
        <h1>Entree de produit <%=commercial.getDesignation()%></h1>
        <form class="form-control" action="/Gestion/insertion-entree.st" enctype="multipart/form-data" method="post">
            Entree <input class="form-control" type="datetime-local" name="dateEntree"> 
            Peremption <input class="form-control" type="datetime-local" name="datePeremption"> 
            Prix <input class="form-control" type="number" name="prixUnitaire"> 
            Quantite <input class="form-control" type="number" name="quantite"> 
            Produit du Commercial <%=commercial.getDesignation()%>
            <select name="idProduit" class="form-select">
                <% for (int i = 0; i < produits.size(); i++) { %>
                    <option value="<%=produits.get(i).getId()%>"><%=produits.get(i).getDesignation()%></optioin>
                <% } %>
            </select>
            <input class="form-control" type="hidden" name="idcommercial" value="<%=commercial.getId()%>">
            <input type="submit" class="btn btn-primary mt-3">
        </form>
    </div>
</body>
</html>