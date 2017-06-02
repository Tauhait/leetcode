public class Solution {
    private class Node implements Comparable<Node> {
        int val;
        int r;
        int c;
        
        public Node(int val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        } 
        
        public int compareTo(Node that) {
            return this.val - that.val;
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0 || n == 0) {
            return new ArrayList<int[]>();
        }
        
        List<int[]> ret = new ArrayList<>(k);
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(nums1[0] + nums2[0], 0, 0));
        visited[0][0] = true;
        while(!pq.isEmpty() && ret.size() < k) {
            Node f = pq.poll();
            ret.add(new int[]{nums1[f.r], nums2[f.c]});
            if(f.r + 1 < m && visited[f.r + 1][f.c] == false) {
                pq.add(new Node(nums1[f.r + 1] + nums2[f.c], f.r + 1, f.c));
                visited[f.r + 1][f.c] = true;
            }
            if(f.c + 1 < n && visited[f.r][f.c + 1] == false) {
                pq.add(new Node(nums1[f.r] + nums2[f.c + 1], f.r, f.c + 1));
                visited[f.r][f.c + 1] = true;
            }
        }
        return ret;
    }
}