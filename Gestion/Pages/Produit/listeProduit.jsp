<%@page import="java.util.Vector, objet.Produit" contentType="text/html" pageEncoding="UTF-8"%>

<%
    Vector<Produit> produits = (Vector) request.getAttribute("produits");
   
%>
    <jsp:include page="../INDEX/Action.jsp" flush="true"/>
    <div class="col-lg-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Liste des produits</h4>
               
                <div class="table-responsive pt-3">
                    <table class="table table-bordered">
                        <tr>
                            <th>Article</th>
                            <th>Designation</th>
                            <th>Details</th>
                        </tr>

                        <% for (int i = 0; i < produits.size(); i++) { %>
                            <tr>
                                <td><%=produits.get(i).getId()%></td>
                                <td><%=produits.get(i).getDesignation()%></td>
                                <td><a href="/Gestion/details-produit.st?id=<%=produits.get(i).getId()%>">Voir details >></a></td>
                            </tr>
                        <% } %>
                    </table>
                </div>
            </div>
        </div>    
    </div>
<jsp:include page="../INDEX/footer.jsp" flush="true"/>