package estrutura;

import objetos.Personagem;
import Util.Resource;
//import static estrutura.Janela.SCREEN_WIDTH;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javax.swing.JPanel;
import objetos.Inimigos;
import objetos.ObjChao;
import sun.java2d.pipe.DrawImage;


public class Tela extends JPanel implements Runnable, KeyListener {
    public static final float GRAVITY = 01f;
    public static float GROUNDY; //Meio da tela
    private Thread thread;
    private Personagem person;
   
    private ObjChao chao;
    private List<Arvore> lisArve;
    private List<Arvore> lisArvd;
    private BufferedImage arve, arvd;
    int numDaSeq;
    private Arvore arvoree;
    private Arvore arvored;
    private Inimigos guarda;
    
    public Tela(){
            thread  =   new Thread(this);
            person  =   new Personagem();
            GROUNDY =   (float)512.0;
            
            chao    =   new ObjChao(this);
            guarda  =   new Inimigos();
            
            arve = Resource.getResourceImage("src/resources/sprites/arvores_e.png");
            arvd = Resource.getResourceImage("src/resources/sprites/arvores_d.png");
            lisArve = new ArrayList<Arvore>();
            lisArvd = new ArrayList<Arvore>();
            
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
    
    public void iniciar(){
        thread.start();
    }
    
   
  @Override
   public void run(){  
       while (true) {
           try{ person.update();
                chao.update();
                arvoree.updatee();
                arvored.updated();
                guarda.update();
                repaint();
                Thread.sleep(20);
            }catch (InterruptedException ex) {
              ex.printStackTrace();
            }
        }
    }
   @Override
   public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //g.drawLine((int)GROUNDY, 0, (int)GROUNDY, getWidth());
        chao.draw(g);
        guarda.draw(g);
        for(Arvore arvore: lisArve){
            g.drawImage(arvore.imagem, -290, arvore.posY, null);
       }
        for(Arvore arvore: lisArvd){
            g.drawImage(arvore.imagem, 757, arvore.posY, null);
       }
        person.draw(g);
   }

@Override
public void keyTyped(KeyEvent ke) {
    }

@Override
public void keyPressed(KeyEvent ke) {
    person.mover(ke);
    chao.asd(ke);
    
           int intKey = ke.getKeyCode();
           if (intKey == KeyEvent.VK_ESCAPE){
          System.exit(0);
               
           }

           }


@Override
public void keyReleased(KeyEvent ke) { 
           
    }
    
    private class Arvore{
        private int posY;
        BufferedImage imagem;
        
        public void updatee(){
            for(Arvore arvore: lisArve){
                arvore.posY +=15;}
            Arvore ult = lisArve.get(2);
        
        if( ult.posY > 768){
            ult.posY = lisArve.get(0).posY - arve.getHeight();
            
            lisArve.add(0,ult);
            
            lisArve.remove(lisArve.size()-1);
                }
            }
        public void updated(){
            for(Arvore arvore: lisArvd){
                arvore.posY +=15;}
            
        Arvore ult = lisArvd.get(2);
        
        if( ult.posY > 768){
            ult.posY = lisArvd.get(0).posY - arvd.getHeight();
            
            lisArvd.add(0,ult);
            
            lisArvd.remove(lisArvd.size()-1);
                }
            }
        }
    }
    

