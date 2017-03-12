public class Solution {
    private int res;
    void mergeSort(int[] nums, int start, int end) {
        if(start == end) return ;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        int i = start, j = mid + 1;
        while(i <= mid && j <= end) {
            if((long)nums[i] < 2 * (long)nums[j]) i++;
            else if(nums[i] > 2 * (long)nums[j]) {res += mid - i + 1;j++;}
            else { //if(nums[i] == nums[j])
                i++;
            }
        }
        
        
    
        
        int[] tmp = new int[end - start + 1];
         i = start;
         j = mid + 1;
         int k = 0;
        while(i <= mid && j <= end) {
            if(nums[i] < nums[j]) tmp[k++] = nums[i++];
            else tmp[k++] = nums[j++];
        }
        while(i <= mid) {
            tmp[k++] = nums[i++];
        }
        while(j <= end) {
            tmp[k++] = nums[j++];
        }
        k = 0;
        for( i = start;i <= end;++i) {
            nums[i] = tmp[k++];
        }
    }
    
    public int reversePairs(int[] nums) {
        if(nums.length <= 1) return 0;
        res = 0;
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }
}