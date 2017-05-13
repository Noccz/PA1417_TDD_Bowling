package system;

import org.w3c.dom.ranges.RangeException;

import java.util.ArrayList;

/**
 * Created by Alexander Perham on 2017-05-13.
 */
public class Frame {
    private ArrayList<Integer> pins;
    
    public Frame(int val1, int val2){
        if(val1 < 0 || val2 < 0){
            throw new RangeException((short) 1, "Invalid range");
        }
        
        int sum = val1 + val2;
        
        if(sum > 10){
            throw new RangeException((short) 1, "Invalid range");
        }
        
        pins = new ArrayList<>(2);
        pins.add(0, val1);
        pins.add(1, val2);
    }
    
    public int getArr(int pos){
        return pins.get(pos);
    }
    
    public int getSum(){
        return pins.get(0) + pins.get(1);
    }
}
