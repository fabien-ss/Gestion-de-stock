/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@MyAnnotation(isSegleton = true)
@Correspondance(nomTable = "emp")
public class Emp extends Model{
    
    @Correspondance(primarykey = true)
    String id;
    @Correspondance
    String nom;
    @Correspondance
    String prenom;
    @Correspondance
    int numero;
    FileUpload photo;
    HashMap<String, Object> session;
    int[] animals;

    public void setAnimals(int[] animals) {
        this.animals = animals;
    }
    public int[] getAnimals() {
        return animals;
    }

    public void setSession(HashMap<String, Object> session) {
        this.session = session;
    }

    public HashMap<String, Object> getSession() {
        return session;
    }


    public FileUpload getPhoto() {
        return photo;
    }

    public void setPhoto(FileUpload photo) {
        this.photo = photo;
    }
    
//e
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNumero() {
        return numero;
    }
    

    public Emp(){
    }

    public Emp(String id,String nom, String prenom, int numero){
       // this.construirePK(null);
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setNumero(numero);
    }

    @MyAnnotation(url="disconnect.st")
    public ModelView disconnect(){
        ModelView m = new ModelView();
        m.setInvalidateSession(true);
        m.setView("index.jsp");
        return m;
    }
    
    @MyAnnotation(url="deleteProfile.st", ParametersNames = {"profil"})
    public ModelView deleteProfile(String profil){
        ModelView m = new ModelView();
        ArrayList<String> ses = new ArrayList<>();
        ses.add(profil);
        m.setSessionName(ses);
        m.setView("index.jsp");
        return m;
    }

    @MyAnnotation(url="login.st", ParametersNames = {})
    public ModelView login(){
        ModelView m = new ModelView();
        m.addSession("isConnected", this);
        m.addSession("", m);
        m.addSession("profil", this.getPrenom());
        m.addSession("nom", this.nom);
        m.addItem("prenom", this.prenom);
        m.setView("index.jsp");
        m.addItem("profi", this);
        return m;
    }

    
    @MyAnnotation(url="get-emp.st", ParametersNames = {})
    public ModelView getAll() throws Exception {

        Vector<Emp> emps = new Vector<>();
        try {
            //  method.invoke(objet, arguments);
            emps = this.selectAll(null);
        } catch (InvocationTargetException e) {
            System.out.println("Nisy erreur : " + e.getMessage());
            Throwable targetException = e.getTargetException();
            targetException.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Nisy erreur : " + e.getMessage());   
            System.out.println(e.getMessage());
        }
        ModelView m = new ModelView();
        m.setView("pagliste.jsp");
        m.addItem("liste",emps);
        return m;
    }
    
    @MyAnnotation(url="add-emp.st", ParametersNames = { "animals[]"})
    public ModelView inserer(int[] animals) {
        ModelView m = new ModelView();
        m.setView("emp.jsp");
        this.animals = animals;
        try {
            this.setNomFonction("seq_emp");
            this.setId(this.construirePK(null));
            this.insert(null);
        } catch (InvocationTargetException e) {
            System.out.println("Nisy erreur : " + e.getMessage());
            Throwable targetException = e.getTargetException();
            targetException.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Nisy erreur : " + e.getMessage());   
            System.out.println(e.getMessage());
        }
        m.addItem("emp", this);
        return m;
    }
    
    @Session
    @MyAnnotation(url="get-connected.st", ParametersNames = {})
    public ModelView getConnectedUser() {
        ModelView m = new ModelView();
        m.addItem("profil", this.getSession().get("profil"));
        m.addItem("emp", this.getSession().get("isConnected"));
        m.addItem("nom", this.getSession().get("nom"));
        m.setView("empsdetails.jsp");
        return m;
    }

    @restApi
    @MyAnnotation(url="testApi.st", ParametersNames = { "id"})
    public Emp numeroByAnnoation(String id){
        try{
            this.setId(id);
            return (Emp) this.select(null);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new Emp("2", "Jean", "Koto balida", 002);
    }

    @MyAnnotation(url="etudiant.st", ParametersNames = { "id" })
    public ModelView numero(String id){
        ModelView m = new ModelView();
        m.setIsJSON(true);
       // m.addItem("emp", new Emp("2", "Jean", "Koto balida", 002));
        try{
            this.setId(id);
            m.addItem("emp", this.select(null));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return m;
    }
    
    @MyAnnotation(url="update-emp.st",  aunth = "admin")
    public ModelView update_emp(){
        ModelView m = new ModelView();
        m.setView("empFiche.jsp");
    
        try{
            this.setId(id);
            this.update(null, this);
            m.addItem("emp", (Emp) this.select(null));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return m;
    }

    @MyAnnotation(url="find-emp.st" , ParametersNames = { "id" }, aunth = "admin")
    public ModelView findById(String id){
        ModelView m = new ModelView();
        m.setView("empFiche.jsp");
        try{
            m.addItem("emp", (Emp) this.select(null));
            m.setView("empFiche.jsp");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return m;
    }

    @MyAnnotation(url="delete-emp.st", ParametersNames = { "id" }, aunth = "admin")
    public ModelView delete_emp(String id){
        ModelView m = new ModelView();
        m.setView("get-emp");
    
        try{
            this.setId(id);
            this.delete(null);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return m;
    }

    
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
