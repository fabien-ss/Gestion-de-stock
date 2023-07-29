package objet;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import utilitaire.MyAnnotation;
import utils.Correspondance;
import utils.Model;
import utilitaire.ModelView;

@MyAnnotation(isSegleton = true)
@Correspondance(nomTable = "sortie")
public class Sortie extends Model{
    
    @Correspondance(primarykey = true)
    String id;
    @Correspondance(nomColonne = "id_produit")
    String idProduit;
    @Correspondance(nomColonne = "date_sortie")
    Timestamp dateSortie;
    @Correspondance(nomColonne = "date_peremption")
    Timestamp datePeremption;
    @Correspondance(nomColonne = "prix_unitaire")
    float prixUnitaire;
    @Correspondance
    float quantite;

    @MyAnnotation(url = "insertion-sortie.st", ParametersNames = { "idcommercial" } )
    public ModelView insertionSortie(String idcommercial) throws Exception {
        idcommercial = idcommercial.trim();
        ModelView view = new ModelView();
        String url = "formulaire-sortie.st";
        System.out.println(url);
        view.setView(url);
        this.setNomFonction("SEQ_SORTIE");
        this.setLongPK(10);
        this.setPrefixe("SORT");
        this.setId(this.construirePK(null));
        this.insert(null);
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

    public Sortie() {
        this.init();
    }

    public void init(){
        this.setUrl("jdbc:postgresql://localhost:5432/gestion");
        this.setPassword("123Fabien$");
        this.setUsername("fabien");
    }

    public Sortie(String idProduit, String dateSortie, String datePeremption, String prixUnitaire, String quantite,
            float total) throws Exception {
        this.setNomFonction("SEQ_SORTIE");
        this.init();
        this.setLongPK(10);
        this.setPrefixe("SORT");
        this.setId(this.construirePK(null));
        this.setIdProduit(idProduit);
        this.setDateSortie(dateSortie);
        this.setDatePeremption(datePeremption);
        this.setPrixUnitaire(prixUnitaire);
        this.setQuantite(quantite);
    }

    public void prepare() throws Exception {
        this.setNomFonction("SEQ_SORTIE");
        this.setLongPK(10);
        this.setPrefixe("SORT");
        this.setId(this.construirePK(null));
    }

    public Sortie(String idProduit, Timestamp dateSortie, Timestamp datePeremption, float prixUnitaire, float quantite, float total) throws Exception {
        this.setNomFonction("SEQ_SORTIE");
        this.init();
        this.setLongPK(10);
        this.setPrefixe("SORT");
        this.setId(this.construirePK(null));
        this.setIdProduit(idProduit);
        this.setDateSortie(dateSortie);
        this.setDatePeremption(datePeremption);
        this.setPrixUnitaire(prixUnitaire);
        this.setQuantite(quantite);
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }
    public Timestamp getDateSortie() {
        return dateSortie;
    }
    public void setDateSortie(Timestamp dateSortie) {
        this.dateSortie = dateSortie;
    }
    public void setDateSortie(String dateSortie) throws ParseException {
        String datee = dateSortie;
        datee += ":00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(datee.replace("T", " "));
        Timestamp converted = new java.sql.Timestamp(parsedDate.getTime());
        this.setDateSortie(converted);
    }
    public Timestamp getDatePeremption() {
        return datePeremption;
    }
    public void setDatePeremption(Timestamp datePeremption) {
        this.datePeremption = datePeremption;
    }
    public void setDatePeremption(String datePsetDatePeremption) throws ParseException {
        String datee = datePsetDatePeremption;
        datee += ":00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(datee.replace("T", " "));
        Timestamp converted = new java.sql.Timestamp(parsedDate.getTime());
        this.setDatePeremption(converted);
    }
    public float getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    public void setPrixUnitaire(String prixUnitaire) {
        this.setPrixUnitaire((float) Float.valueOf(prixUnitaire));
    }
    public float getQuantite() {
        return quantite;
    }
    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }
    public void setQuantite(String quantite) {
        this.setQuantite((float) Float.valueOf(quantite));
    }
}
