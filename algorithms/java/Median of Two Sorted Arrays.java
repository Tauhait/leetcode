public class Solution {
    /* k-th number in two sorted arrays */
    private int kThNumberInTwoSortedArrays(int[] a, int aStart, int[] b, int bStart, int k) {
        if (aStart >= a.length) {
            return b[bStart + k - 1];
        }
        if (bStart >= b.length) {
            return a[aStart + k - 1];
        }
        
        if (k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }

        int i = Math.min(a.length - 1, aStart + k / 2 - 1);
        int j = Math.min(b.length - 1, bStart + k / 2 - 1);

        if (a[i] > b[j]) {
            return kThNumberInTwoSortedArrays(a, aStart, b, j + 1, k - (j - bStart + 1));
        } else {
            return kThNumberInTwoSortedArrays(a, i + 1, b, bStart, k - (i - aStart + 1));
        }
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            throw new IllegalArgumentException("No Data");
        }
        int m = nums1.length + nums2.length;
        if (m % 2 == 1) {
            return (double) kThNumberInTwoSortedArrays(nums1, 0, nums2, 0, m / 2 + 1);
        } else {
            return (kThNumberInTwoSortedArrays(nums1, 0, nums2, 0, m / 2)
            + kThNumberInTwoSortedArrays(nums1, 0, nums2, 0, m / 2 + 1)) / 2.0;
        }
    }
}
