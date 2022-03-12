package tqs;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private Stack<Integer> s ;

    @BeforeEach 
    public void initiate()
    {

        this.s = new Stack<Integer>();
    }
    @AfterEach 
    public void clear()
    {

        s = null;
    }

    @DisplayName("Test empty on construction")
    @Test
    public void empty_on_construction()
    {

        assertEquals(  true , s.isEmpty());
    }

    @DisplayName("Test n pushes => size n")
    @Test
    public void n_pushes()
    {
        assertEquals(  true , s.isEmpty());
        s.push(1);
        s.push(1);
        s.push(5);
        s.push(10);
        assertEquals(  false , s.isEmpty());

        assertEquals(  4 , s.size());

    }
    @DisplayName("Test push then peek")
    @Test
    public void push_peek()
    {
        s.push(10);
        int len = s.size();
        assertEquals(  10 , s.peek());

        assertEquals(  len , s.size());


    }


}
