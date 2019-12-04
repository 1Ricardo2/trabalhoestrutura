
package objetos;

import Util.Resource;
import estrutura.Tela;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class GameOver {
    private gameOver fundo;
    private gameOver selecao;
    private int pos;
   
    
    public GameOver(){
    fundo.imagem    =  Resource.getResourceImage("src/resources/sprites/gameover.png");
    selecao.imagem  =  Resource.getResourceImage("src/resources/sprites/selec.png");
    fundo.x = 0;
    fundo.y = 0;
    selecao.x = 375;
    selecao.y = 499;
    pos = 0;
    }
    
    
    //375,399 = sim; 564,399 nao;
    public void draw(Graphics g){
        g.drawImage(fundo.imagem, fundo.x, fundo.y, null);
        g.drawImage(selecao.imagem, selecao.x, selecao.y, null);
    }
    
    public void acoes(KeyEvent ke){
        if(pos == 0){
             if(ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A ){
                selecao.x = 375;
                pos = 0;
            }      
     }
            if(pos == 1){
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D ){
                selecao.x = 564;
                pos = 1;
                
            }
        if(ke.getKeyCode() == KeyEvent.VK_ENTER){
            if (pos == 0) {
                Tela.estado = "jogo";
                
            }else{
                Tela.estado= "Menu";
            }
            
        }
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
               
            }
        }
    }
    
    
    private class gameOver{
        private BufferedImage imagem;
        private int x;
        private int y;
    
    }
    
}
