package objet;

import utilitaire.MyAnnotation;
import utils.Correspondance;
import utils.Model;
import utilitaire.ModelView;

@Correspondance(nomTable = "categorie_produit")
@MyAnnotation(isSegleton = true)
public class CategorieProduit extends Model{

    @Correspondance(primarykey = true)
    String id;
    @Correspondance
    String designation;
    @Correspondance(nomColonne = "reference_categorie")
    String referenceCategorie;

    @MyAnnotation(url = "formulaire-nouveau-categorie.st")
    public ModelView formulaireNouveauCategorie(){
        ModelView view = new ModelView();
        view.setView("Pages/Categorie/InsererCategorie.jsp");
        return view;
    }

    @MyAnnotation(url = "insertion-categorie.st")
    public ModelView insert() throws Exception{
        ModelView view = new ModelView();
        view.setView("formulaire-nouveau-categorie.st");
        this.prepare();
        this.insert(null);
        return view;
    }

    public void prepare() throws Exception{
        this.init();
        this.setNomFonction("SEQ_CATEGORIE_PRODUIT");
        this.setLongPK(10);
        this.setPrefixe("CATP");
        this.setId(this.construirePK(null));
    }

    public CategorieProduit(){
        init();
    }

    public void init(){
        this.setUrl("jdbc:postgresql://localhost:5432/gestion");
        this.setPassword("123Fabien$");
        this.setUsername("fabien");
    }

    public CategorieProduit(String designation, String referenceCategorie) throws Exception {
        init();
        this.setLongPK(10);
        this.setPrefixe("CATP");
        this.setId(this.construirePK(null));
        this.setDesignation(designation);
        this.setReferenceCategorie(referenceCategorie);
    }

    public String getId() {
        return id;
    }
    public void setId(final String id) {
        this.id = id;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(final String designation) throws Exception{
      //  if (designation.equals("")) throw new Exception("Designation must be specified");
        this.designation = designation;
    }
    public String getReferenceCategorie() {
        return referenceCategorie;
    }
    public void setReferenceCategorie(final String referenceCategorie) throws Exception{
       // if (referenceCategorie.equals("")) throw new Exception("Reference must be specified");
        this.referenceCategorie = referenceCategorie;
    }    
}
