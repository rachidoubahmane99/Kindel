/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kindelconnect;

import DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import model.Livre;

/**
 *
 * @author rachid dev
 */
public class DocumentsController {
    Connection con = null;
    public Statement stmt;
    public DocumentsController(){
        
    }
    
    public Livre searchDocumentByIsbn(String isbn) throws SQLException{
        con = DbConnection.getConnection();
                   stmt = con.createStatement();
        String query="select * from livre where isbn like'"+isbn+"' ";
        ResultSet rs=stmt.executeQuery(query);
       
        if (rs.next()) {
            
           String titre=rs.getString("titre");
           String editeur=rs.getString("editeur");
           String auteur=rs.getString("auteur");
           int edition=rs.getInt("edition");
           int nbpages=rs.getInt("nbpages");
           String auteurs[]={auteur};
           String url=rs.getString("url");
           Livre l = new Livre(titre, editeur, edition, isbn,auteurs,url,nbpages);
           //l.toString();
            //System.out.println(url);
           return l;
       }
        return null;
    }
    
    public LinkedList<Livre> getLivreByTitre(String titre) throws SQLException{
     con = DbConnection.getConnection();
                   stmt = con.createStatement();
        String query="select * from livre where titre like '"+titre+"' ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new   LinkedList<Livre> ();
        
        while (rs.next()) {
           String isbn=rs.getString("isbn");
           String editeur=rs.getString("editeur");
           String auteur=rs.getString("auteur");
           int edition=rs.getInt("edition");
           int nbpages=rs.getInt("nbpages");
           String auteurs[]={auteur};
           String url=rs.getString("url");
           Livre l = new Livre(titre, editeur, edition, isbn,auteurs,url,nbpages);
           livres.add(l);
       }

       return livres;
    }
    
    public LinkedList<Livre> getLivreByEditeur(String editeurName) throws SQLException{
     con = DbConnection.getConnection();
                   stmt = con.createStatement();
        String query="select * from livre where editeur  like '"+editeurName+"' ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new   LinkedList<Livre> ();
        
        while (rs.next()) {
            String titre = rs.getString("titre");
           String isbn=rs.getString("isbn");
           String editeur=rs.getString("editeur");
           String auteur=rs.getString("auteur");
           int edition=rs.getInt("edition");
           int nbpages=rs.getInt("nbpages");
           String auteurs[]={auteur};
           String url=rs.getString("url");
           Livre l = new Livre(titre, editeur, edition, isbn,auteurs,url,nbpages);
           livres.add(l);
       }

       return livres;
    }
    
    public LinkedList<Livre> getLivreByAuteur(String auteurName) throws SQLException{
     con = DbConnection.getConnection();
                   stmt = con.createStatement();
        String query="select * from livre where auteur  like '"+auteurName+"' ";
        ResultSet rs=stmt.executeQuery(query);
        
        LinkedList<Livre> livres= new   LinkedList<Livre> ();
        
        while (rs.next()) {
            String titre = rs.getString("titre");
           String isbn=rs.getString("isbn");
           String editeur=rs.getString("editeur");
           String auteur=rs.getString("auteur");
           int edition=rs.getInt("edition");
           int nbpages=rs.getInt("nbpages");
           String auteurs[]={auteur};
           String url=rs.getString("url");
           Livre l = new Livre(titre, editeur, edition, isbn,auteurs,url,nbpages);
           livres.add(l);
       }

       return livres;
    }
}
