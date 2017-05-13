package system;

import org.w3c.dom.ranges.RangeException;

import java.util.ArrayList;

/**
 * Created by Alexander Perham on 2017-05-13.
 */
public class Game {
    private ArrayList<Frame> frames;
    private final int MAX_FRAMES = 10;
    
    public Game(){
        frames = new ArrayList<>(MAX_FRAMES);
    }
    
    public boolean insertFrame(Frame f){
        boolean success = frames.add(f);
        if(frames.size() > 10){
            throw new RangeException((short) 1, "Invalid range");
        }
        return success;
    }
    
    public int getScore(){
        int totalScore = 0;
        boolean strike = false;
        for(int i = 0; i < frames.size(); i++) {
            if(isStrike(i) && i < MAX_FRAMES){
                totalScore += 10 + frames.get(i+1).getSum();
                strike = true;
            }
            if(!strike) {
                totalScore += frames.get(i).getSum();
            }
            strike = false;
        }
        return totalScore;
    }
    
    public boolean isStrike(int pos){
        return frames.get(pos).getArr(0) == 10;
    }
}
