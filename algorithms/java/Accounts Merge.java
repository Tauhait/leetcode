class Solution {
    private void union(int[] parent, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);
        parent[pv] = pu;
    }
    
    private int find(int[] parent, int x) {
        int t = x;
        while(x != parent[x]) x = parent[x];
        int r = x;
        
        // update
        x = t;
        while(x != parent[x]) {
            t = parent[x];
            parent[x] = r;
            x = t;
        }
        return r;
    }
    
    private boolean hasCommonEmail(Set<String> set1, Set<String> set2) {
        for(String s: set1) {
            if(set2.contains(s)) return true;
        }
        return false;
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parent = new int[accounts.size()];
        for(int i = 0;i < parent.length;++i) parent[i] = i;
        
        List<Set<String>> listSet = new ArrayList<>();
        for(int i = 0;i < accounts.size();++i) {
            listSet.add(new HashSet<>());
            Set<String> set = listSet.get(i);
            for(int j = 1;j < accounts.get(i).size();++j) set.add(accounts.get(i).get(j));   
        }
        
        for(int i = 0;i < accounts.size();++i) {
            for(int j = i + 1;j < accounts.size();++j) {
                int pi = find(parent, i);
                int pj = find(parent, j);
                if(pi == pj) continue;
                if(hasCommonEmail(listSet.get(i), listSet.get(j))) union(parent, i, j);
            }
        }
        
        Map<Integer, Set<String> > map = new HashMap<>();
        for(int i = 0;i < accounts.size();++i) {
            int pi = find(parent, i);
            map.putIfAbsent(pi, new HashSet<>());
            Set<String> set = map.get(pi);
            for(int j = 1;j < accounts.get(i).size();++j)
                set.add(accounts.get(i).get(j));
        }
        List<List<String> > ret = new ArrayList<>();
        for(Map.Entry<Integer, Set<String> > entry: map.entrySet()) {
            List<String> list = new ArrayList<>();
            List<String> emails = new ArrayList<>(entry.getValue());
            Collections.sort(emails);
            list.add(accounts.get(entry.getKey()).get(0));
            for(int i = 0;i < emails.size();++i) list.add(emails.get(i));
            ret.add(list);
        }
        return ret;
    }
}