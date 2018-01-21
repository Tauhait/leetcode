class Solution {
    private static class Pair implements Comparable<Pair> {
        char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        public int compareTo(Pair that) {
            return that.count - this.count;
        }
    }

    public String reorganizeString(String S) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : S.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<> ();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        Pair next = null;
        while(!pq.isEmpty()) {
            Pair front = pq.poll();
            sb.append(front.c);
            front.count = front.count - 1;
            if(next != null) pq.add(next);
            if(front.count != 0) next = front;
            else next = null;
        }
        if(pq.isEmpty() && next != null) return "";
        return sb.toString();
    } 
}