class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer> > map = new HashMap<>();
        for(int i = 0;i < B.length;++i) {
            map.putIfAbsent(B[i], new ArrayList<>());
            map.get(B[i]).add(i);
        }
        int[] ret = new int[A.length];
        for(int i = 0;i < A.length;++i) {
            List<Integer> list = map.get(A[i]);
            ret[i] = list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
        return ret;
    }
}