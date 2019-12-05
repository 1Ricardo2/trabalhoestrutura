
package objetos;

import Util.Resource;
import estrutura.Tela;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class GameOver {
    private BufferedImage fundo;
    private gameOver selecao;
    private int pos;
   
    
    public GameOver(){
        fundo = Resource.getResourceImage("src/resources/sprites/gameover.png");
        selecao = new gameOver();
        selecao.imagem  =  Resource.getResourceImage("src/resources/sprites/selec.png");
        selecao.x = 365;
        selecao.y = 398;
        pos = 0;
    }
    
    //375,399 = sim; 564,399 nao;
    public void draw(Graphics g){
        g.drawImage(fundo, 0, 0, null);
        g.drawImage(selecao.imagem, selecao.x, selecao.y, null);
    }
    
    public void acoes(KeyEvent ke){
        if(pos == 1){
             if(ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A ){
                selecao.x = 365;
                pos = 0;
            }      
     }
            if(pos == 0){
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D ){
                selecao.x = 554;
                pos = 1;
                
            }}
            
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                if (pos == 0) {
                    Tela.estado = "jogo";

                }else if(selecao.x == 554){
                    Tela.estado= "Menu";
                }

            }
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
            }
        
    }
    
    
    private class gameOver{
        private BufferedImage imagem;
        private int x;
        private int y;
    
    }
    
}
