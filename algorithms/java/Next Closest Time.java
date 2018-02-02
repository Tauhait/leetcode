class Solution {
    private static final int ONE_DAY = 24 * 60;
        
    private int[] getHourMinute(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        return new int[]{hour, minute};
    }
    
    private int totalMinute(String time) {
        int[] hourMinute = getHourMinute(time);
        return hourMinute[0] * 60 + hourMinute[1]; 
    }
    
    private boolean validTime(String time) {
        if(time.length() != 5) return false;
        
        int[] hourMinute = getHourMinute(time);
        if(hourMinute[0] < 0 || hourMinute[0] > 23) return false;
        if(hourMinute[1] < 0 || hourMinute[1] > 59) return false;
        return true;
    }
    
    private int computeDistance(String time, String org) {
        int totalMinuteTime = totalMinute(time);
        int totalMinuteOrg = totalMinute(org);
        if(totalMinuteTime < totalMinuteOrg) {
            return ONE_DAY - totalMinuteOrg + totalMinuteTime;
        } else {
            return totalMinuteTime - totalMinuteOrg;
        }
    }
    
    private void dfs(int d, char[] cur, List<Character> digits, List<String> candidates) {
        if(d == 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(cur[0]).append(cur[1]).append(':').append(cur[2]).append(cur[3]);
            String time = sb.toString();
            if(validTime(time)) candidates.add(time);
            return;
        }
        for(int i = 0;i < digits.size();++i) {
            cur[d] = digits.get(i);
            dfs(d + 1, cur, digits, candidates);    
        }
    }
    
    private List<String> getCandidates(String time) {
        Set<Character> digits = new HashSet<>();
        for(char c: time.toCharArray()) {
            if(Character.isDigit(c)) digits.add(c);
        }
        List<String> candidates = new ArrayList<>();
        dfs(0, new char[4], new ArrayList<>(digits), candidates);
        return candidates;
    }
    
    public String nextClosestTime(String time) {
        List<String> candidates = getCandidates(time);
        int distance = Integer.MAX_VALUE;
        String ans = "";
        for(String cand: candidates) {
            if(cand.equals(time)) continue;
            if(computeDistance(cand, time) < distance) {
                distance = computeDistance(cand, time);
                ans = cand;
            }
        }
        if("".equals(ans)) return time;
        return ans;
    }
}