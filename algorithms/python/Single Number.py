class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def singleNumber(self, nums):
        self = 0;
        for x in nums :
            self ^= x;
        return self;