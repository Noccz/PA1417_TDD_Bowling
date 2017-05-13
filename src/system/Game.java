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
}
