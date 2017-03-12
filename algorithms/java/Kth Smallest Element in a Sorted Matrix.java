public class Solution {
    private class Node implements Comparable<Node> {
        Node(int _val, int _r, int _c) {
            val = _val;
            r = _r;
            c = _c;
        }
        
        public int compareTo(Node that) {
            return this.val - that.val;
        }
        
        private int val;
        private int r;
        private int c;
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if(n == 0) return 0;
        boolean[][] f = new boolean[n][n];
        for(int i = 0;i < n;++i) {
            Arrays.fill(f[i], false);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(matrix[0][0], 0, 0));
        int num = 0;
        int r = 0;
        int c = 0;
        while(!pq.isEmpty()) {
            Node front = pq.poll();
            
            num++;
            if(num == k) return front.val;
            
            r = front.r;
            c = front.c + 1;
            if(c < n && f[r][c] == false) {
                pq.add(new Node(matrix[r][c], r, c));
                f[r][c] = true;
            }
            
            r = front.r + 1;
            c = front.c;
            if(r < n && f[r][c] == false) {
                pq.add(new Node(matrix[r][c], r, c));
                f[r][c] = true;
            }
        }
        
        return -1;
    }
}