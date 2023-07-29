package objet;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import utilitaire.MyAnnotation;
import utilitaire.ModelView;
import utils.Correspondance;
import utils.Model;

@MyAnnotation(isSegleton = true)
@Correspondance(nomTable = "sortie_produit")
public class SortieProduit extends Model {

    @Correspondance(primarykey = true)
    String id;
    @Correspondance(nomColonne = "id_produit")
    String idProduit;
    @Correspondance(nomColonne = "id_entree")
    String idEntree;
    @Correspondance
    float quantite;
    @Correspondance(nomColonne = "prix_sortie")
    float prixSortie;
    @Correspondance(nomColonne = "date_sortie")
    Timestamp dateSortie;

    @MyAnnotation(url = "sortie-produit.st")//, ParametersNames = { "idcommercial"})
    public ModelView sortieProduit(/*String idcommercial*/) throws Exception{

        ModelView view = new ModelView();
        Vector<SortieProduit> sorterProduits = new Vector<>();
        Vector<Entree> entrees = new Vector<>();
        entrees = new Entree().selectWhere(null, "date_peremption > NOW() and id_produit = '"+this.getIdProduit()+"' order by date_peremption asc");

        double quantiteBesoin = this.getQuantite(); // quantite à sortir
        for(int i=0; i<entrees.size(); i++){ // on boucle le stock d'entree
            if(quantiteBesoin < 0) quantiteBesoin = -1 * quantiteBesoin;
            System.out.println("Base: "+entrees.get(i).getQuantite());
            quantiteBesoin = entrees.get(i).getQuantite() - quantiteBesoin; // on enleve la quantite à sortir avec le stock
            // si quantiteBesoin positif alors ampy le stock voalhoa
            SortieProduit sortie = new SortieProduit();
            sortie.setIdProduit(this.getIdProduit());
            sortie.setId(this.construirePK(null));
            sortie.setIdEntree(entrees.get(i).getId());
            sortie.setQuantite((float) quantiteBesoin);
        
       //     sortie.setPrixSortie((float) quantiteBesoin * (entrees.get(i).getPrixUnitaire()) / () entrees.get(i).getQuantite() );
            sortie.setDateSortie(this.getDateSortie());
            sortie.insert(null);
            if(quantiteBesoin > 0){
                break;
            }
            // sinon raha negatif ilay izy de mbola tsy ampy
            //if(quantiteBesoin < 0) quantiteBesoin = quantiteBesoin * -1;
        }
     //   view.setView("formulaire-sortie.st");
        return view;
    }

    @MyAnnotation(url = "formulaire-sortie.st", ParametersNames = {"idcommercial"})
    public ModelView formulaireSortie(String idcommercial) throws Exception {
        ModelView view = new ModelView();
        view.setView("Pages/Sortie/InsererSortie.jsp");
        Produit produit = new Produit();
        Vector<Produit> produits = new Vector<>();
        produits = produit.selectAll(null);
        Vector<Produit> retour = new Vector<>();
        for (Produit prod : produits) {
            if(prod.getIdCommercial().equals(idcommercial)){
                retour.add(prod);
            }
        }
        Commercial commercial = new Commercial();
        commercial.setId(idcommercial);
        commercial = (Commercial) commercial.select(null);
        view.addItem("commercial", commercial);
        view.addItem("produits", retour);
        return view;
    }
    
    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public SortieProduit() throws Exception {
        this.init();
        this.setNomFonction("SEQ_SORTIE_PRODUIT");
        this.setLongPK(10);
        this.setPrefixe("SORT");
    }

    public void init(){
        this.setUrl("jdbc:postgresql://localhost:5432/gestion");
        this.setPassword("123Fabien$");
        this.setUsername("fabien");
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdEntree() {
        return idEntree;
    }
    public void setIdEntree(String idEntree) {
        this.idEntree = idEntree;
    }
    public float getQuantite() {
        return quantite;
    }
    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }
    public float getPrixSortie() {
        return prixSortie;
    }
    public void setPrixSortie(float prixSortie) {
        this.prixSortie = prixSortie;
    }
    public Timestamp getDateSortie() {
        return dateSortie;
    }
    public void setDateSortie(Timestamp dateSortie) {
        this.dateSortie = dateSortie;
    }    
}
