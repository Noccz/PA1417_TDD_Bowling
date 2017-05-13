package tests;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ranges.RangeException;
import system.Frame;
import system.Game;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alexander Perham on 2017-05-13.
 */
public class GameTest {
    private Game game;
    
    @Before
    public void setup(){
        game = new Game();
    }
    
    @Test
    public void insertFrames_ValidInsertAmount(){
        for(int i = 0; i < 10; i++) {
            assertEquals(true, game.insertFrame(new Frame(1, 2)));
        }
    }
    
    @Test(expected = RangeException.class)
    public void insertFrames_InsertAmountTooHigh(){
        for(int i = 0; i < 11; i++) {
            assertEquals(true, game.insertFrame(new Frame(1, 2)));
        }
    }
    
    @Test
    public void getScore_TotalScoreOfGame(){
        game.insertFrame(new Frame(1, 5));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(2, 6));
        
        assertEquals(81, game.getScore());
    }
}
