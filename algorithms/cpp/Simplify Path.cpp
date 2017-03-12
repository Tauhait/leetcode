class Solution {
public:
    string simplifyPath(string path) {
        stack<string> s;
        int i = 0;
        while(i < path.size()) {
            if(path[i] == '/') {
                while(i < path.size() && path[i] == '/')i++;
                int st = i;
                cout << st << " " << i << endl;
                while(i < path.size() && path[i] != '/') i++;
                if(i == st) break; 
                string p = path.substr(st, i - st);
                cout << "p = " << p << endl;
                if(p == ".") continue;
                else if(p == ".."){
                    if(!s.empty()) s.pop();
                }
                else s.push(p);
            }
        }
        
        vector<string> v;
        while (!s.empty()) {
            v.push_back(s.top());
            s.pop();
        }
        if(v.size() == 0) return "/";
        
        string ret;
        reverse(v.begin(), v.end());
        for(size_t i = 0;i < v.size();++i) {
            ret += "/";
            ret += v[i];
        }
        
        return ret;
    }
};