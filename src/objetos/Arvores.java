/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Util.Resource;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Arvores {
    
    
    private List<Arvore> lisArve;
    private List<Arvore> lisArvd;
    private BufferedImage arve, arvd;
    private Arvore arvoree;
    private Arvore arvored;
    int numDaSeq;
    
    public Arvores(){
    
            arve = Resource.getResourceImage("src/resources/sprites/arvores_e.png");
            arvd = Resource.getResourceImage("src/resources/sprites/arvores_d.png");
            lisArve = new ArrayList<>();
            lisArvd = new ArrayList<>();
            
            numDaSeq = 768 / arve.getHeight() + 2;
            
            for (int i = 0; i < numDaSeq; i++) {
                arvoree = new Arvore();
                arvoree.posY  =  i * arve.getHeight();
                arvoree.imagem = arve;
                lisArve.add(arvoree);
                
        }        
            for (int i = 0; i < numDaSeq; i++) {
                arvored = new Arvore();
                arvored.posY  =  i * arvd.getHeight();
                arvored.imagem = arvd;
                lisArvd.add(arvored);
                
        } 
    }
    public void update(){
    //atualização das arvores da esquerda
            for(Arvore arvore: lisArve){
                arvore.posY +=10;}
                Arvore ult = lisArve.get(2);
                    if( ult.posY > 768){
                        ult.posY = lisArve.get(0).posY - arve.getHeight();
                        lisArve.add(0,ult);
                        lisArve.remove(lisArve.size()-1);
        }
    //atualização da arvores da direita    
            for(Arvore arvore: lisArvd){
                arvore.posY +=10;}
                Arvore ult1 = lisArvd.get(2);
                    if( ult1.posY > 768){
                        ult1.posY = lisArvd.get(0).posY - arvd.getHeight();
                        lisArvd.add(0,ult1);
                        lisArvd.remove(lisArvd.size()-1);}
    }
    
    public void draw(Graphics g){
        //for(Arvore arvore: lisArve){
        for (int i=0; i<lisArve.size(); i++) {
            g.drawImage(lisArve.get(i).imagem, -290, lisArve.get(i).posY, null);
       }
        for (int i=0; i<lisArvd.size(); i++) {
            g.drawImage(lisArve.get(i).imagem, 757, lisArve.get(i).posY, null);
       }
    }
    
    
    private class Arvore{
        private int posY;
        BufferedImage imagem;
        
    }
}
