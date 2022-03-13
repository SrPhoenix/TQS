package tqs;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private TqsStack<Integer> s ;

    private BoundedStack<Integer> bs ;

    @BeforeEach 
    public void initiate()
    {

        this.s = new TqsStack<Integer>();
        this.bs = new BoundedStack<Integer>(4);
    }
    @AfterEach 
    public void clear()
    {

        this.s = null;
        this.bs = null;
    }

    //a)
    @DisplayName("Test empty on construction")
    @Test
    public void empty_on_construction()
    {

        assertEquals(  true , s.isEmpty());
    }

    //b)
    @DisplayName("Test size 0 on construction")
    @Test
    public void size_0_on_construction()
    {

        assertEquals(  0 , s.size());
    }

    //c)
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

    //d)
    @DisplayName("Test push then pops")
    @Test
    public void push_pop()
    {
        s.push(10);
        
        assertEquals(  10 , s.pop());

    }

    //e)
    @DisplayName("Test push then peek")
    @Test
    public void push_peek()
    {
        s.push(10);
        int len = s.size();
        assertEquals(  10 , s.peek());

        assertEquals(  len , s.size());


    }

    //f)
    @DisplayName("if the size is n, then after n pops, the stack is empty and has a size 0")
    @Test
    public void len_pops ()
    {
        int len = s.size();
        for (int i = 0; i< len; i++) {
            s.pop();
        }
        assertEquals(  true , s.isEmpty());
        assertEquals(  0 , s.size());

    }

    //g)
    @Test
    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    public void popFromEmpyReturnsNoSuchElementException (){
        while (s.size() != 0){
            s.pop();
        }
        assertEquals(  true , s.isEmpty());
        assertThrows(NoSuchElementException.class, () -> {s.pop();});
    }

    //h)
    @Test
    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    public void peekFromEmpyReturnsNoSuchElementException (){
        while (s.size() != 0){
            s.pop();
        }
        assertEquals(  true , s.isEmpty());
        assertThrows(NoSuchElementException.class, () -> {s.peek(); });
    }

    //i)
    @Test
    @DisplayName("bounded stacks only:pushing onto a full stack does throw an IllegalStateException")
    public void full_stack_throw_IllegalStateException(){
        assertEquals(  true , bs.isEmpty());
        while ( ! bs.isFull() )
            bs.push(1);
        assertEquals(  true , bs.isFull());
        assertThrows(IllegalStateException.class, () -> {bs.push(10);});
    }

}
