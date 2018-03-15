class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i = 0;i < graph.length;++i) {
            if(color[i] == -1) {
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                Set<Integer> set =new HashSet<>();
                q.add(i);
                set.add(i);
                while(!q.isEmpty()) {
                    int f = q.poll();
                    for(int j = 0;j < graph[f].length;++j) {
                        if(color[f] == color[graph[f][j]]) return false;
                        if(color[graph[f][j]] == -1) {
                            if(color[f] == 1) color[graph[f][j]] = 2;
                            else color[graph[f][j]] = 1;
                        }
                        if(!set.contains(graph[f][j])) {
                            q.add(graph[f][j]);
                            set.add(graph[f][j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}