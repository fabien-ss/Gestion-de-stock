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
                                <a href="../Commercial/Commercial.jsp">
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