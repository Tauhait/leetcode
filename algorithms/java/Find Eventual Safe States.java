class Solution {

    private void dfs(int cur, List<Integer> path, int[][] graph, boolean[] visited, Set<Integer> res, Set<Integer> remove) {
        if (graph[cur].length == 0) {
            for (int i = 0; i < path.size(); ++i) res.add(path.get(i));
            return;
        }

        if(remove.contains(cur)) {
            for(int j = 0;j < path.size();++j) remove.add(path.get(j));
                return;   
        }
        
        if(res.contains(cur)) {
          for (int i = 0; i < path.size(); ++i) res.add(path.get(i));
            return;  
        }
        
        for (int i = 0; i < graph[cur].length; ++i) {
            int id = graph[cur][i];
            if(visited[id] == true) {
                for(int j = 0;j < path.size();++j) remove.add(path.get(j));
                return;
            }

            if (visited[id] == false) {
                path.add(id);
                visited[id] = true;
                dfs(id, path, graph, visited, res, remove);
                visited[id] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> remove = new HashSet<>();
        int n = graph.length;
        for (int i = 0; i < n; ++i) {
            if (res.contains(i)) continue;
            if(remove.contains(i)) continue;
            boolean[] visited = new boolean[n];
            List<Integer> path = new ArrayList<>();
            path.add(i);
            visited[i] = true;
            dfs(i, path, graph, visited, res, remove);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
        for (Integer r : remove) res.remove(r);
        List<Integer> ans = new ArrayList<>(res);
        Collections.sort(ans);
        return ans;
    }
}