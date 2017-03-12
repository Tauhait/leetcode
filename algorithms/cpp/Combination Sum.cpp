class Solution {
public:
    vector<vector<int> > ret;
    
    void dfs(const int& n, const int& index, vector<int>& cur, const int& sum,
        const int& target, const vector<int>& candidates) {
        if(sum == target) {
            ret.push_back(cur);   
            return;
        }
        if(sum > target) return;
        if(n == index) return;
        
        
        if(sum + candidates[index] <= target) {
            cur.push_back(candidates[index]);
            dfs(n, index, cur, sum + candidates[index], target, candidates);
            cur.pop_back();
        }
        
        dfs(n, index + 1, cur, sum, target, candidates);
    }
    
    vector<vector<int> > combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<int> cur;
        int n = candidates.size();
        dfs(n, 0, cur, 0, target, candidates);
        
        return ret;
    }
};
