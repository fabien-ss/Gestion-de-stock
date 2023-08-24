<%@page import="java.util.Vector, objet.Commercial, objet.CategorieProduit, objet.Unite" contentType="text/html" pageEncoding="UTF-8"%>

<%
    Vector<Commercial> commercials = (Vector) request.getAttribute("commercials");
    Vector<CategorieProduit> categories = (Vector) request.getAttribute("categories");
    Vector<Unite> unites = (Vector) request.getAttribute("unites");
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
        <form method="post" class="form-control" action="/Gestion/insertion-produit.st" enctype="multipart/form-data">
            Categorie
            <select name="idCategorie" class="form-select">
                <% for (int i = 0; i < categories.size(); i++) { %>
                    <option value=<%=categories.get(i).getId()%>><%=categories.get(i).getDesignation()%></option>
                <% } %>
            </select>
            
            Commercial
            <select name="idCommercial" class="form-select">
                <% for (int i = 0; i < commercials.size(); i++) { %>
                    <option value=<%=commercials.get(i).getId()%>><%=commercials.get(i).getDesignation()%></option>
                <% } %>
            </select>
            
            Unite
            <select name="idUnite" class="form-select">
                <% for (int i = 0; i < unites.size(); i++) { %>
                    <option value=<%=unites.get(i).getId()%>><%=unites.get(i).getValeur()%></option>
                <% } %>
            </select>
            
            Designation <input type="text" name="designation" class="form-control">
            
            Reference <input type="text" name="referenceProduit" class="form-control">
            
            Prix unitaire <input type="number" name="prixUnitaire" class="form-control">
            <input type="submit" class="btn btn-primary mt-3">
        </form>
    </div>
</body>
</html>