import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.EmptyStackException;

public class ListStack implements BKStack,Iterable<Double> {
    private ListStackNode top;//declare the node type top.
    private int size, count;

    public ListStack(){//constructor which initializes top and size to 0 and null.
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty(){//method designed to check if list is empty then returns true or false accordingly
        return top == null;
    }

    @Override
    public int count(){//returns the number of element inside the stack
        return size;
    }

    @Override
    public void push(double data){
        ListStackNode newNode = new ListStackNode(data);// create the new node with the data
        if (top == null) {//if empty make newnode top
            top = newNode;
        } else {//if prior node exsists then make previous top and set top.next to newnode and reasign top to newnode
            newNode.prev = top;
            top.next = newNode;
            top = newNode;
        }
        size++;//increase size and count of modification
        count++;
    }

    @Override
    public double pop(){
        double value;
        if(isEmpty()){
            throw new EmptyStackException();
        }
        value = top.data;
        if (top.prev != null) {//if the previous isnt null then make top equal to prev.
            top = top.prev;
            top.next = null;
        } else {//if previous is null it means no element therefore initiate both top to null
            top = null;
        }
        size--;
        count++;
        return value;

    }
    @Override
    public double peek() {
        if (isEmpty()) {
            throw new EmptyStackException();//if empty throw empty exception if not then just return top
        }
        return top.data;
    }
    @Override
    public Iterator<Double> iterator() {//iterator clase in order to iterate through stack which includes functions such as hasnext and next
        return new Iterator<Double>() {
            private ListStackNode current = top;//declare current to the top of the stack
            private final int expectedModCount = count;// make the mod count equal to count

            @Override
            public boolean hasNext() {//return if there is a next node
                if (expectedModCount != count) {//if mod count and count dont equal throw exception
                    throw new ConcurrentModificationException();
                }
                return current != null;//if mod count equal then return that the current is not null
            }

            @Override
            public Double next() {//return the data of next
                double value;//create the double for result
                if (current == null) {// if stack empty throw exceptioon
                    throw new EmptyStackException();
                }
                if (expectedModCount != count) {//if counts dont match throw exception
                    throw new ConcurrentModificationException();
                }
                value = current.data;// save the data into the value of node
                current = current.next;// then point next for current
                return value;//return the value of data.
            }
        };
    }
}
