package tests;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ranges.RangeException;
import system.Frame;

import static org.junit.Assert.assertEquals;


/**
 * Created by Alexander Perham on 2017-05-13.
 */
public class FrameTest {
    private Frame frame;
    
    @Before
    public void setup(){
        frame = new Frame(3, 6);
    }
    
    @Test
    public void testConstructor(){
        assertEquals(3, frame.getArr(0));
        assertEquals(6, frame.getArr(1));
    }
    
    @Test(expected = RangeException.class)
    public void testConstructor_InvalidNegativeRange(){
        new Frame(-10, -10);
    }
    
    @Test(expected = RangeException.class)
    public void testConstructor_InvalidPositiveRange(){
        new Frame(40, 20);
    }
    
    @Test(expected = RangeException.class)
    public void testConstructor_BadValuesValidSum(){
        new Frame(-20, 20);
    }
    
    @Test
    public void getScore_ValidValues(){
        assertEquals(9, frame.getScore());
    }
}
