class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if(k == 0) return Collections.emptyList();

        Map<String, Integer> map = new HashMap<>();
        for(String word: words) map.put(word, map.getOrDefault(word, 0) + 1);
        
        PriorityQueue<Map.Entry<String, Integer> > pq = new PriorityQueue<>(
             (a, b) -> a.getValue() == b.getValue() ?
             b.getKey().compareTo(a.getKey()) :
             a.getValue() - b.getValue()
        );

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(pq.size() < k) pq.add(entry);
            else if(pq.size() == k) {
                Map.Entry<String, Integer> front = pq.peek();
                if(front.getValue() < entry.getValue() || 
                   (front.getValue() == entry.getValue() && entry.getKey().compareTo(front.getKey()) < 0)) {
                    pq.poll();
                    pq.add(entry);
                }
            }
        }

        List<String> topStrings = new LinkedList<>();
        while(!pq.isEmpty()) topStrings.add(0, pq.poll().getKey());
        return topStrings;
    }
}