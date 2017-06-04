    private int ceilIndex(Sum[] sum, int key) {
        // return the leftmost index which value equals to key or the smallest value larger than key
        int l = 0, r = sum.length - 1;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(key <= sum[m].val) {
                r = m;
            } else if(key > sum[m].val) {
                l = m + 1;
            }
        }
        if(l < sum.length && sum[l].val < key) return l + 1;
        return l;
    }
    
    private int floorIndex(Sum[] sum, int key) {
        // return the rightmost index which value equals to key or the largest value smaller than key
        int l = 0, r = sum.length - 1;
        while(l < r) {
            int m = l + (r - l + 1) / 2;
            if(key < sum[m].val) {
                r = m - 1;
            } else if(key >= sum[m].val) {
                l = m;
            }
        }
        if(r >= 0 && sum[r].val > key) return r - 1;
        return r;
    }
    