class Solution {
    private static class Pair implements Comparable<Pair> {
        int pIndex;
        int qIndex;
        
        int[] A;
        
        public Pair(int[] A, int pIndex, int qIndex) {
            this.A = A;
            this.pIndex = pIndex;
            this.qIndex = qIndex;
        }
        
        public int compareTo(Pair that) {
            if((double) this.A[this.pIndex] / (double) this.A[this.qIndex] 
               < (double) that.A[that.pIndex] / (double) that.A[that.qIndex]) return -1;
            return 1;
        }
    }
    
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0;i < A.length - 1;++i) {
            pq.add(new Pair(A, i, A.length - 1));
        }
        
        int k = 0;
        while(!pq.isEmpty()) {
            Pair front = pq.poll();
            k++;
            if(k == K) return new int[]{A[front.pIndex], A[front.qIndex]};
            front.qIndex--;
            if(front.pIndex < front.qIndex) pq.add(front);
        }
        return new int[0];
    }
}