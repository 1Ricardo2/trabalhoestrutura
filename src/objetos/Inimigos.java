
package objetos;

import Util.Resource;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Inimigos {
    private BufferedImage Inimigo;
    private int x;
    private int y;
    private Random aleatorio;
    private Rectangle col;
    
    
    public Inimigos(){
        aleatorio = new Random();
        y = -500 ;
        x = 465;
        Inimigo = Resource.getResourceImage("src/resources/sprites/guarda.png");
        col = new Rectangle();
        
    }
    
    public void draw(Graphics g){
        g.drawImage(Inimigo,x,y,null);
    }
    
    public void update(){
        int i = aleatorio.nextInt(3);
        y += 10;
        if(y>768){
            y = -100;
          System.out.println(i);
        switch(i){
            case 0:  x = 292;
            break;
            
            case 1:  x = 465;
            break;
            
            case 2:  x = 648;
            break;
            
            default: x = 465;
            break;
        }
        }
       col.x = x;
       col.y = y;
       col.width = Inimigo.getWidth();
       col.height = Inimigo.getHeight();
       
       
        
    }
    public Rectangle getbound(){
            return col;
    }

    public BufferedImage getInimigo() {
        return Inimigo;
    }

    public void setInimigo(BufferedImage Inimigo) {
        this.Inimigo = Inimigo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
