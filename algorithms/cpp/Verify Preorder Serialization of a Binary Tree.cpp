class Solution {
public:
    void splitComma(const string preorder, vector<string>& order) {
        if(preorder.size() == 0) {
            return ;
        }
        
        string str = preorder;
        size_t pos = str.find_first_of(',');
        while(pos != string::npos) {
            order.push_back(str.substr(0, pos));
            str = str.substr(pos + 1);
            pos = str.find_first_of(',');
        }
        order.push_back(str);
        // cout << "size = " << order.size() << endl;
        // for(size_t i = 0;i < order.size();++i) {
        //     cout << order[i] << endl;
        // }
    }
    
    bool isValidSerialization(string preorder) {
        vector<string> order;
        splitComma(preorder, order);
        
        if(order.size() == 0) return true;
        if(order.size() == 1) {
            if(order[0][0] == '#') return true;
            return false;
        }
        
        if(order.size() > 1 && order[0][0] == '#') return false;
        
        stack<pair<string, int> > s;
        s.push(make_pair(order[0], 0));
        size_t i = 1;
        while(1) {
            // if(s.empty()) {
            //     // cout << "empty i = " << i << " ";
            //     if(i < order.size()) cout << order[i] << endl;    
            //     else cout << endl;
            // } else {
            //     // cout << "no stop = " << s.top().first << " " << s.top().second << " xxx i = " << i << " ";
            //   //  if(i < order.size()) cout << order[i] << endl;   
            //   //  else cout << endl;
            // }
            
            
            if(s.top().second == 2) {
                s.pop();
                // cout << i << " xxx " << order.size() - 1 << endl;
                if(s.empty()) {
                    if(i == order.size()) return true;
                    return false;
                }
                
                pair<string, int> top = s.top();
                s.pop();
                
                top.second++;
                s.push(top);
            } else {
                if(i >= order.size()) break;
                if(order[i][0] == '#') {
                    // cout << "s.size() = " << s.size() << endl;
                    if(s.empty()) return false;
                    pair<string, int> top = s.top();
                    s.pop();
                
                    top.second++;
                    s.push(top);
                } else {
                    s.push(make_pair(order[i], 0));                
                }
                i++;
            }
        }
        
        if(s.empty()) return true;
        return false;
    }
};