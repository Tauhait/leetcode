class Solution {
public:
    int partition(vector<int>& nums, const int& l, const int& r, const int& k) {
        int pivot = nums[l];
        int low = l, high = r;
        while(low < high) {
            while(nums[low] <= pivot) low++;
            while(nums[high] > pivot) high--;
            if(low < high) swap(nums[low], nums[high]);
        }
        
        swap(nums[l], nums[high]);
        
        if(k == high) return nums[high];
        else if(k < high) return partition(nums, l, high - 1, k);
        else return partition(nums, high + 1, r, k);
    }
    
    int findKthLargest(vector<int>& nums, int k) {
        return partition(nums, 0, nums.size() - 1, nums.size() - k);    
    }
};