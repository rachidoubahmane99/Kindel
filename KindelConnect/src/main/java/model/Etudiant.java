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
public class Etudiant extends Client{
    private String cne;
    public Etudiant(String login, String password, String cin, String  nom, String  prenom, String cne){
        super(login, password, cin, nom, prenom);
        this.cne= new String(cne);
    }
    
      public String toString(){
        return super.toString()+" CNE: "+cne;
    } 

    public String getCne() {
        return cne;
    }
      
            
}
