<%@page import="objet.Stock" contentType="text/html" pageEncoding="UTF-8"%>

<%
    Stock stock = (Stock) request.getAttribute("produit"); 
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
        <div class="row">
            <div class="col-md-5">
                <h1><%=stock.getDesignation()%></h1>
                <h2>Quantité restante: <%=stock.getQuantite()%> <%=stock.getUnite()%></h2>
                <h2>Catégorie: <%=stock.getCategorie()%></h2>
                <h2>Commercial: <%=stock.getCommercial()%></h2>
                <h2>Date: </h2>
                <h2>Price: </h2>
            </div>
        </div>
    </div>
</body>
</html>