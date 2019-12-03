package estrutura;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Janela extends JFrame {
        public static final int SCREEN_WIDTH = 1024;
        private Tela telaDeJogo;

    public Janela(){
        super("Java T-Rex game");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(0, 0);
        setSize(SCREEN_WIDTH, 768);
        telaDeJogo = new Tela();
        add(telaDeJogo);
	addKeyListener(telaDeJogo);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       
    }
    public void iniciar(){
        telaDeJogo.iniciar();
    }
    
    public static void main(String[] args){
       Janela j1 =  new Janela();
       j1.setVisible(true);
       j1.iniciar();
      
    }
}
 

