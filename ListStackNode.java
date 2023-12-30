public class ListStackNode {
     public double data;//data type double
     public ListStackNode next;//node type next
     public ListStackNode prev;//node type prev

     public ListStackNode(double value) {//constructor for empty parameter which initializes new node with nulls and the value given
          this(value, null,null);
     }

     public ListStackNode(double data, ListStackNode next, ListStackNode prev) {//constructor that initializes all variables according to parameter
          this.data = data;
          this.next = next;
          this.prev = prev;
     }

     public double getData(){//getter for data
          return data;
     }

     public void setData(double data){//setter for data
          this.data = data;
     }
}


