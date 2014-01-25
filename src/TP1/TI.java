/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TP1;

/**
 *
 * @author Thomas
 */
public class TI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Image i1=new Image("C:\\Users\\Thomas\\Dropbox\\Master\\S8\\TI\\Exemples_TI_S1\\arbreASCII.ppm");
        i1.lireFichier();
        i1.Creation();
        System.out.println(i1.listRouge.size());
        System.out.println(i1.listBleu.size());
        System.out.println(i1.listVert.size());

        //System.out.println(i1.getMax(i1.listRouge));
        
        
        
    }
    
}
