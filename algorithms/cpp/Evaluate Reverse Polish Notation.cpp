class Solution {
public:
    int opCal(const int& a, const int& b, const char& c) {
        switch(c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
    }
    
    int evalRPN(vector<string>& tokens) {
        stack<int> nums;
        
        for(size_t i = 0;i < tokens.size();++i) {
            if(tokens[i].size() == 1 && (tokens[i][0] == '+' || tokens[i][0] == '-' ||
               tokens[i][0] == '*' || tokens[i][0] == '/')) {
                int a = nums.top();
                nums.pop();
                int b = nums.top();
                nums.pop();
                nums.push(opCal(b, a, tokens[i][0]));
            } else {
                int sign = 1;
                size_t j = 0;
                if(tokens[i][0] == '-') {
                    sign = -1;
                    j++;
                }
                int s = 0;
                for(;j < tokens[i].size();++j) {
                    s = s * 10 + (tokens[i][j] - '0');
                }
                nums.push(sign * s);
            }
        }
        
        return nums.top();
    }
};