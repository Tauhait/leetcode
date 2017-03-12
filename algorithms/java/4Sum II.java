public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> mapAB = new HashMap<>();
        HashMap<Integer, Integer> mapCD = new HashMap<>();
        
        for(int i = 0;i < A.length;++i) {
            for(int j = 0;j < B.length;++j) {
                int sum = A[i] + B[j];
                if(mapAB.containsKey(sum)) {
                    mapAB.put(sum, mapAB.get(sum) + 1);
                } else {
                    mapAB.put(sum, 1);
                }
            }
        }
        
        for(int i = 0;i < C.length;++i) {
            for(int j = 0;j < D.length;++j) {
                int sum = C[i] + D[j];
                if(mapCD.containsKey(sum)) {
                    mapCD.put(sum, mapCD.get(sum) + 1);
                } else {
                    mapCD.put(sum, 1);
                }
            }
        }
        
        
        int res = 0;
        for(Map.Entry<Integer, Integer> entry: mapAB.entrySet()) {
            int key = entry.getKey();
            if(mapCD.containsKey(-key)) {
                res += entry.getValue() * mapCD.get(-key);
            }
        }
        
        return res;
    }
}