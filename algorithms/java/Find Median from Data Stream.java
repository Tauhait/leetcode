public class MedianFinder {
    // store all small values(largest on the top)
    PriorityQueue<Integer> pq_small = new PriorityQueue<>(Collections.reverseOrder());
    
    // store all large values (smallest on the top)
    PriorityQueue<Integer> pq_large = new PriorityQueue<>();
    
    /** initialize your data structure here. */
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if(pq_large.size() == pq_small.size()) {
            pq_small.add(num);
            pq_large.add(pq_small.poll());
        } else if(pq_large.size() > pq_small.size()) {
            pq_large.add(num);
            pq_small.add(pq_large.poll());
        } else {
            pq_small.add(num);
            pq_large.add(pq_small.poll());
        }
    }
    
    public double findMedian() {
        if(pq_large.size() == pq_small.size()) {
            if(pq_large.size() == 0) return 0;
            return (pq_large.peek() + pq_small.peek()) / 2.0;
        } else if(pq_large.size() > pq_small.size()) {
            return pq_large.peek();
        } else {
            return pq_small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */