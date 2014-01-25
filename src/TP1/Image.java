/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vogel3u
 */
public class Image {
    protected String nom;
    List<String> listRouge;//=new ArrayList<String>();
    List<String> listBleu;//=new ArrayList<String>();
    List<String> listVert;//=new ArrayList<String>();
    List<String> listGris;
    
    
    public Image(String nom_fich){
        this.nom=nom_fich;
        this.listRouge=new ArrayList<String>();
        this.listBleu=new ArrayList<String>();
        this.listVert=new ArrayList<String>();
        this.listGris=new ArrayList<String>();
    }
    
    public String getMax(List<String> list){
        double max = Double.parseDouble(list.get(0));
        System.out.println("MAX = "+max);
        for(String s:list){
            if(!(s.isEmpty())){
                if(Double.parseDouble(s)>max){
                    max=Double.parseDouble(s);
                }
            }
        }
        return String.valueOf(max);
    }
    public void CreationImageRouge(){
        try {
			FileWriter fw = new FileWriter ("rouge.ppm");
			//BufferedWriter bw = new BufferedWriter (fw);
                        //PrintWriter fichierSortie = new PrintWriter (bw);
                        fw.write("P3");
                        fw.write("\r\n"); 
                        fw.write("# CREATOR: GIMP PNM Filter Version 1.1");
                        fw.write("\r\n"); 
                        fw.write("410 310");
                        fw.write("\r\n"); 
                        fw.write(this.getMax(listRouge));
                        fw.write("\r\n");
                        for(String bw:this.listRouge){
                            //fichierSortie.println (bw+"\n test de lecture et écriture !!");
                            fw.write(bw);
                            fw.write("\r\n");
                            fw.write("0");
                            fw.write("\r\n");
                            fw.write("0");
                            fw.write("\r\n");
                        }
			  
			fw.close();
			System.out.println("Le fichier rouge  a été créé!"); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}		
        
    }
    
    public void CreationImageVerte(){
        try {
			FileWriter fw = new FileWriter ("vert.ppm");
			//BufferedWriter bw = new BufferedWriter (fw);
                        //PrintWriter fichierSortie = new PrintWriter (bw);
                        fw.write("P3");
                        fw.write("\r\n"); 
                        fw.write("# CREATOR: GIMP PNM Filter Version 1.1");
                        fw.write("\r\n"); 
                        fw.write("410 310");
                        fw.write("\r\n"); 
                        fw.write(this.getMax(listVert));
                        fw.write("\r\n");
                        for(String bw:this.listVert){
                            //fichierSortie.println (bw+"\n test de lecture et écriture !!");
                            fw.write("0");
                            fw.write("\r\n");
                            fw.write(bw);
                            fw.write("\r\n");
                            fw.write("0");
                            fw.write("\r\n");
                        }
			  
			fw.close();
			System.out.println("Le fichier vert  a été créé!"); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}		
        
    }
    
    public void CreationImageBleue(){
        try {
			FileWriter fw = new FileWriter ("bleue.ppm");
			//BufferedWriter bw = new BufferedWriter (fw);
                        //PrintWriter fichierSortie = new PrintWriter (bw);
                        fw.write("P3");
                        fw.write("\r\n"); 
                        fw.write("# CREATOR: GIMP PNM Filter Version 1.1");
                        fw.write("\r\n"); 
                        fw.write("410 310");
                        fw.write("\r\n"); 
                        fw.write(this.getMax(listBleu));
                        fw.write("\r\n");
                        for(String bw:this.listBleu){
                            //fichierSortie.println (bw+"\n test de lecture et écriture !!");
                            fw.write("0");
                            fw.write("\r\n");
                            fw.write("0");
                            fw.write("\r\n");
                            fw.write(bw);
                            fw.write("\r\n"); 
                            
                        }
			  
			fw.close();
			System.out.println("Le fichier bleu  a été créé!"); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}		
        
    }
    
    public void CreationImageGrise(){
        try {
                        
			FileWriter fw = new FileWriter ("grise.pgm");
			//BufferedWriter bw = new BufferedWriter (fw);
                        //PrintWriter fichierSortie = new PrintWriter (bw);
                        fw.write("P2");
                        fw.write("\r\n"); 
                        fw.write("# CREATOR: GIMP PNM Filter Version 1.1");
                        fw.write("\r\n"); 
                        fw.write("410 310");
                        fw.write("\r\n"); 
                        fw.write(this.getMax(this.listGris));
                        fw.write("\r\n");
                        for(String bw:this.listGris){
                            //fichierSortie.println (bw+"\n test de lecture et écriture !!");
                            fw.write(bw);
                            fw.write("\r\n"); 
                        }
			  
			fw.close();
			System.out.println("Le fichier gris  a été créé!"); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}		
        
        
    }
    
    public void CreationImageNegatif(){
        try {
                        
			FileWriter fw = new FileWriter ("negatif.pgm");
			//BufferedWriter bw = new BufferedWriter (fw);
                        //PrintWriter fichierSortie = new PrintWriter (bw);
                        fw.write("P2");
                        fw.write("\r\n"); 
                        fw.write("# CREATOR: GIMP PNM Filter Version 1.1");
                        fw.write("\r\n"); 
                        fw.write("410 310");
                        fw.write("\r\n");
                        String maxR=this.getMax(listRouge);
                        String maxV=this.getMax(listVert);
                        String maxB = this.getMax(listBleu);
                        String max;
                        if(Double.parseDouble(maxR)>Double.parseDouble(maxV)){
                            max=maxR;
                        }
                        else max=maxV;
                        if(Double.parseDouble(max)<Double.parseDouble(maxB)){
                            max=maxB;
                        }
                        
                        fw.write(max);
                        fw.write("\r\n");
                        int i=0;
                        while(i<this.listGris.size()){
                            //fichierSortie.println (bw+"\n test de lecture et écriture !!");
                           
//                            fw.write(String.valueOf(255-Integer.parseInt(listRouge.get(i))));
//                            fw.write("\r\n");
//                            fw.write(String.valueOf(255-Integer.parseInt(listVert.get(i+1))));
//                            fw.write("\r\n"); 
//                            fw.write(String.valueOf(255-Integer.parseInt(listBleu.get(i+2))));
//                            fw.write("\r\n");
//                            i=i+3;
                            fw.write(String.valueOf(255-Double.parseDouble(listGris.get(i))));
                            fw.write("\r\n");
                            i++;
                        }
			  
			fw.close();
			System.out.println("Le fichier négatif  a été créé!"); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}		
        
        
    }
    
    public void CreationImageReduite(){
        ArrayList<String> listReduite= new ArrayList<String>();
        try {
                        
			FileWriter fw = new FileWriter ("reduite.ppm");
		        fw.write("P3");
                        fw.write("\r\n"); 
                        fw.write("# CREATOR: GIMP PNM Filter Version 1.1");
                        fw.write("\r\n"); 
                        fw.write("205 155");
                        fw.write("\r\n");
                        fw.write("255");
                        fw.write("\r\n");
                        int j =0;
                        int i = 0;
                        while(j<310){
                            while(i<410){
                                if((i==0)&&(j==0)){
                                    System.out.println(listRouge.get(i+410*j));
                                    System.out.println(listRouge.get(i+410*j));
                                }
                                    
                                fw.write(String.valueOf((Integer.parseInt(listRouge.get(i+410*j))+Integer.parseInt(listRouge.get(i+1+410*j))+Integer.parseInt(listRouge.get(i+410*(j+1)))+Integer.parseInt(listRouge.get(i+1+410*(j+1))))/4));
                                fw.write("\r\n");
                                fw.write(String.valueOf((Integer.parseInt(listVert.get(i+410*j))+Integer.parseInt(listVert.get(i+1+410*j))+Integer.parseInt(listVert.get(i+410*(j+1)))+Integer.parseInt(listVert.get(i+1+410*(j+1))))/4));
                                fw.write("\r\n");
                                fw.write(String.valueOf((Integer.parseInt(listBleu.get(i+410*j))+Integer.parseInt(listBleu.get(i+1+410*j))+Integer.parseInt(listBleu.get(i+410*(j+1)))+Integer.parseInt(listBleu.get(i+1+410*(j+1))))/4));
                                fw.write("\r\n");
                                i=i+2;
                            }
                            j=j+2;
                            i=0;
                        }
			  
			fw.close();
			System.out.println("Le fichier réduit  a été créé!"); 
		}
		catch (Exception e){
			System.out.println(e.toString());
		}		
        
    }
    
    public void Creation(){
        this.CreationImageRouge();
        this.CreationImageVerte();
        this.CreationImageBleue();
        this.CreationImageGrise();
        this.CreationImageNegatif();
        this.CreationImageReduite();
    }
    void lireFichier(){
        int i=0;
        int j=0;
        try{
//			InputStream ips=new FileInputStream(this.nom); 
//			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(new FileReader(this.nom));
			String ligne;
			while ((ligne=br.readLine())!=null){
				if(i<4){
                                                                      
                                }
                                else if(!(ligne.isEmpty())){
                                    if(i%3==0){
//                                        System.out.println("BLEU");
                                        this.listBleu.add(ligne);
                                        
                                        
                                        String ng=String.valueOf(0.299 * Integer.parseInt(listRouge.get(j)) + 0.587 * Integer.parseInt(listVert.get(j)) + 0.114 * Integer.parseInt(listBleu.get(j)));
                                        this.listGris.add(ng);
                                        j++;
                                    }
                                    else if(i%3==1){
//                                        System.out.println("ROUGE");
                                        this.listRouge.add(ligne);
                                    }
                                    else if(i%3==2){
//                                        System.out.println("VERT");
                                        this.listVert.add(ligne);
                                    }                                        
                                        
                                }
                                i++;
                                
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
    }
    
}
