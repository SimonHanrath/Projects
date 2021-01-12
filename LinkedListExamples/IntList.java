package main;

public class IntList {

    public static final int INVALID = Integer.MIN_VALUE;
    
    private IntListNode front; 
    
    public IntList() {
        this.front = null;
    }
    /**
     * Returns true if the list is empty.
     */
    public boolean isEmpty() {
        return this.front == null;
    }
    
    /**
     * Inserts a value at the front of list.
     * @param value The value that is to be inserted. 
     */
    public void addFront(final int value) {
        this.front = new IntListNode(value, this.front);
    }
    
    /**
     * Recursive helper method that traverses through a list inserts a new
     * node at the very end.
     * @param ptr Current list node.
     * @param value The value that is to be inserted.
     */
    private static void addBackHelper(final IntListNode ptr, final int value) {
        if (ptr.hasNext()) {
            addBackHelper(ptr.next, value);
        } else {
            ptr.next = new IntListNode(value);
        }
    }
    
    /**
     * Inserts a value at the end of the list.
     * @param value The value that is to be inserted.
     */
    public void addBack(final int value) {
        if (this.isEmpty()) {
            this.addFront(value);
        } else {
            addBackHelper(this.front, value);
        }
    }
    
    /**
     * Calculates (iteratively) the number of element within
     * the list.
     * @return Number of list elements/nodes.
     */
    public int size() {
        int ctr = 0;
        
        IntListNode ptr = this.front;
        
        while (ptr != null) {
            ctr++;
            ptr = ptr.next;
        }
        
        return ctr;
    }
    
    /**
     * Recursive helper method for get.
     * @param ptr Current list node.
     * @param i Index of the element that is to be returned.
     * @return Value at index i or INVALID.
     */
    private static int getHelper(final IntListNode ptr, int i) {
        if (ptr == null) {
            return INVALID;
        } else if (i == 0) {
            return ptr.value;
        }
        return getHelper(ptr.next, i-1);
    }
    /**
     * Recursive variant of the get method. Returns the i-th element
     * within the list or INVALID if the i-th element does not exist.
     * @param i Index of the element that is to be returned.
     * @return Value at index i or INVALID.
     */
    public int get(final int i) {
        return getHelper(this.front, i);
    }
    
    /**
     * Own implementation of the toString-method. This method will be
     * used automatically whenever an instance of IntList is, e.g., 
     * concatenated with a string.
     */
    @Override
    public String toString() {
        final StringBuilder out = new StringBuilder();
        IntListNode ptr = this.front;
        
        while (ptr != null) {
            out.append(ptr.value);
            if (ptr.hasNext()) {
                out.append(", ");
            }
            ptr = ptr.next;
        }
        
        return out.toString();
    }
        
    // ----------------------------------------------------------------
    // Exercise 1 (a)
    // ----------------------------------------------------------------
    
   
    public int find(final int value) {
        IntListNode ptr = this.front;
        int index = 0;

        while(ptr != null){
            if (ptr.value == value){
                return index;
            }
            ptr = ptr.next;
            index++;
        }
        return -1;
    }


    
    // ----------------------------------------------------------------
    // Exercise 1 (b)
    // ----------------------------------------------------------------
    
    public int min() {
        IntListNode ptr = this.front;
        int min = Integer.MAX_VALUE;

        if(ptr == null){
            return INVALID;
        }

        while(ptr != null){
            if (ptr.value < min){
                min = ptr.value;
            }
            ptr = ptr.next;

        }

        return min;
    }
    
    // ----------------------------------------------------------------
    // Exercise 1 (c)
    // ----------------------------------------------------------------
    
    public int max() {
        IntListNode ptr = this.front;
        int max = Integer.MIN_VALUE;

        if(ptr == null){
            return INVALID;
        }

        while(ptr != null){
            if (ptr.value > max){
                max = ptr.value;
            }
            ptr = ptr.next;

        }

        return max;
    }

    // ----------------------------------------------------------------
    // Exercise 1 (d)
    // ----------------------------------------------------------------

    public int[] asArray() {
        IntListNode ptr = this.front;
        int len = 0;

        while(ptr != null){
            ptr = ptr.next;
            len++;
        }

        int[] arr  = new int[len];
        ptr = this.front;
        int index = 0;

        while(ptr != null){
            arr[index] = ptr.value;
            ptr = ptr.next;
            index++;
        }

        if(index == 0){return new int[]{};}
        return arr;


    }    

    // ----------------------------------------------------------------
    // Exercise 1 (e)
    // ----------------------------------------------------------------

    public void remove(final int i) {
        IntListNode ptr = this.front;

        if(ptr== null) {
            return;
        }


        else if(i==0) {
            this.front = ptr.next;
        }

        else {
            IntListNode next_ptr = ptr.next;

            for(int j = 1;j<i; j++) {
                ptr=next_ptr;
                next_ptr = ptr.next;
            }
            if(next_ptr != null) {
                ptr.next=next_ptr.next;
            }
        }
    }
    
    // ----------------------------------------------------------------
    // Exercise 1 (f)
    // ----------------------------------------------------------------

    public void reverse() {
        IntListNode ptr = this.front;
        IntListNode prev_ptr = null;
        IntListNode next_ptr;

        while(ptr != null){
            next_ptr = ptr.next;
            ptr.next = prev_ptr;
            prev_ptr = ptr;
            ptr = next_ptr;

        }
        this.front = prev_ptr;

    }

}
