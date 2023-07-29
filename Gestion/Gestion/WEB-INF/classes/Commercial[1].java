package objet;

import utils.Model;
import utils.Correspondance;

import java.util.ArrayList;
import java.util.HashMap;
import utilitaire.FileUpload;
import utilitaire.ModelView;
import utilitaire.MyAnnotation;
import utilitaire.Session;
import utilitaire.restApi;
import java.util.Vector;

import java.lang.reflect.*;
import java.sql.Connection;

@MyAnnotation(isSegleton = true)
@Correspondance(nomTable = "commercial")
public class Commercial extends Model{

    @Correspondance(primarykey = true)
    String id;
    @Correspondance
    String designation;
    @Correspondance
    String photo;

    @MyAnnotation(url = "liste-commercial.st")
    public ModelView listeCommercial() throws Exception{
        ModelView view = new ModelView();
        view.setView("Pages/Commercial/listeCommercial.jsp");
        Vector<Commercial> commercials = new Vector<>();
        commercials = this.selectAll(null);
        view.addItem("commercials", commercials);
        return view;
    }

    @MyAnnotation(url = "insertion-commercial.st")
    public ModelView insert() throws Exception{
        ModelView view = new ModelView();
        view.setView("Pages/Commercial/Commercial.jsp");
        this.prepare();
        this.insert(null);
        return view;
    }

    public Commercial(){
        this.init();
    }

    public void init(){
        this.setUrl("jdbc:postgresql://localhost:5432/gestion");
        this.setPassword("123Fabien$");
        this.setUsername("fabien");
    }

    public Commercial(String designation, String photo) throws Exception{
        this.init();
        this.setNomFonction("SEQ_COMMERCIAL");
        this.setLongPK(10);
        this.setPrefixe("COMM");
        this.setId(this.construirePK(null));
        this.setDesignation(designation);
        this.setPhoto(photo);
    }

    public void prepare() throws Exception{
        this.init();
        this.setNomFonction("SEQ_COMMERCIAL");
        this.setLongPK(10);
        this.setPrefixe("COMM");
        this.setId(this.construirePK(null));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation){
        //if (designation.equals("")) throw new Exception("Designation must be specified");
        this.designation = designation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}
