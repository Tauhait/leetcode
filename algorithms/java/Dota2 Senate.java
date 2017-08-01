public class Solution {
    private boolean[] used;
    public String predictPartyVictory(String senate) {
        used = new boolean[senate.length()];
        Arrays.fill(used, false);
        return predictPartyVictory(senate, 0);    
    }
    
    private String predictPartyVictory(String senate, int start) {
        if(start >= senate.length()) {
            start = 0;
            while(start < senate.length() && used[start]) start++;
        }
        
        char f = 'Y';
        if(senate.charAt(start) == 'R') f = 'D';
        else f = 'R';
        
        int index = -1;
        for(int i = start + 1;i < senate.length();++i) {
            if(used[i] || senate.charAt(i) != f) continue;
            used[i] = true;
            index = i;
            break;
        }
        if(index == -1) {
            for(int i = 0;i < start;++i) {
                if(used[i] || senate.charAt(i) != f) continue;
                used[i] = true;
                index = i;
                break;
            }
        }
            
        if(index == -1) {
            if(senate.charAt(start) == 'R') return "Radiant";
            else return "Dire";
        }
        
        int j = start + 1;
        while(j < senate.length() && used[j]) j++;
        return predictPartyVictory(senate, j);
    }
}