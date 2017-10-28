class Solution {
    private boolean isValid(String s) {
        int left = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') left++;
            else if(c == ')') {
                if(left <= 0) return false;
                left--;
            }
        }
        return left == 0;
    }
    
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(s);
        visited.add(s);
        boolean found = false;
        while(!q.isEmpty() && found == false) {
            int size = q.size();
            for(int i = 0;i < size;++i) {
                String f = q.poll();
                if(isValid(f)) {
                    found = true;
                    res.add(f);
                }
                if(found == false) {
                    for(int j = 0;j < f.length();++j) {
                        if(f.charAt(j) == ')' || f.charAt(j) == '(') {
                            if(j > 0 && f.charAt(j) == f.charAt(j - 1)) continue;
                            String t = f.substring(0, j) + f.substring(j + 1);
                            if(!visited.contains(t)) q.add(t);    
                           visited.add(t);
                        }
                    }
                } 
            }
        }
        return new ArrayList<>(res);        
    }
}