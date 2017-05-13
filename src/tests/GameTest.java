package tests;

import org.junit.Before;
import org.junit.Test;
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
        for(int i = 0; i < 10; i++)
            assertEquals(true, game.insertFrame(new Frame(1, 2)));
    }
    
    
}
