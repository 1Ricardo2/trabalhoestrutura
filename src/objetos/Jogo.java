package objetos;


import estrutura.Tela;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Jogo {
    private Personagem person;
    private Inimigos guarda;
    private ObjChao chao;
    private Arvores arv;
    
    
    public Jogo(){
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
