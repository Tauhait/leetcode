///////////////////
// Topological Order
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


///////////////////
// Uinon Find
public class UnionFind {
    private void union(int[] parent, int i, int j) {
        int pj = find(parent, i);
        int pi = find(parent, j);
        parent[pi] = pj;
    }

    private int find(int[] parent, int x) {
        int t = x;
        while (x != parent[x]) x = parent[x];
        int r = x;

        // update parent node for all nodes in the path
        x = t;
        while (x != parent[x]) {
            t = parent[x];
            parent[x] = r;
            x = t;
        }
        return r;
    }


    public int[] findRedundantConnection(int[][] edges) {
        if (edges.length == 0) return new int[]{-1, -1};

        int N = 0;
        for (int i = 0; i < edges.length; ++i) {
            N = Math.max(N, edges[i][0]);
            N = Math.max(N, edges[i][1]);
        }
        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; ++i) parent[i] = i;

        for (int i = 0; i < edges.length; ++i) {
            int f = edges[i][0];
            int t = edges[i][1];
            int pf = find(parent, f);
            int pt = find(parent, t);
            if (pf == pt) return edges[i];
            union(parent, f, t);
        }
        return edges[edges.length - 1];
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        //int[][] edges = new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[][] edges = {{1,3},{3,4},{1,5},{3,5},{2,3}};
        int[] edge = uf.findRedundantConnection(edges);
        System.out.println(edge[0] + " " + edge[1]);
    }
}

