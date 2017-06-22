public class Solution {
    private class Pair implements Comparable<Pair> {
        char c;
        int count; //count or number of seconds to wait
        
        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
        
        public int compareTo(Pair that) {
            return that.count - this.count;
        }
    }
    
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) {
            return tasks.length;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i < tasks.length;++i) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        
        LinkedList<Pair> list = new LinkedList<>();
        Map<Character, Integer> charPos = new HashMap<>();
        int pos = 0;
        while(!pq.isEmpty() || !list.isEmpty()) {
            if(!list.isEmpty()) {
                char c = list.peekFirst().c;
                if(pos - charPos.get(c) > n) {
                    pq.add(list.pollFirst());
                }
            }
            
            if(!pq.isEmpty()) {
                Pair front = pq.poll();
                if(front.count > 1) {
                    front.count--;
                    charPos.put(front.c, pos);
                    list.add(front);
                }
            }
            pos++;
        }
        return pos;
    }
}