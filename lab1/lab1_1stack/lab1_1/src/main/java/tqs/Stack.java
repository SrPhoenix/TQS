package tqs;
import java.util.ArrayList; // import the ArrayList class

/**
 * Hello world!
 *
 */
public class  Stack <T>
{
    private ArrayList<T> stack= new ArrayList<T>(); // Create an ArrayList T

    public T pop(){
        return stack.remove(stack.size() -1 );
    }

    public T peek(){
        return stack.get(stack.size() -1 );
    }
    public int size(){
        return stack.size();
    }
    public boolean isEmpty(){
        return stack.size() == 0;
    }

    public void push(T obj){
        stack.add(obj);
        //return "test add";
    }

    
    public Stack()
    {

    }
    
}
