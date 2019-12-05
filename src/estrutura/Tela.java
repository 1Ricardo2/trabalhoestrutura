package estrutura;


//import static estrutura.Janela.SCREEN_WIDTH;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import objetos.GameOver;
import objetos.Jogo;
import objetos.Menu;

public class Tela extends JPanel implements Runnable, KeyListener {
    public static final float GRAVITY = 01f;
    private Thread thread;
    private Jogo game;
    private Menu menu;
    //private GameOver go;
    public static String estado;
    //valores possiveis: "jogo", "menu", "gameover";
    
    public Tela(){
            thread  =   new Thread(this);
            game    =   new Jogo();
            menu    =   new Menu();
           // go      =   new GameOver();
            estado  =   "menu";
    }
    public void iniciar(){
        thread.start();
    }
    
  @Override
   public void run(){
       while (true) {
           try{ game.update();
           
                /*if(estado.equalsIgnoreCase("jogo")){*/
                    game.update();
                        if(game.getGuarda().getbound().intersects(game.getPerson().getbound())){
                            //estado = "menu";
                            System.exit(0);
                            }
//                }
                
                
                repaint();
                Thread.sleep(20);
            }catch (InterruptedException ex) {
              ex.printStackTrace();
            }
        }
    }
   
   @Override
   public void paint(Graphics g){
       
       game.draw(g);
       /*if(estado.equalsIgnoreCase("jogo")){
            game.draw(g);
        }else if(estado.equalsIgnoreCase("menu")){
            menu.draw(g);
        }else{
        go.draw(g);
        }*/
        
   }
   
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    
    
    @Override
    public void keyPressed(KeyEvent ke) {
        /*if(estado.equalsIgnoreCase("jogo")){
             game.acoes(ke);
        }else if(estado.equalsIgnoreCase("menu")){ 
            menu.acoes(ke);
         }else{
            go.acoes(ke);
        }*/
        game.acoes(ke);
    }

@Override
public void keyReleased(KeyEvent ke) { 
           
    }

}
    

