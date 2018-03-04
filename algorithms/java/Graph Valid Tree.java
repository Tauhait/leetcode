class Solution {
    private void union(int[] parent, int i, int j) {
        int pi = find(parent, i);
        int pj = find(parent, j);
        parent[pi] = pj;
    }
    
    private int find(int[] parent, int x) {
        int t = x;
        while(x != parent[x]) x = parent[x];
        int r = x;
        
        // udpate parent for nodes in the path
        x = t;
        while(x != parent[x]) {
            t = parent[x];
            parent[x] = r;
            x = t;
        }
        
        return r;
    }
    
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0;i < n;++i) parent[i] = i;
        for(int i = 0;i < edges.length;++i) {
            int f = edges[i][0];
            int t = edges[i][1];
            int pf = find(parent, f);
            int pt = find(parent, t);
            if(pf == pt) return false;
            union(parent, f, t);
        }
        return n == edges.length + 1;
    }
}