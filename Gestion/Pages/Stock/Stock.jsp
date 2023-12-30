<%@page import="java.util.Vector, objet.Stock, objet.Commercial, objet.CategorieProduit" contentType="text/html" pageEncoding="UTF-8"%>

<%
;
    Vector<Commercial> commercials = (Vector) request.getAttribute("commercials");
    Vector<CategorieProduit> categories = (Vector) request.getAttribute("categories");
    Vector<Stock> stock = (Vector) request.getAttribute("stock");
    String etat = (String) request.getAttribute("etat");
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
    <div class="container">
        <div class="col-md-12">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
              <!-- Container wrapper -->
                <div class="container">
                <!-- Navbar brand -->
                    <a class="navbar-brand me-2" href="https://mdbgo.com/">
                        <img
                            src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp"
                            height="16"
                            alt="MDB Logo"
                            loading="lazy"
                            style="margin-top: -1px;"
                    />
                    </a>
            
                <!-- Toggle button -->
                    <button
                        class="navbar-toggler"
                        type="button"
                        data-mdb-toggle="collapse"
                        data-mdb-target="#navbarButtonsExample"
                        aria-controls="navbarButtonsExample"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                    >
                        <i class="fas fa-bars"></i>
                    </button>
            
                <!-- Collapsible wrapper -->
                    <div class="" id="navbarButtonsExample">
                    <!-- Left links -->
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a href="/Gestion/formulaire-nouveau-produit.st">
                                    Nouveau Produit
                                </a>
                            </li>
    
                            <li class="nav-item">
                                <a href="/Gestion/formulaire-nouveau-categorie.st">
                                    Nouveau Categorie
                                </a>
                            </li>
    
                            <li class="nav-item">
                                <a href="/Gestion/Pages/Commercial/Commercial.jsp">
                                    Nouveau Commercial
                                </a>
                            </li>
    
                            <li class="nav-item">
                                <a href="/Gestion/liste-produit.st">
                                    Liste des produits
                                </a>
                            </li>
    
                            <li class="nav-item">
                                <a href="/Gestion/liste-commercial.st">
                                    Liste des commercials
                                </a>
                            </li>
    
                            <li class="nav-item">
                                <a href="/Gestion/formulaire-recherche-produit.st">
                                    Rechercher produit
                                </a>
                            </li>
    
                            <li class="nav-item">
                                <a href="/Gestion/voir-stock.st">
                                    Voir stock
                                </a>
                            </li>
                        </ul>
                    </div>
                <!-- Collapsible wrapper -->
                </div>
              <!-- Container wrapper -->
            </nav>
            
        </div>
    </div>
    <style>
        .nav-item {
            margin-right: 1%;
        }
        .nav-item li {
            list-style: square;
        }
    </style>
    <div class="container" style="margin-top: 5rem;">
        <h1>Stock <%=etat%></h1>
        
        <form action="voir-stock-filtrer.st" class="form-control mt-3" method="post" enctype="multipart/form-data">
            Filter by 
            Commercial 
            <select name="idCommercial" class="form-select">
                <option value="">Commercial</option>
                <% for (int i = 0; i < commercials.size(); i++) { %>
                    <option value=<%=commercials.get(i).getId()%>><%=commercials.get(i).getDesignation()%></option>
                <% } %>
            </select>
            Categorie 
            <select name="idCategorie" class="form-select">
                <option value="">Categorie</option>
                <% for (int i = 0; i < categories.size(); i++) { %>
                    <option value=<%=categories.get(i).getId()%>><%=categories.get(i).getDesignation()%></option>
                <% } %>
            </select>
            <input type="submit" class="btn btn-primary mt-3">
            <a href="/Gestion/voir-stock-perime.st">Voir produit périmé >></a>
        </form>

        <table class="table">
            <tr>
                <th>Designation</th>
                <th>Quantite</th>
                <th>Categorie</th>
                <th>Commercial</th>
            </tr>
            <% for (int i = 0; i < stock.size(); i++) { %>
                <tr>
                    <td><%=stock.get(i).getDesignation()%></td>
                    <td><%=stock.get(i).getQuantite()%></td>
                    <td><%=stock.get(i).getCategorie()%></td>
                    <td><%=stock.get(i).getCommercial()%></td>
                </tr>
            <% } %>
        </table>
    </div>
</body>
</html>