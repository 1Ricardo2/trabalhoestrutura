package objetos;


import Util.Resource;
import estrutura.Tela;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Jogo {
    private Personagem person;
    private Inimigos guarda;
    private ObjChao chao;
    private Arvores arv;
    private int indice = 0;
    private BufferedImage scoreback;
    public Jogo(){
            scoreback =  Resource.getResourceImage("src/resources/sprites/back.png");
            person  =   new Personagem();
            chao    =   new ObjChao();
            guarda  =   new Inimigos();
            arv     =   new Arvores();
           
    }
    public void update(){
        person.update();
        chao.update();
        guarda.update();
        arv.update();
        
            
        }
   
    public void draw(Graphics g){
        chao.draw(g);
        arv.draw(g);
        guarda.draw(g);
        person.draw(g);
        g.drawImage(scoreback, 2, 2, 260, 50, null);
        g.setFont(new Font("Arial",2, 30));
        g.setColor(Color.WHITE);
        g.drawString("Pontuação : "+Integer.toString(Personagem.score), 10, 35);
       
       
    }
    public void velocidade(){
        if(person.score>indice){
        ObjChao.vel+=50;
        indice+=500;
            System.out.println(ObjChao.vel);
        }
    }
    
    public void acoes(KeyEvent ke) {
            person.acoes(ke);
            chao.asd(ke);
            
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
               
           }
    }

    public Personagem getPerson() {
        return person;
    }

    public void setPerson(Personagem person) {
        this.person = person;
    }

    public Inimigos getGuarda() {
        return guarda;
    }

    public void setGuarda(Inimigos guarda) {
        this.guarda = guarda;
    }

    public ObjChao getChao() {
        return chao;
    }

    public void setChao(ObjChao chao) {
        this.chao = chao;
    }

    public Arvores getArv() {
        return arv;
    }

    public void setArv(Arvores arv) {
        this.arv = arv;
    }
    

}
