package estrutura;


//import static estrutura.Janela.SCREEN_WIDTH;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import objetos.GameOver;
import objetos.Jogo;
import objetos.Menu;
import objetos.ObjChao;

public class Tela extends JPanel implements Runnable, KeyListener {
    public static final float GRAVITY = 01f;
    private Thread thread;
    private Jogo game;
    private Menu menu;
    private GameOver go;
    public static String estado;
    //valores possiveis: "jogo", "menu", "gameover";
    
    public Tela(){
            thread  =   new Thread(this);
            game    =   new Jogo();
            menu    =   new Menu();
            go      =   new GameOver();
            estado  =   "menu";
    }
    public void iniciar(){
        thread.start();
    }
    
  @Override
   public void run(){
       int fps = 60;
		long msPerFrame = 1000 * 1000000 / fps;
		long lastTime = 0;
		long elapsed;
		
		int msSleep;
		int nanoSleep;

		long endProcessGame;
		long lag = 0;
       while (true) {    
                        game.update();
                        colidir();
                        repaint();
                        endProcessGame = System.nanoTime();
			elapsed = (lastTime + msPerFrame - System.nanoTime());
			msSleep = (int) (elapsed / 1000000);
			nanoSleep = (int) (elapsed % 1000000);
			if (msSleep <= 0) {
				lastTime = System.nanoTime();
				continue;
			}
           try{
               Thread.sleep(msSleep, nanoSleep);
            }catch (InterruptedException ex) {
              ex.printStackTrace();
            }
            lastTime = System.nanoTime();
        }
    }
   
   @Override
   public void paint(Graphics g){
       
       if(estado.equalsIgnoreCase("jogo")){
            game.draw(g);
        }else if(estado.equalsIgnoreCase("menu")){
            menu.draw(g);
        }else if(estado.equalsIgnoreCase("gameover")){
            go.draw(g);
        }
        
   }
   public void colidir(){
   if(estado.equalsIgnoreCase("jogo")){
                            game.update();
                                if(game.getGuarda().getbound().intersects(game.getPerson().getbound())){
                                    estado = "gameover";
                                    game.getGuarda().resetar();
                                    game.getPerson().resetar();
                                    }
                        }
   }
   
   
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    
    
    @Override
    public void keyPressed(KeyEvent ke) {
        if(estado.equalsIgnoreCase("jogo")){
             game.acoes(ke);
        }else if(estado.equalsIgnoreCase("menu")){ 
            menu.acoes(ke);
         }else if(estado.equalsIgnoreCase("gameover")){
            go.acoes(ke);
        }
        
    }

@Override
public void keyReleased(KeyEvent ke) { 
           
    }

}
    

