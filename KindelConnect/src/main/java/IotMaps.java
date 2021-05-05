/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rachid dev
 */
public class IotMaps {
       static int instanceCounter = 0;

    public int counter = 0;

   
    public IotMaps(){
     
        instanceCounter++;
        counter = instanceCounter;
        
    }
    
    public String  getGpsFile(){
        String IotMaps = "KindleGps"+counter+".txt";
        return IotMaps;
    }
}
