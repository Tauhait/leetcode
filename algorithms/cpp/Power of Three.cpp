class Solution {
public:
    bool isPowerOfThree(int n) {
    
        
        
        if(n == 0) return false;
        if(n == 1) return true;
        
        
        if(n % 3 != 0) return false;
        
        return isPowerOfThree(n / 3);
        
        // binary search
        if(n % 10 == 3) {
            if(n == 3) return true;
            if(n % 81 == 0) return true;
            return false;
        }
        
        if(n % 10 == 9) {
            if(n == 9) return true;
            if(n % 81 == 0) return true;
            return false;
        }
        
        if(n % 10 == 7) {
            if(n == 27) return true;
            if(n % 81 == 0) return true;
            return false;
        }
        
        if(n % 10 == 1) {
            if(n % 81 == 0) return true;
            return false;
        }
        
        return false;
    }
};
