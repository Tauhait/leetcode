public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, HashSet<Integer> > adjList = new HashMap<>();
        int n = pid.size();
        if(ppid.size() != n) {
            throw new IllegalArgumentException();
        }
        for(int i = 0;i < n;++i) {
            int par = ppid.get(i);
            int id = pid.get(i);
            if(!adjList.containsKey(par)) {
                adjList.put(par, new HashSet<>());
            }
            adjList.get(par).add(id);
        }
        
        List<Integer> killedList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        killedList.add(kill);
        while(!q.isEmpty()) {
            Integer f = q.poll();
            if(adjList.containsKey(f)) {
                HashSet<Integer> set = adjList.get(f);
                for(Integer id: set) {
                    q.add(id);
                    killedList.add(id);
                }
            }
        }
        
        return killedList;
    }
}