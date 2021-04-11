/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author rachad
 */
public class Consultation {
    
    Emprunt emprunt;
    Document document;
    Date date_consultation;
    
    public Consultation(Emprunt emprunt,Document document, Date date_consultation ){
        this.emprunt=emprunt;
        this.document=document;
        this.date_consultation=new Date();
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Date getDate_consultation() {
        return date_consultation;
    }

    public void setDate_consultation(Date date_consultation) {
        this.date_consultation = date_consultation;
    }
    
    
    public String toString(){
        return "A definir";
    }
    
}
