package tqs;
import java.lang.IllegalStateException;
//completed

/**
 * Hello world!
 *
 */
public class  BoundedStack <T> extends TqsStack <T>
{
    private int maximum_len;
    public boolean isFull(){
        return this.size() == maximum_len;
    }

    public void push(T obj){
        if (this.isFull())
            throw new IllegalStateException();
        super.push(obj);
        
    }
    
    public BoundedStack(int len)
    {
        maximum_len = len;
    }
    
}
