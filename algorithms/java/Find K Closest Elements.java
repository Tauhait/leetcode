public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> ret = new ArrayList<>();
        if(k == 0) return ret;
        
        int pos = Collections.binarySearch(arr, x);
        int i = -1, j = -1;
        if(pos >= 0) {
            k--;
            i = pos - 1;
            j = pos + 1;
        } else {
            int insertPos = -(pos + 1);
            i = insertPos - 1;
            j = insertPos;
        }
        
        while(k > 0) {
            if(i >= 0 && j < arr.size()) {
                if(Math.abs(x - arr.get(i)) <= Math.abs(x - arr.get(j))) {
                    i--;
                    k--;
                } else {
                    j++;
                    k--;
                }  
            } else if(i < 0) {j++;k--;}
            else {i--;k--;};
        }
        for(int p = i + 1;p < j;++p) {
            ret.add(arr.get(p));
        }
        return ret;
    }
}