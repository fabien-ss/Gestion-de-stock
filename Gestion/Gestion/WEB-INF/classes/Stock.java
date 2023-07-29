package objet;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import utilitaire.MyAnnotation;
import utils.Correspondance;
import utils.Model;
import utilitaire.ModelView;

@MyAnnotation(isSegleton = true)
@Correspondance(nomTable = "Etat_stock")
public class Stock extends Model {

    @Correspondance
    String unite;
    @Correspondance
    double quantite;
    @Correspondance
    String designation;
    @Correspondance(nomColonne = "id_produit", primarykey = true)
    String idProduit;
    @Correspondance(nomColonne = "id_categorie")
    String idCategorie;
    @Correspondance
    String categorie;
    @Correspondance(nomColonne = "id_commercial")
    String idCommercial;
    @Correspondance
    String commercial;

    @MyAnnotation(url = "voir-stock.st")
    public ModelView afficherStock() throws Exception {
        String etat = "";
        ModelView view = new ModelView();
        view.setView("Pages/Stock/Stock.jsp");
        Vector<Commercial> commercials = new Vector<>();
        commercials = new Commercial().selectAll(null);
        Vector<CategorieProduit> categories = new Vector<>();
        categories = new CategorieProduit().selectAll(null);
        Vector<Stock> stock = new Vector<>();
        this.init();
        stock = this.selectAll(null);
        view.addItem("stock", stock);
        view.addItem("commercials", commercials);
        view.addItem("categories", categories);
        view.addItem("etat", etat);
        return view;
    }

    @MyAnnotation(url = "voir-stock-perime.st")
    public ModelView afficherStockPerime() throws Exception {
        String etat = "Perime";
        ModelView view = new ModelView();
        view.setView("Pages/Stock/Stock.jsp");
        Vector<Commercial> commercials = new Vector<>();
        commercials = new Commercial().selectAll(null);
        Vector<CategorieProduit> categories = new Vector<>();
        categories = new CategorieProduit().selectAll(null);
        Vector<Stock> stock = new Vector<>();
        this.init();
        stock = this.selectQuery(null, "select * from etat_stock_perime");
        view.addItem("stock", stock);
        view.addItem("commercials", commercials);
        view.addItem("categories", categories);
        view.addItem("etat", etat);
        return view;
    }

    @MyAnnotation(url = "voir-stock-filtrer.st")
    public ModelView filtrerStock() throws Exception {
        String etat = "";
        String condition = "";
        if(!this.idCommercial.equals("") & !this.idCategorie.equals("")){
            condition = " id_commercial = '"+this.idCommercial+"' and id_categorie = '"+this.idCategorie+"'";
        }
        else if(!this.idCategorie.equals("") & this.idCommercial.equals("")){
            condition = "id_categorie = '"+this.idCategorie+"'";
        }
        else if(!this.idCommercial.equals("") & this.idCategorie.equals("")){
            condition = "id_commercial = '"+this.idCommercial+"'";
        }
        Vector<Commercial> commercials = new Vector<>();
        commercials = new Commercial().selectAll(null);
        Vector<CategorieProduit> categories = new Vector<>();
        categories = new CategorieProduit().selectAll(null);
        Vector<Stock> stock = new Vector<>();
        this.init();
        stock = this.selectWhere(null, condition);

        ModelView view = new ModelView();
        view.setView("Pages/Stock/Stock.jsp");
        view.addItem("stock", stock);
        view.addItem("commercials", commercials);
        view.addItem("categories", categories);
        view.addItem("etat", etat);
        return view;
    }

    public Stock(){
        this.init();
    }

    public void init(){
        this.setUrl("jdbc:postgresql://localhost:5432/gestion");
        this.setPassword("123Fabien$");
        this.setUsername("fabien");
    }

    public static void main(String[] args) throws Exception {
        Stock stock = new Stock();
        Vector<Stock> ss = stock.selectAll(null);
        for (Stock stock2 : ss) {
            System.out.println(stock2.getDesignation());
        }
    }    

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getIdCommercial() {
        return idCommercial;
    }

    public void setIdCommercial(String idCommercial) {
        this.idCommercial = idCommercial;
    }

    public String getCommercial() {
        return commercial;
    }

    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
    
}
