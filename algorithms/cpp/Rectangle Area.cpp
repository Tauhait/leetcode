class Solution {
public:
    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = 0;
        
        int u = min(C, G);
        int d = max(A, E);
        
        int r = min(D, H);
        int l = max(B, F);
        
        if(u > d && r > l) {
            area -= (u - d) * (r - l);
        }
        
        
        return area + fabs(A - C) * fabs(B - D) + fabs(E - G) * fabs(F - H);
    }
};