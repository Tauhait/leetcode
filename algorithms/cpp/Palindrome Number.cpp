class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0) return false;
        
        int org = x;
        int p = 1;
        while(x / 10 >= 1) {
            p *= 10;
            x /= 10;
        }
        int e = 10;
        int org1 = org, org2 = org;
        while(org1 != 0 && org2 != 0) {
            int l = org1 % 10;
            int f = org2 / p;
            if(l != f) {
                return false;
            }
            org1 /= 10;
            org2 %= p;
            p /= 10;
        } 
        
        return true;
    }
};