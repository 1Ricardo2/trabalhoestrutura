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
import objetos.Arvores;
import objetos.Inimigos;
import objetos.ObjChao;
import sun.java2d.pipe.DrawImage;


public class Tela extends JPanel implements Runnable, KeyListener {
    public static final float GRAVITY = 01f;
    public static float GROUNDY; //Meio da tela
    private Thread thread;
    private Personagem person;
    private Inimigos guarda;
    private ObjChao chao;
    private Arvores arv;
    
    
    
    public Tela(){
            thread  =   new Thread(this);
            person  =   new Personagem();
            GROUNDY =   (float)512.0;
            chao    =   new ObjChao(this);
            guarda  =   new Inimigos();
            arv     =   new Arvores();
            
    
    }
    
    public void iniciar(){
        thread.start();
    }
    
   
  @Override
   public void run(){  
       while (true) {
           try{ person.update();
                chao.update();
                arv.update();
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
        
        g.fillRect(0, 0, getWidth(), getHeight());
        chao.draw(g);
        arv.draw(g);
        guarda.draw(g);
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
    
    
    }
    

