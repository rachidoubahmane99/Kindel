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

/**
 *
 * @author rachid dev
 */
public class ProfesseurController {
       Connection con = null;
    public Statement stmt;
    public ProfesseurController(){
        
    }
    
    public  boolean verefierCompteProfesseur(String cin,String mdp) throws SQLException {
     con = DbConnection.getConnection();
                   stmt = con.createStatement();

         //String sql = "SELECT * FROM personne Where cin = ? and password = ?";
         
         String query="select * from professeur where  cin='"+cin+"' and password= '"+mdp+"' ";
        ResultSet rs=stmt.executeQuery(query);
        
        //LinkedList<Livre> livres= new   LinkedList<Livre> ();
       
            try {
               
                if (!rs.next()) {
                  System.out.println("failed");
                  return false;
                } else {
                  System.out.println("succesfully connected");
                  return true ;
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        return true; 
    }
    
}
