// Forward declaration of the knows API.
bool knows(int a, int b);

class Solution {
public:
    void knowslist(const vector<int>& vec, vector<int>& vec_n) {
        for(int i = 0;i + 1 < vec.size();i += 2) {
            if(knows(vec[i], vec[i + 1])) vec_n.push_back(vec[i + 1]);
            else vec_n.push_back(vec[i]);
        }
        if(vec.size() % 2 == 1) {
            vec_n.push_back(vec.back());
        }
    }
    
    int findCelebrity(int n) {
        if(n <= 1) return -1;
        vector<int> vec(n, 0);
        for(int i = 0;i < n;++i) {
            vec[i] = i;
        }
        vector<int> vec_n;
        while(vec.size() > 1) {
            knowslist(vec, vec_n);
            vec.clear();
            vec = vec_n;
            vec_n.clear();
        }
        int id = vec[0];
        for(int i = 0;i < n;++i) {
            if(i != id) {
                if(!knows(i, id) || knows(id, i)) return -1;
            }
        }
        
        return id;
    }
};