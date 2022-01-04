class MyStack {
    Queue<Integer> stk;//emulates a stack
    Queue<Integer> buffer; //do as its name suggests.
    int top; //records top

    public MyStack() {
        stk = new ArrayDeque<Integer>(); //a queue of [1,2,3,4,5] that is supposed to emulate a stack
        buffer = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        stk.offer(x);
        top = x;
    }
    
    public int pop() {
        int return_value = -1;
        while (stk.size() > 1)
        {
            buffer.offer(stk.poll());
        }
        return_value = stk.poll();
        while(!buffer.isEmpty())
        {
            top = buffer.poll();
            stk.offer(top);
            
        }
        
        return return_value;
        
    }
    
    public int top() {
       
        return top;
        
    }
    
    public boolean empty() {
        return stk.isEmpty();
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */