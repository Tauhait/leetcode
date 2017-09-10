class Solution {
    private class Profit implements Comparable<Profit> {
        private int profit;
        private int capital;
        
        public Profit(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        } 
        
        public int compareTo(Profit that) {
            return capital - that.capital;
        }
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Profit[] p = new Profit[profits.length];
        for(int i = 0;i < profits.length;++i) {
            p[i] = new Profit(profits[i], capital[i]);
        }
        Arrays.sort(p);
        
        int ret = w;
        int cnt = 0;
        int index = 0;
        PriorityQueue<Profit> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        while(cnt < k) {
            while(index < p.length && p[index].capital <= ret) {
                    pq.add(p[index]);
                    index++;
            }
            if(!pq.isEmpty()) {
                ret += pq.poll().profit;
                cnt++;
            } else {
                break;
            }
        }
        return ret;
    }
}