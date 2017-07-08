public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int start = 0;
        for(int i = 0;i < courses.length;++i) {
            if(courses[i][0] + start <= courses[i][1]) {
                start = start + courses[i][0];
                pq.add(courses[i][0]);
            } else {
                if(!pq.isEmpty()) {
                    Integer f = pq.peek();
                    if(f > courses[i][0]) {
                        start = start - f + courses[i][0];
                        pq.poll();
                        pq.add(courses[i][0]);
                    }
                }
            }
        }
        return pq.size();        
    }
}