class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0;i < flowers.length;++i) {
            int pos = flowers[i];
            Integer lower = set.lower(pos);
            Integer higher = set.higher(pos);
            if(lower != null && pos - lower - 1 == k) return i + 1;
            if(higher != null && higher - pos - 1 == k) return i + 1;
            set.add(pos);
        }
        return -1;
    }
}