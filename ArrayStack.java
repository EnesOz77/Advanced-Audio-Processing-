import java.util.EmptyStackException;

public class ArrayStack implements BKStack {
    private int top, count;//declare top and count variable
    private double [] arr;//create the arraystack

    private static int INITIAL_CAPACITY = 100;//initial capacity const declaration

    public ArrayStack(){//constructor that set the array to initial capacitt and top to -1.
        arr = new double[INITIAL_CAPACITY];
        top = -1;
    }

    public static double[] doubleSize(double[] arr){//size doubler method

        int newSize = 2 * arr.length;//get the new size by multiplying 2
        double[] newArr = new double[newSize];//create a new array with new size

        for(int i = 0; i < arr.length;i++){//tranfer all indexes to new array
            newArr[i] = arr[i];
        }
        return newArr;//return new array
    }
    @Override
    public double pop(){//pop the top element in stack
        if(isEmpty()){//check if the array is empty
            throw new EmptyStackException();
        }
        return arr[top];//if not return top which is the top most index of the array
    }
    @Override
    public void push(double data){//push new node into array stack
        if(arr.length - 1 < top){//if the top is greater then the array size then double array size and insert new node to top index
            arr = doubleSize(arr);
            top++;
            arr[top] = data;
        }
        else
            arr[++top] = data;//if not full just insert new node to next index
    }

    @Override
    public double peek(){//check the top element in the array
        if(isEmpty()){// checks if array is empty
            throw new EmptyStackException();
        }
        return arr[top];// returns the top element of the array stack
    }
    @Override
    public boolean isEmpty() {//if empty return true otherwise false
        if(top== -1)
            return true;
        else
            return false;
    }
    @Override
    public int count(){//return the size count of array
        return count + 1;
    }

}
