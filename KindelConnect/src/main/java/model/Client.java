/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rachad
 */
public class Client extends Utilisateur {
    
    private String cin;
    private String nom;
    private String prenom;
    
    public Client(String login, String password, String cin, String  nom, String  prenom){
        super(login, password);
        this.cin= new String(cin);
        this.nom= new String(nom);
        this.prenom= new String(prenom);
    }
    
    public Client(Client c){
        super(c.getLogin(), c.getPassword());
        this.cin= new String(c.getCin());
        this.nom= new String(c.getNom());
        this.prenom= new String(c.getPrenom());
    }
    
    public String toString(){
        return "Cin: "+cin+" Nom:"+nom+" Prenom:"+ prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    
     
}
