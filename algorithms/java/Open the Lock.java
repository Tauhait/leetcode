class Solution {
    private List<String> getCandidates(String front) {
        List<String> candidates = new ArrayList<>();
        char[] chrs = front.toCharArray();
        for(int i = 0;i < 4;++i) {
            char c = chrs[i];
            int num = (int) (chrs[i] - '0');
            chrs[i] = (char) ((num + 10 - 1) % 10 + '0');
            candidates.add(String.valueOf(chrs));
            chrs[i] = (char) ((num + 1) % 10 + '0');
            candidates.add(String.valueOf(chrs));
            chrs[i] = c;
        }
        return candidates;
    }
    
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> deadendsSet = new HashSet(Arrays.asList(deadends));
        if(deadendsSet.contains(start)) return -1;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int moves = 0;
        while(!q.isEmpty()) {
            int s = q.size();
            for(int j = 0;j < s;++j) {
                String front = q.poll();
                List<String> candidates = getCandidates(front);
                for(int i = 0;i < candidates.size();++i) {
                    String candidate = candidates.get(i);
                    if(target.equals(candidate)) return moves + 1;
                    if(deadendsSet.contains(candidate)) continue;
                    if(visited.contains(candidate)) continue;
                    visited.add(candidate);
                    q.add(candidate);
                }
            }
            moves++;
        }
        return -1;
    }
}