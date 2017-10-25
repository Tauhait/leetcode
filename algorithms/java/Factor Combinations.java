class Solution {
    private void dfs(int start, int num, List<Integer> cur, List<List<Integer> > sets) {
        if(num == 1) {
            if(cur.size() > 1) sets.add(new ArrayList<>(cur));
            return ;
        }
        if(num < start) return ;
        
        if(num % start == 0) {
            cur.add(start);
            dfs(start, num / start, cur, sets);
            cur.remove(cur.size() - 1);
        } 
        start = start + 1;
        while(start < num && num % start != 0) start++;
        dfs(start, num, cur, sets);        
    }
    
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer> > sets = new ArrayList<>();
        dfs(2, n, new ArrayList<>(), sets);    
        return sets;
    }
}