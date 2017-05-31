public class Solution {
    private boolean compare(String a, String b, char[] chr) {
        int la = a.length(), lb = b.length();
        int i = 0, j = 0;
        while(i < la && j < lb) {
            if(a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                chr[0] = a.charAt(i);
                chr[1] = b.charAt(j);
                return true;
            }
        }
        
        if(la > lb) {
            return false;
        }
        
        chr[0] = '0';
        chr[1] = '0';
        return true;
    } 
    
    public String alienOrder(String[] words) {
        int[][] order = new int[26][26];
        // order 1 means larger
        //      -1 means smaller
        
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < words.length;++i) {
            for(char c: words[i].toCharArray()) {
                set.add(c);
            }
        }
        
        for(int i = 0;i < words.length;++i) {
            for(int j = i + 1;j < words.length;++j) {
                char[] chr = new char[2];
                if(!compare(words[i], words[j], chr)) {
                    return "";    
                }
                if(chr[0] == chr[1] && chr[0] == '0') {
                    continue;
                }
                int a = chr[0] - 'a';
                int b = chr[1] - 'a';
                if(order[a][b] != 0 && order[a][b] == 1) {
                    return "";
                }
                if(order[b][a] != 0 && order[b][a] == -1) {
                    return "";
                }
                order[a][b] = -1;
                order[b][a] = 1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[26];
        for(int i = 0;i < 26;++i) {
            if(!set.contains((char)(i + 'a'))) {
                inDegree[i] = -1;
            }
            for(int j = 0;j < 26;++j) {
                if(order[i][j] == 1) {
                    inDegree[i]++;
                }    
            }
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int f = q.poll();
            sb.append((char)(f + 'a'));
            for(int i = 0;i < 26;++i) {
                if(order[i][f] == 1) {
                    inDegree[i]--;
                    if(inDegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        
        for(int i = 0;i < 26;++i) {
            if(inDegree[i] > 0) {
                return "";
            }
        }
        
        return sb.toString();
    }
}