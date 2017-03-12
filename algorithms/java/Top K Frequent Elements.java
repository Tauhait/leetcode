public class Solution {
    private class Node implements Comparable<Node> {
        public Node(int _count, int _val) {
            count = _count;
            val = _val;
        }
        
        public int compareTo(Node that) {
            return that.count - this.count;
        }
        
        private int count;
        private int val;
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(new Node(entry.getValue(), entry.getKey()));
        }
        List<Integer> res = new ArrayList<>();
        int l = 0;
        while(!pq.isEmpty() && l < k) {
            res.add(pq.poll().val);
            l++;
        }
        
        return res;
    }
}