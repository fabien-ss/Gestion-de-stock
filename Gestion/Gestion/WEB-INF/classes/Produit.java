package objet;

import java.util.Vector;

import utilitaire.MyAnnotation;
import utils.Correspondance;
import utils.Model;
import utilitaire.ModelView;

@MyAnnotation(isSegleton = true)
@Correspondance(nomTable = "produit")
public class Produit extends Model{

    @Correspondance(primarykey = true)
    String id;
    @Correspondance(nomColonne = "id_categorie")
    String idCategorie;
    @Correspondance(nomColonne = "id_commercial")
    String idCommercial;
    @Correspondance
    String designation;
    @Correspondance(nomColonne = "reference_produit")
    String referenceProduit;
    @Correspondance(nomColonne = "prix_unitaire")
    float prixUnitaire;
    @Correspondance(nomColonne = "id_unite")
    String idUnite;

    @MyAnnotation(url = "details-produit.st")
    public ModelView detailsProduit() throws Exception {
        Stock stock = new Stock();
        stock.setIdProduit(this.getId());
        stock = (Stock) stock.select(null);
        ModelView view = new ModelView();
        view.addItem("produit", stock);
        view.setView("Pages/Produit/detailsProduit.jsp");
        return view;
    }
    
    @MyAnnotation(url = "etat-stock-produit.st")
    public ModelView etatProduit(){
        ModelView view = new ModelView();
        view.setView("Pages/Produit/detailsProduit.jsp");
        return view;
    }

    
    @MyAnnotation(url = "rechercher-produit-IDCOM-IDCAT.st")
    public ModelView rechercherProduit() throws Exception{
        ModelView view = new ModelView();
        view.setView("Pages/Produit/listeProduit.jsp");
        Vector<Produit> produits = new Vector<>();
        produits = this.selectAll(null);
        Vector<Produit> retour = new Vector<>();
        for (Produit produit : produits) {
            if(produit.getIdCategorie().equals(this.getIdCategorie()) && produit.getIdCommercial().equals(this.getIdCommercial())){
                retour.add(produit);
            }
        }
        view.addItem("produits", retour);
        return view;
    }

    @MyAnnotation(url = "rechercher-produit-IDCOM.st")
    public ModelView rechercherProduitIDCOM() throws Exception{
        ModelView view = new ModelView();
        view.setView("Pages/Produit/listeProduit.jsp");
        Vector<Produit> produits = new Vector<>();
        produits = this.selectAll(null);
        Vector<Produit> retour = new Vector<>();
        for (Produit produit : produits) {
            if(produit.getIdCommercial().equals(this.getIdCommercial())){
                retour.add(produit);
            }
        }
        view.addItem("produits", retour);
        return view;
    }

    @MyAnnotation(url = "rechercher-produit-IDCAT.st")
    public ModelView rechercherProduitIDCAT() throws Exception{
        ModelView view = new ModelView();
        view.setView("Pages/Produit/listeProduit.jsp");
        Vector<Produit> produits = new Vector<>();
        produits = this.selectAll(null);
        Vector<Produit> retour = new Vector<>();
        for (Produit produit : produits) {
            if(produit.getIdCategorie().equals(this.getIdCategorie())){
                retour.add(produit);
            }
        }
        view.addItem("produits", retour);
        return view;
    }

    @MyAnnotation(url = "formulaire-recherche-produit.st")
    public ModelView formulaireRechercheProduit() throws Exception{
        ModelView view = new ModelView();
        view.setView("Pages/Produit/RechercherProduit.jsp");
        Vector<CategorieProduit> categorieProduits = new Vector<>();
        Vector<Commercial> commercials = new Vector<>();
        CategorieProduit cat = new CategorieProduit();
        Commercial com = new Commercial();
        categorieProduits = cat.selectAll(null);
        commercials = com.selectAll(null);
        view.addItem("categories", categorieProduits);
        view.addItem("commercials", commercials);
        return view;
    }

    @MyAnnotation(url = "liste-produit.st")
    public ModelView listeProduit() throws Exception{
        ModelView view = new ModelView();
        view.setView("Pages/Produit/listeProduit.jsp");
        Vector<Produit> produits = new Vector<>();
        produits = this.selectAll(null);
        view.addItem("produits", produits);
        return view;
    }

    @MyAnnotation(url = "formulaire-nouveau-produit.st")
    public ModelView formulaireNouveauProduit() throws Exception{
        ModelView view = new ModelView();
        view.setView("Pages/Produit/InsererProduit.jsp");
        Vector<CategorieProduit> categorieProduits = new Vector<>();
        Vector<Commercial> commercials = new Vector<>();
        Vector<Unite> unites = new Vector<>();
        CategorieProduit cat = new CategorieProduit();
        Commercial com = new Commercial();
        Unite unite = new Unite();
        unites = unite.selectAll(null);
        categorieProduits = cat.selectAll(null);
        commercials = com.selectAll(null);
        view.addItem("categories", categorieProduits);
        view.addItem("commercials", commercials);
        view.addItem("unites", unites);
        return view;
    }

    @MyAnnotation(url = "insertion-produit.st")
    public ModelView insert() throws Exception{
        ModelView view = new ModelView();
        view.setView("formulaire-nouveau-produit.st");
        this.prepare();
        this.insert(null);
        
        Sortie sortie = new Sortie();
        sortie.prepare();
        sortie.setIdProduit(this.getId());
        sortie.setPrixUnitaire(this.getPrixUnitaire());
        sortie.setQuantite(0);
        sortie.insert(null);

        Entree entree = new Entree();
        entree.prepare();
        entree.setIdProduit(this.getId());
        entree.setPrixUnitaire(this.getPrixUnitaire());
        entree.setQuantite(0);
        entree.insert(null);

        return view;
    }

    public Produit() {
        this.init();
    }

    public void init(){
        this.setUrl("jdbc:postgresql://localhost:5432/gestion");
        this.setPassword("123Fabien$");
        this.setUsername("fabien");
    }

    public Produit(String idCategorie, String idCommercial, String designation, String referenceProduit, String prixUnitaire) throws Exception {
        this.init();
        this.setPrefixe("PROD");
        this.setNomFonction("SEQ_PRODUIT");
        this.setLongPK(10);
        this.setId(this.construirePK(null));
        this.setIdCategorie(idCategorie);
        this.setIdCommercial(idCommercial);
        this.setDesignation(designation);
        this.setReferenceProduit(referenceProduit);
        this.setPrixUnitaire(prixUnitaire);
    }

    public Produit(String idCategorie, String idCommercial, String designation, String referenceProduit, float prixUnitaire) throws Exception {
        this.init();
        this.setPrefixe("PROD");
        this.setLongPK(10);
        this.setId(this.construirePK(null));
        this.setIdCategorie(idCategorie);
        this.setIdCommercial(idCommercial);
        this.setDesignation(designation);
        this.setReferenceProduit(referenceProduit);
        this.setPrixUnitaire(prixUnitaire);
    }

    public void prepare() throws Exception{
        this.init();
        this.setNomFonction("SEQ_PRODUIT");
        this.setLongPK(10);
        this.setPrefixe("PROD");
        this.setId(this.construirePK(null));
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdCategorie() {
        return idCategorie;
    }
    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }
    public String getIdCommercial() {
        return idCommercial;
    }
    public void setIdCommercial(String idCommercial) {
        this.idCommercial = idCommercial;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getReferenceProduit() {
        return referenceProduit;
    }
    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
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

    public String getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(String idUnite) {
        this.idUnite = idUnite;
    }
}
