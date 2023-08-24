package objet;

import java.util.Vector;

import utilitaire.MyAnnotation;
import utils.Correspondance;
import utils.Model;
import utilitaire.ModelView;

@MyAnnotation(isSegleton = true)
@Correspondance(nomTable = "unite")
public class Unite extends Model {

    @Correspondance(primarykey = true)
    String id;
    @Correspondance
    String valeur;
    @Correspondance
    float unite;

    public Unite() {
        this.init();
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
    public String getValeur() {
        return valeur;
    }
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
    public float getUnite() {
        return unite;
    }
    public void setUnite(float unite) {
        this.unite = unite;
    }
    
}
