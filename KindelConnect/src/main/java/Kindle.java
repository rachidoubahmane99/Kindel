
import DbConnection.DbConnection;
import java.awt.Desktop;
import java.awt.Panel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import model.Document;
import model.Livre;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rachid dev
 */
public class Kindle extends JFrame {
    private static int location= 1;
    public static final String ANSI_GREEN = "\u001B[32m";
      static boolean repeat=true;
      Connection con = null;
    public Statement stmt;
    
   public static void main (String args[]) throws IOException, SQLException 
    { 
          final JFrame frame=new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            frame.setSize(620,440);
            final JFXPanel fxpanel=new JFXPanel();
            frame.add(fxpanel);
        String hote = "127.0.0.1" ;
        int port = 1000 ;
        
        Socket soc = new Socket (hote, port) ;
        OutputStream flux1 = soc.getOutputStream() ; 
        OutputStreamWriter sortie = new OutputStreamWriter (flux1) ;
        InputStream flux2=soc.getInputStream();
        BufferedReader entree = new BufferedReader (new InputStreamReader (flux2));
      System.out.println("Bienvenue au Ensias Mediatheque ");
        System.out.println("login comme Etudiant Ou Professeuer");
        String type= (new Scanner(System.in)).nextLine();
        sortie.write(type+"\n") ;
        
       if (type.equalsIgnoreCase("etudiant")){
           System.out.println(" Login");
        String login= (new Scanner(System.in)).nextLine();
        sortie.write(login+"\n") ;
         System.out.println(" mot de pass");
        String mdp= (new Scanner(System.in)).nextLine();
        sortie.write("mot de pass :*******"+"\n") ;
            //Etudiant e = null;
           Kindle compte = new Kindle();
           boolean acc = compte.verefierCompteEtudiant(login,mdp);
           if (acc) {
                  while (repeat){
           
                System.out.println("Bienvenue au Ensias Mediatheque ");
                System.out.println("Veuillez choisir une option:\n     ");
                System.out.println("1: Chercher un document par ISBN   ");
                System.out.println("2: Chercher un document par titre  ");
                System.out.println("3: Chercher un document par Editeur");
                System.out.println("4: Chercher un document par Auteur ");
                 
                //private static int counter = 0;
               Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    
                @Override
                public void run() {
      //what you want to do
         
                    try { 
                       
                         location++;
                        int locationsend = location;
                        String locationF;
                        locationF = Files.readAllLines(Paths.get("IotFiles\\KindleGps.txt")).get(locationsend);
                        int loc = Integer.parseInt(locationF);
                        if (loc<500  ) {
                            sortie.write(loc+"\n") ;
                         sortie.flush();
                       
                  
                }else{
                            JOptionPane.showMessageDialog(null, "you can't use Kindle outside University ");
                              
                              sortie.write("kindle stolled"+"\n") ;
                         sortie.flush();
                         timer.cancel();//stop the timer
                         System.exit(0);
                        }
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Kindle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                }, 0, 10000);//wait 0 ms before doing the action and do it evry 1000ms (1second)


      
            int choix= (new Scanner(System.in)).nextInt();
            sortie.write(choix+"\n") ; 
            sortie.flush();
            switch (choix){
                case 1:
                    System.out.println("Veuillez saisir l'ISBN");
                        String isbn = (new Scanner(System.in)).nextLine();
                        sortie.write("isbn\n");
                        sortie.write(isbn +'\n');
                        sortie.flush();
                         Livre  d=null;
                          Kindle compte2 = new Kindle();
                        d= compte2.searchDocumentByIsbn(isbn);
                        if(d != null){
                            System.out.println(d.getTitre()); 
                            String pdf = d.getUrl();
                            /*
                            try {
                                Desktop desktop = java.awt.Desktop.getDesktop();
                                URI oURL = new URI(pdf);
                                desktop.browse(oURL);
                                } catch (Exception e) {
                                 e.printStackTrace();
                                 }
                                   */
                            Platform.runLater(new Runnable() {
                            @Override
                            public void run()
                             {
                                WebEngine engine;
                                  WebView wv=new WebView();
                                  engine=wv.getEngine();
                                  
                                  fxpanel.setScene(new Scene(wv));
                                  engine.load(pdf);
                                 }
                             });
                               frame.setVisible(true);
                        }else{
                            System.out.println("aucun livre avec se SBN exist");
                        }
                    //tell(entree,sortie);
                    //System.out.println("tell choised");
                    break;
                case 2:
                    //learn(entree,sortie);
                      System.out.println(" Veuillez saisir le titre : ");  
                        String titre   = (new Scanner(System.in)).nextLine();;
                        sortie.write("titre\n");
                        sortie.write(titre+'\n');
                        sortie.flush(); 
                        
                        System.out.println("Veuillez choisir un document à lire :");
                 
                   
                        Kindle compte3 = new Kindle();
                        LinkedList<Livre> documents = compte3.getLivreByTitre(titre);  
                           int nb = 0 ;
                           for(int i = 0 ; i < documents.size();i++){ 
                             System.out.println(i+" :"+documents.get(i).getIsbn()+"by : editeur:"+documents.get(i).getEditeur());
                             nb++;
                           }  
                            if (nb==0){
                                System.out.println("aucune document trouvé avec ce titre");      
                            }
                            else{
                            
                           int livre = (new Scanner(System.in)).nextInt();
                                  
                                  
                                    if(livre < nb && livre> -1){ 
                                    //affichage du document
                     
                            String pdf = documents.get(livre).getUrl();
                            
                            Platform.runLater(new Runnable() {
                            @Override
                            public void run()
                             {
                                  WebEngine engine;
                                  WebView wv=new WebView();
                                  engine=wv.getEngine();
                                  fxpanel.setScene(new Scene(wv));
                                  engine.load(pdf);
                                 }
                             });
                               frame.setVisible(true);
                                    }
                                    else 
                                        System.out.println("choix invalid");
            
                                   
                            }
     
                        break;
                case 3:
                    //quit(entree,sortie); 
                     System.out.println("leave choised");
                    break;
            }
            
            
        }
           }
           }
       
        
     
        soc.close();
        }

    public  boolean verefierCompteEtudiant(String cin,String mdp) throws SQLException {
     con = DbConnection.getConnection();
                   stmt = con.createStatement();

         //String sql = "SELECT * FROM personne Where cin = ? and password = ?";
         
         String query="select * from etudiant where  cin='"+cin+"' and password= '"+mdp+"' ";
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
   
}
