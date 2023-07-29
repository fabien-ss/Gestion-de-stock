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
public class SortieProduit extends Model{

    @Correspondance(primarykey = true)
    String id;
    @Correspondance(nomColonne = "id_entree")
    String idEntree;
    @Correspondance
    float quantite;
    @Correspondance(nomColonne = "prix_sortie")
    float prixSortie;
    @Correspondance(nomColonne = "date_sortie")
    Timestamp dateSortie;

    public ModelView sortieProduit() throws Exception{
        ModelView view = new ModelView();
        Vector<Entree> entrees = new Vector<>();
        Vector<SortieProduit> sorterProduits = new Vector<>();
        entrees = new Entree().selectWhere(null, "date_peremption > NOW() order by date_peremption asc");

        float quantiteBesoin = this.getQuantite();
        for(int i=0; i<entrees.size(); i++){
            quantiteBesoin -= entrees.get(i).getQuantite();
            if(entrees.get(i).getQuantite() > 0){
                
            }
        }
        return view;
    }

    public SortieProduit(){
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
