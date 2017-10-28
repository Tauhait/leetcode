class Solution {
    private String code(int u, int v) {
        if(u < v) 
            return String.valueOf(u) + "#" + String.valueOf(v);
        return String.valueOf(v) + "#" + String.valueOf(u);
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer> > graph = new HashMap<>();
        Set<String> edgeSet = new HashSet<>();
        int[] degrees = new int[n + 1];
        for(int i = 0;i < n;++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
            degrees[u]++;
            degrees[v]++;
            edgeSet.add(code(u, v));
        }
        Queue<Integer> oneNodes = new LinkedList<>();
        for(int i = 1;i <= n;++i) {
            if(degrees[i] == 1)
                oneNodes.add(i);
        }
        if(oneNodes.size() == 0) return edges[n - 1];
        
        while(!oneNodes.isEmpty()) {
            int node = oneNodes.poll();
            for(Integer adj: graph.get(node)) {
                edgeSet.remove(code(node, adj));
             
                degrees[adj]--;
                if(degrees[adj] == 1)
                    oneNodes.add(adj);
            }
        }

        for(int i = n - 1;i >= 0;--i) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(edgeSet.contains(code(u, v))) return edges[i];
        }
        return new int[2];
    }
}