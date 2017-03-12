class Solution {
 public:
  int findKth(int nums1[], const int& m, int nums2[], const int& n,
              const int& k) {
    if (m == 0)
      return nums2[k];
    if (n == 0)
      return nums1[k];
    if (k == 0)
      return min(nums1[0], nums2[0]);

    int mid1 = m / 2;
    int mid2 = n / 2;

    if (nums1[mid1] == nums2[mid2]) {
      if (k >= mid1 + mid2 + 1) {
        return findKth(nums1 + mid1 + 1, m - mid1 - 1, nums2 + mid2 + 1,
                       n - mid2 - 1, k - mid1 - mid2 - 2);
      } else {
        return findKth(nums1, mid1, nums2, mid2, k);
      }
    } else if (nums1[mid1] < nums2[mid2]) {
      if (k >= mid1 + mid2 + 1) {
        return findKth(nums1 + mid1 + 1, m - mid1 - 1, nums2, n, k - mid1 - 1);
      } else {
        return findKth(nums1, m, nums2, mid2, k);
      }
    } else {
      if (k >= mid1 + mid2 + 1) {
        return findKth(nums1, m, nums2 + mid2 + 1, n - mid2 - 1, k - mid2 - 1);
      } else {
        return findKth(nums1, mid1, nums2, n, k);
      }
    }
  }

  double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    int m = nums1.size();
    int n = nums2.size();
    if (m == 0 && n == 0)
      return 0.0;
    if (m == 0) {
      if (n % 2 == 0) {
        return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
      } else {
        return nums2[n / 2];
      }
    }
    if (n == 0) {
      if (m % 2 == 0) {
        return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
      } else {
        return nums1[m / 2];
      }
    }

    if ((m + n) % 2 == 0) {

      return (findKth(&(nums1[0]), m, &(nums2[0]), n, (m + n) / 2)
          + findKth(&(nums1[0]), m, &(nums2[0]), n, (m + n) / 2 - 1)) / 2.0;
    } else {
      return findKth(&(nums1[0]), m, &(nums2[0]), n, (m + n) / 2);
    }
  }
};