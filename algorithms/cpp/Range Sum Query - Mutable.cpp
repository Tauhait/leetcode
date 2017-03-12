struct SegmentTree {
  int l, r;
  int sum;
  SegmentTree* left;
  SegmentTree* right;

  SegmentTree(const int& _l, const int& _r, const int& _s = 0)
      : l(_l),
        r(_r),
        sum(_s) {
    left = NULL;
    right = NULL;
  }
};

class NumArray {
 public:
  SegmentTree* root;
  vector<int> sums;
  NumArray(vector<int>& nums) {
    int n = nums.size();
    if (n == 0) {
      root = NULL;
      return;
    }

    // region sums
    sums.resize(n);
    sums[0] = nums[0];
    for (int i = 1; i < n; ++i) {
      sums[i] = sums[i - 1] + nums[i];
    }

    // build segment tree
    root = new SegmentTree(0, n - 1, sums[n - 1]);
    buildSegmentTree(root);
  }

  void buildSegmentTree(SegmentTree* p) {
    if (p == NULL)
      return;
    if (p->l >= p->r)
      return;

    int mid = (p->r + p->l) / 2, s = 0;
    // left
    s = p->l == 0 ? sums[mid] : sums[mid] - sums[p->l - 1];
    p->left = new SegmentTree(p->l, mid, s);

    // right
    p->right = new SegmentTree(mid + 1, p->r, sums[p->r] - sums[mid]);

    buildSegmentTree(p->left);
    buildSegmentTree(p->right);
  }

  void updateSegmentTree(SegmentTree* p, const int& index, const int& diff) {
    if (p == NULL)
      return;
    if (index < p->l)
      return;
    if (index > p->r)
      return;

    p->sum += diff;

    updateSegmentTree(p->left, index, diff);
    updateSegmentTree(p->right, index, diff);
  }

  int getIndexValue(SegmentTree* p, const int& index) {
    if (p == NULL) {
      return 0;
    }

    if (p->l == p->r) {
      return p->sum;
    }

    int mid = (p->l + p->r) / 2;
    if (index >= mid + 1) {
      return getIndexValue(p->right, index);
    }

    return getIndexValue(p->left, index);
  }

  void update(int i, int val) {
    int org_val = getIndexValue(root, i);
    int diff = val - org_val;
    updateSegmentTree(root, i, diff);
  }

  int calculateRangeSum(SegmentTree* p, int l, int r) {
    if (p->l == l && p->r == r) {
      return p->sum;
    }

    int mid = (p->r + p->l) / 2;
    if (r <= mid) {
      return calculateRangeSum(p->left, l, r);
    }

    if (l >= mid + 1) {
      return calculateRangeSum(p->right, l, r);
    }
    return calculateRangeSum(p->left, l, mid)
        + calculateRangeSum(p->right, mid + 1, r);
  }

  int sumRange(int i, int j) {
    if (root == NULL)
      return 0;
    return calculateRangeSum(root, i, j);
  }
};


// Your NumArray object will be instantiated and called as such:
// NumArray numArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);