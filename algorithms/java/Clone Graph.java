/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {  
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        map.put(node, new UndirectedGraphNode(node.label));
        q.add(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode p = q.poll();
            for(UndirectedGraphNode e: p.neighbors) {
                if(!map.containsKey(e)) {
                    map.put(e, new UndirectedGraphNode(e.label));
                    q.add(e);
                }
                map.get(p).neighbors.add(map.get(e));
            }
        }
        return map.get(node);
    }
}