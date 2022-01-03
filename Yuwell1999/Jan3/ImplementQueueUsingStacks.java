package Jan3;

import java.util.Deque;
import java.util.LinkedList;

// 232
class ImplementQueueUsingStacks {
    Deque<Integer> inputStack;
    Deque<Integer> outputStack;

    public ImplementQueueUsingStacks() {
        inputStack = new LinkedList<>();
        outputStack = new LinkedList<>();
    }

    public void push(int x) {
        inputStack.offer(x);
    }

    public int pop() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.offer(inputStack.poll());
            }
        }

        return outputStack.poll();
    }

    public int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.offer(inputStack.poll());
            }
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
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
