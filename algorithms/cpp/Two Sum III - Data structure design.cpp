class TwoSum {
public:
    unordered_map<int, int> nums;
    // Add the number to an internal data structure.
	void add(int number) {
	    nums[number]++;
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	bool find(int value) {
	    for(unordered_map<int, int>::iterator it = nums.begin();it != nums.end();++it) {
	        int t = value - it->first;
	        if(t == it->first) {
	            if(it->second > 1) return true;
	        } else {
	            if(nums.find(t) != nums.end()) {
	                return true;
	            }
	        }
	    }
	    
	    return false;
	}
};


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum;
// twoSum.add(number);
// twoSum.find(value);