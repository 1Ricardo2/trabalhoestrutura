
package Util;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Animacao {
    private List<BufferedImage> frames;
    private int frameIndex = 0;
    private int varTempo;
    private long antTempo;
    
    public Animacao(int variacaoTempo){
        this.varTempo = variacaoTempo;
        frames= new ArrayList<BufferedImage>();
    
    }
    
    public void update(){
        if(System.currentTimeMillis()-antTempo>varTempo){
        frameIndex++;
        if (frameIndex >=frames.size()) {
            frameIndex = 0;
            }
        antTempo = System.currentTimeMillis();
        } 
    }
    public void addFrame(BufferedImage frame){
        frames.add(frame);
    }
    
    public BufferedImage getFrame(){
    if(frames.size()>0){
        return frames.get(frameIndex);
    }
    return null;
    }
}