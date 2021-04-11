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
public abstract class Document {
    
    private String titre;
    private String editeur;
    private int edition;
    private String isbn;
    private String[] auteurs;
    private String url;
    
    
    public Document( String titre, String editeur,int edition,String isbn,String[] auteurs, String url){
        this.titre= new String(titre);
        this.editeur= new String(editeur);
        this.edition=edition;
        this.isbn=new String(isbn);
        this.auteurs=auteurs;  
        this.url= new String(url);
    }
    public Document(){
        
    }

    public String getTitre() {
        return titre;
    }

    public String getEditeur() {
        return editeur;
    }

    public int getEdition() {
        return edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public String[] getAuteurs() {
        return auteurs;
    }
    
    public String toString(){
        return "Titre: "+ titre+" Editeur:"+ editeur+ " Edition:"+ edition+ "ISBN:"+isbn;
        //Ajouter les auteurs avec une boucle
        
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    
}
