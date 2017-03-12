class MinStack {
public:
    stack<int> st;
    stack<int> min_st;
    
    void push(int x) {
        st.push(x);
        if(min_st.empty() || x <= min_st.top()) {
            min_st.push(x);
        }
    }

    void pop() {
        int x = st.top();
        st.pop();
        if(min_st.top() == x) {
            min_st.pop();
        }
    }

    int top() {
        return st.top();
    }

    int getMin() {
        return min_st.top();
    }
};