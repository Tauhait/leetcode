class Solution {
public:
    int numTrees(int n) {
        vector<int> methods;
        methods.push_back(1);
        methods.push_back(1);
        methods.push_back(2);
        methods.push_back(5);
        
        if(n <= 3) return methods[n];
        
        for(int i = 4;i <= n;++i) {
            methods.push_back(0);
            for(int j = 0;j < i;++j) {
                methods[i] += methods[j] * methods[i - 1 - j];
            }
        }
        
        return methods[n];
    }
};