class Solution {
public:
    bool SearchMatrix(const vector<vector<int> >& matrix, const int& rl, const int& rh, const int& cl, const int& ch, const int& target) {
        if(rl > rh || cl > ch) {
            return false;
        }
        
        int rmid = rl + (rh - rl) / 2;
        int cmid = cl + (ch - cl) / 2;
            
        if(matrix[rmid][cmid] == target) {
            return true;
        }
            
        if(matrix[rmid][cmid] > target) {
            return SearchMatrix(matrix, rl, rh, cl, cmid - 1, target) ||
                   SearchMatrix(matrix, rl, rmid - 1, cmid, ch, target);
        } else {
            return SearchMatrix(matrix, rl, rmid, cmid + 1, ch, target) ||
                   SearchMatrix(matrix, rmid + 1, rh, cl, ch, target);
        }
    }
    
    bool searchMatrix(vector<vector<int> >& matrix, int target) {
        int m = matrix.size();
        if(m == 0) return false;
        int n = matrix[0].size();
        if(n == 0) return false;
        
        return SearchMatrix(matrix, 0, m - 1, 0, n - 1, target);
    }
};