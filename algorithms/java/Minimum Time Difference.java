public class Solution {
    public int findMinDifference(List<String> timePoints) {
        TreeSet<Integer> time = new TreeSet<>();
        for(String t: timePoints) {
            String hour = t.substring(0, 2);
            String minute = t.substring(3, 5);
            Integer tt = Integer.valueOf(hour) * 60 + Integer.valueOf(minute);
            if(time.contains(tt)) return 0;
            time.add(tt);
        }
        int res = 1440;
        for(Integer t: time) {
            Integer high = time.higher(t);
            if(high != null) {
                res = Math.min(res, Math.abs(high - t));
            }
            Integer low = time.lower(t);
            if(low != null) {
                res = Math.min(res, Math.abs(low - t));
            }
            
            //#########
            Integer tt = 1440 - t;
            high = time.higher(tt);
            if(high != null && high != t) {
                res = Math.min(res, Math.abs(high + tt));
            }
            low = time.lower(tt);
            if(low != null && low != t) {
                res = Math.min(res, Math.abs(low + tt));
            }
        }
        
        return res;
    }
}