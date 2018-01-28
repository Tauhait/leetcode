class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J == null || S == null) return 0;
        int count = 0;
        for(char c: S.toCharArray()) {
            if(J.indexOf(c) >= 0) count++;
        }
        return count;
        
    }
}