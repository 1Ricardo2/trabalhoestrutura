
package objetos;

import Util.Resource;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Inimigos {
    private BufferedImage Inimigo;
    private int x;
    private int y;
    private Random aleatorio;
    
    public Inimigos(){
        aleatorio = new Random();
        y = 50;
        x = 465;
        Inimigo = Resource.getResourceImage("src/resources/sprites/guarda.png");
    }
    
    public void draw(Graphics g){
        g.drawImage(Inimigo,x,y,null);
    }
    public void update(){
        int i = aleatorio.nextInt(3);
        y += 15;
        if(y>768){
            y = -100;
          System.out.println(i);
        switch(i){
            case 0:  x = 302;
            break;
            
            case 1:  x = 495;
            break;
            
            case 2:  x = 688;
            break;
            
            default: x = 495;
            break;
        }
        }
        
    }
}
