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
    
    @Test
    public void isStrike_StrikeInput(){
        game.insertFrame(new Frame(10, 0));
        assertEquals(true, game.isStrike(0));
    }
    
    @Test
    public void isStrike_NonStrikeInput(){
        game.insertFrame(new Frame(5, 3));
        assertEquals(false, game.isStrike(0));
    }
    
    @Test
    public void getScore_RecognizeStrike(){
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(2, 6));
    
        assertEquals(94, game.getScore());
    }
    
    @Test
    public void isSpare_SpareInput(){
        game.insertFrame(new Frame(7, 3));
        assertEquals(true, game.isSpare(0));
    }
    
    @Test
    public void isSpare_NonSpareInput(){
        game.insertFrame(new Frame(5, 1));
        assertEquals(false, game.isSpare(0));
    }
    
    @Test
    public void getScore_RecognizeSpare(){
        game.insertFrame(new Frame(1, 9));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(2, 6));
    
        assertEquals(88, game.getScore());
    }
    
    @Test
    public void getScore_StrikeFollowedBySpare(){
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(4, 6));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(2, 6));
    
        assertEquals(103, game.getScore());
    }
    
    @Test
    public void getScore_StrikeFollowedByAnotherStrike(){
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(2, 6));
        
        assertEquals(112, game.getScore());
    }
    
    @Test
    public void getScore_SpareFollowedByAnotherSpare(){
        game.insertFrame(new Frame(8, 2));
        game.insertFrame(new Frame(5, 5));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(2, 6));
        
        assertEquals(98, game.getScore());
    }
    
    @Test
    public void getScore_SpareAsLastFrame(){
        game.insertFrame(new Frame(1, 5));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(2, 8, 7));
        
        assertEquals(90, game.getScore());
    }
    
    @Test
    public void getScore_SpareAsLastFrame2(){
        game.insertFrame(new Frame(1, 5));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(2, 8));
        
        assertEquals(83, game.getScore());
    }
    
    @Test
    public void getScore_SpareAsLastFrame3(){
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(2, 8));
        
        assertEquals(19, game.getScore());
    }
    
    @Test
    public void getScore_StrikeAsLastFrame(){
        game.insertFrame(new Frame(1, 5));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(10, 7, 2));
        
        assertEquals(92, game.getScore());
    }
    
    @Test
    public void getScore_StrikeAsLastFrame2(){
        game.insertFrame(new Frame(1, 5));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(10, 0));
        
        assertEquals(83, game.getScore());
    }
    
    @Test
    public void getScore_StrikeAsLastFrame3(){
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(10, 0));
        
        assertEquals(19, game.getScore());
    }
    
    @Test
    public void getScore_StrikeAsLastAndSecondLastFrame(){
        game.insertFrame(new Frame(1, 5));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(10, 7, 2));
        
        assertEquals(110, game.getScore());
    }
    
    @Test
    public void getScore_BonusIsStrike(){
        game.insertFrame(new Frame(1, 5));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(3, 6));
        game.insertFrame(new Frame(4, 4));
        game.insertFrame(new Frame(5, 3));
        game.insertFrame(new Frame(3, 3));
        game.insertFrame(new Frame(4, 5));
        game.insertFrame(new Frame(8, 1));
        game.insertFrame(new Frame(2, 8, 10));
        
        assertEquals(93, game.getScore());
    }
    
    @Test
    public void getScore_PerfectGame(){
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(10, 10, 10));
        
        assertEquals(300, game.getScore());
    }
    
    @Test
    public void getScore_RealGame(){
        game.insertFrame(new Frame(6, 3));
        game.insertFrame(new Frame(7, 1));
        game.insertFrame(new Frame(8, 2));
        game.insertFrame(new Frame(7, 2));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(6, 2));
        game.insertFrame(new Frame(7, 3));
        game.insertFrame(new Frame(10, 0));
        game.insertFrame(new Frame(8, 0));
        game.insertFrame(new Frame(7, 3, 10));
        
        assertEquals(135, game.getScore());
    }
}