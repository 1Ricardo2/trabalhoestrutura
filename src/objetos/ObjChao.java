package objetos;

import Util.Resource;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class ObjChao {
        private List<ImgChao> lisImg;
        private BufferedImage chao1, chao2, chao3;
        int numDaSeq;
        int vel = -10;
       
        
    public ObjChao(){
            chao1 = Resource.getResourceImage("src/resources/sprites/grass1.png");
            lisImg = new ArrayList<>();
            numDaSeq = 768 / chao1.getHeight() + 2;
            
        for (int i = 0; i < numDaSeq; i++) {
                ImgChao imgChao = new ImgChao();
                imgChao.posY  =  i * chao1.getHeight();
                imgChao.imagem = chao1;
                lisImg.add(imgChao);
        }        
    }
        
    
    
    public void draw(Graphics g){
       for (int i=0; i<lisImg.size(); i++) {
            g.drawImage(lisImg.get(i).imagem, 252, lisImg.get(i).posY, null);
       }
       
    }
    
    public void update(){
        for(ImgChao imgChao: lisImg){
            
            imgChao.posY -=vel;
            
        }
        
        ImgChao ult = lisImg.get(8);
        
        if(ult.posY > 768){
            
            ult.posY = lisImg.get(0).posY - chao1.getHeight();
            
            lisImg.add(0,ult);
            
            lisImg.remove(lisImg.size()-1);
            
            
           
        }
      
    }
    
   
    
    public void asd(KeyEvent ke){
      if(ke.getKeyCode() == KeyEvent.VK_UP){
                for(ImgChao imgChao: lisImg){
            imgChao.posY -= vel;
            
                }
                
                
            }  
      if(ke.getKeyCode() == KeyEvent.VK_DOWN){
                for(ImgChao imgChao: lisImg){
            imgChao.posY += vel;
            
                }
                
                
            }   
      if(ke.getKeyCode() == KeyEvent.VK_O){
               vel++;
                System.out.println(vel);
                
            }  
      if(ke.getKeyCode() == KeyEvent.VK_L){
               vel--;
                System.out.println(vel);
                
            }
      
    }
            
    
    private class ImgChao{
        private int posY;
        BufferedImage imagem;
    }
}
