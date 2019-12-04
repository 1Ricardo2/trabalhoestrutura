/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Util.Resource;
import estrutura.Tela;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;




public class Menu {
    private BufferedImage menu;
    
    
    public Menu(){
    menu = Resource.getResourceImage("src/resources/sprites/Logo_tela1.png");
    
    }
    
    public void draw(Graphics g){
    g.drawImage(menu, 0, 0, null);
       
    }
    
    public void acoes(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_ENTER){
            Tela.estado = "jogo";
            System.out.println("enter");
        }
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
               
           }
    }
    
    
}
