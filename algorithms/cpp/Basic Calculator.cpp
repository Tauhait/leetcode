class Solution {
public:
    stack<char> ops;
    vector<string> suffix;
    int calculate(string s) {
        for(size_t i = 0;i < s.size();++i) {
            if(s[i] == '(') ops.push(s[i]);
            else if(s[i] == '-' || s[i] == '+') {
                while(!ops.empty() && ops.top() != '(') {
                    suffix.push_back(string(1, ops.top()));
                    ops.pop();
                }
                ops.push(s[i]);
            } else if(s[i] == ')') {
                while(!ops.empty() && ops.top() != '(') {
                    suffix.push_back(string(1, ops.top()));
                    ops.pop();
                }
                ops.pop();
            } else if(s[i] >= '0' && s[i] <= '9') {
                string num;
                while(i < s.size() && s[i] >= '0' && s[i] <= '9') {
                    num += s[i];
                    i++;
                }
                suffix.push_back(num);
                i--;
            }
        }
        while(!ops.empty() && ops.top() != '(') {
            suffix.push_back(string(1, ops.top()));
            ops.pop();
        }
        
        /////////////////////
        //for(int i = 0;i < suffix.size();++i) {
            //cout << suffix[i] << endl;
        //}//
        
        stack<int> nums;
        for(int i = 0;i < suffix.size();++i) {
            if(suffix[i][0] == '+' || suffix[i][0] == '-') {
                int a = nums.top();
                nums.pop();
                int b = nums.top();
                nums.pop();
                int c = 0;
                
                if(suffix[i][0] == '+') c = a + b;
                else c = b - a;
                
                nums.push(c);
            } else {
                nums.push(atoi(suffix[i].c_str()));
            }
        }
        return nums.top();
    }
};