<%@page import="java.util.Vector, objet.Commercial, objet.CategorieProduit" contentType="text/html" pageEncoding="UTF-8"%>

<%
    Vector<Commercial> commercials = (Vector) request.getAttribute("commercials");
    Vector<CategorieProduit> categories = (Vector) request.getAttribute("categories");
%>

    <jsp:include page="../INDEX/Action.jsp" flush="true"/>
    <style>
        .nav-item {
            margin-right: 1%;
        }
        .nav-item li {
            list-style: square;
        }
    </style>

    <div class="col-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4>Recherche produit</h4>
                <form method="post" class="forms-sample" action="/Gestion/rechercher-produit-IDCOM-IDCAT.st" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="exampleInputName1">Categorie</label>
                        <select name="idCategorie" class="form-control" id="exampleSelectGender">
                            <% for (int i = 0; i < categories.size(); i++) { %>
                                <option value=<%=categories.get(i).getId()%>><%=categories.get(i).getDesignation()%></option>
                            <% } %>
                        </select>
                    </div>
                    
                    <div class="form-group" >
                        <label for="exampleInputName1">Commercial</label>
                        <select name="idCommercial" class="form-control" id="exampleSelectGender">
                            <% for (int i = 0; i < commercials.size(); i++) { %>
                                <option value=<%=commercials.get(i).getId()%>><%=commercials.get(i).getDesignation()%></option>
                            <% } %>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-primary mt-3">
                </form>
            </div>
        </div>
    </div>
    <div class="col-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4>Recherche produit</h4>
                <form method="post" class="form-control mt-5" action="/Gestion/rechercher-produit-IDCOM.st" enctype="multipart/form-data">
                    <div class="form-group" >
                        <label for="exampleInputName1">Commercial</label>
                        <select name="idCommercial" class="form-control" id="exampleSelectGender">
                            <% for (int i = 0; i < commercials.size(); i++) { %>
                                <option value=<%=commercials.get(i).getId()%>><%=commercials.get(i).getDesignation()%></option>
                            <% } %>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-primary mt-3">
                </form>
            </div>
        </div>
    </div>
    <div class="col-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4>Recherche produit</h4>
                <form method="post" class="form-control mt-5" action="/Gestion/rechercher-produit-IDCAT.st" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="exampleInputName1">Categorie</label>
                        <select name="idCategorie" class="form-control" id="exampleSelectGender">
                            <% for (int i = 0; i < categories.size(); i++) { %>
                                <option value=<%=categories.get(i).getId()%>><%=categories.get(i).getDesignation()%></option>
                            <% } %>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-primary mt-3">
                </form>
            </div>
        </div>
    </div>
