public class Solution {
    private int ans = Integer.MAX_VALUE;
    
    private void dfs(int indexPos, int ret, ArrayList<Integer> pos, ArrayList<Integer> neg) {
        if(indexPos == pos.size()) {
            ans = Math.min(ans, ret);
            return;
        }
        
        if(pos.get(indexPos) == 0) {
            dfs(indexPos + 1, ret, pos, neg);
        } else {
            for(int i = 0;i < neg.size();++i) {
                if(neg.get(i) == 0) {
                    continue;
                }
                int a = pos.get(indexPos);
                int b = neg.get(i);
                if(a > b) {
                    pos.set(indexPos, a - b);
                    neg.set(i, 0);
                    dfs(indexPos, ret + 1, pos, neg);
                } else {
                    pos.set(indexPos, 0);
                    neg.set(i, b - a);
                    dfs(indexPos + 1, ret + 1, pos, neg);
                }
                pos.set(indexPos, a);
                neg.set(i, b);
            }
        }
    }
    
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i< transactions.length;++i) {
            int l = transactions[i][0];
            int r = transactions[i][1];
            int v = transactions[i][2];
            map.put(l, map.getOrDefault(l, 0) + v);
            map.put(r, map.getOrDefault(r, 0) - v);
        }
    
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 0) {
                pos.add(entry.getValue());
            } else if(entry.getValue() < 0) {
                neg.add(-entry.getValue());
            }
        }
        dfs(0, 0, pos, neg);
        return ans;
    }
}