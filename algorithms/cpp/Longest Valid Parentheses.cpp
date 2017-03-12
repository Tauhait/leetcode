class Solution {
public:
    int longestValidParentheses(string s) {
        stack<int> st;
        int ret = 0, cur = 0;
        for(int i = 0;i < s.size();++i) {
            if(s[i] == '(') st.push(i);
            else if(s[i] == ')') {
                if(st.empty() || s[st.top()] == ')') {
                    st.push(i);
                } else {
                    st.pop();
                    if(st.empty()) ret = max(ret, i + 1);
                    else ret = max(ret, i - st.top());
                }
            }
        }
        
        return ret;
    }
};