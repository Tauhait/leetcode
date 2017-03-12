class Stack {
public:
    queue<int> q1;
    queue<int> q2;
    // Push element x onto stack.
    void push(int x) {
        q1.push(x);
    }

    // Removes the element on top of the stack.
    void pop() {
        if(q1.empty()) return;
        while(q1.size() > 1) {
            q2.push(q1.front());
            q1.pop();
        }
        q1.pop();
        
        while(!q2.empty()) {
            q1.push(q2.front());
            q2.pop();
        }
    }

    // Get the top element.
    int top() {
        if(q1.empty()) return 0;
        while(q1.size() > 1) {
            q2.push(q1.front());
            q1.pop();
        }
        int t = q1.front();
        q2.push(q1.front());
        q1.pop();
        
        while(!q2.empty()) {
            q1.push(q2.front());
            q2.pop();
        }
        
        return t;
    }

    // Return whether the stack is empty.
    bool empty() {
        return q1.empty();
    }
};