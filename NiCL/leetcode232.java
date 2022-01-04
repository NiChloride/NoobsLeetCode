import java.util.Stack;

class MyQueue {
    Stack<Integer> q;
	Stack<Integer> buffer;

    public MyQueue() {
        q = new Stack<Integer>();
        // the stack that emulate the queue, i.e. elements in reverse order of insertion
        //for example, if this queue is inserted in the order of 1,2,3,4,5, stack q will be inserted in order 5,4,3,2,1
        //this way, calling q.pop() actually returns 1;
        buffer = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(this.q.empty())
        {
            this.q.push(x);
        }
        else
        {
            while(!this.q.empty())
            {
                this.buffer.push(q.pop()); //say q was 4,3,2,1, buffer would be [1,2,3,4]
            }
            
            this.q.push(x); //q = [5]
            while(!this.buffer.empty())
            {
                this.q.push(this.buffer.pop()); //push 4,3,2,1
            }
            
        }
    }
    
    public int pop() {
        return this.q.pop();
        
    }
    
    public int peek() {
        return this.q.peek();
        
    }
    
    public boolean empty() {
        return this.q.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */