public class MinStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> sm = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        s.push(x);
        if(sm.isEmpty()) sm.push(x);
        else if(x <= sm.peek()) {
            sm.push(x);
        }
    }
    
    public void pop() {
        int x = 0;
        if(!s.isEmpty())
            x = s.pop();
        if(!sm.isEmpty() && x == sm.peek()) {
            sm.pop();
        }
    }
    
    public int top() {
        if(!s.isEmpty()) return s.peek();
        return -1;
    }
    
    public int getMin() {
        if(!sm.isEmpty()) return sm.peek();
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */