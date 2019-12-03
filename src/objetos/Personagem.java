package objetos;

import Util.Animacao;
import Util.Resource;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import static estrutura.Tela.GROUNDY;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Personagem {
    //private float x = GROUNDY;
    private float x = 495;
    private float y = 550;
    private float speedY = 0;
    private Animacao PersonRun;
    private int pos = 2;
   
   
public Personagem(){
    PersonRun = new Animacao(200);
    PersonRun.addFrame(Resource.getResourceImage("src/resources/sprites/Chrono_run_balance1.png"));
    PersonRun.addFrame(Resource.getResourceImage("src/resources/sprites/Chrono_run_balance2.png"));
    
    
   }
   
public void update(){
    PersonRun.update();
       /*
        if( x >= GROUNDY -65){
            speedY = 0;
            x = GROUNDY - 65;
        }else{
            speedY+=0.5;
            x+=speedY;
            }
    */
   }

   public void draw(Graphics g){
       
        g.setColor(Color.black);
        //coordenadas x, coordenadas x, largura, altura
        g.drawRect((int) getX()  ,(int) getY()  ,PersonRun.getFrame().getWidth()  ,PersonRun.getFrame().getHeight());
        g.drawImage(PersonRun.getFrame(),(int) x,(int) y,  null);
       
    }
   
   
    /*
   
    public void jump(){
        speedY = -10;
        x += speedY;
        }
    
    */
   public void mover(KeyEvent ke){
            if(pos!=1){
             if(ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A ){
                x-=193;
                pos-=1;
                
            }      
     }
            if(pos!=3){
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D ){
                x+=193;
                pos+=1;
                
            }
    }
            
    if(ke.getKeyCode() == KeyEvent.VK_G){
             System.out.println(x);
     }
       
   }
   
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getSpeedY() {
        return speedY;
    }
    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }


   
}
