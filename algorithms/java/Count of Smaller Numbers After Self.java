// binary search tree
public class Solution {
    private class TreeNode {
        int val;
        int numOfEqual;
        int numOfNodeInLeftTree;
        
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val, int numOfEqual, int numOfNodeInLeftTree, TreeNode left, TreeNode right) {
            this.val = val;
            this.numOfEqual = numOfEqual;
            this.numOfNodeInLeftTree = numOfNodeInLeftTree;
            
            this.left = left;
            this.right = right;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ret = new ArrayList<>();
        if(n == 0) {
            return ret;
        }
        
        ret.add(0);
        TreeNode root = new TreeNode(nums[n - 1], 1, 0, null, null);
        for(int i = n - 2;i >= 0;--i) {
            TreeNode p = root;
            int numOfSmaller = 0;
            while(p != null) {
                if(p.val == nums[i]) {
                    numOfSmaller += p.numOfNodeInLeftTree;
                    ret.add(numOfSmaller);
                    p.numOfEqual++;
                    break;
                } else if(p.val > nums[i]) {
                    if(p.left == null) {
                        p.left = new TreeNode(nums[i], 1, 0, null, null);
                        p.numOfNodeInLeftTree++;
                        ret.add(numOfSmaller);
                        break;
                    } else {
                        p.numOfNodeInLeftTree++;
                        p = p.left;
                    }
                } else {
                    if(p.right == null) {
                        p.right = new TreeNode(nums[i], 1, 0, null, null);
                        numOfSmaller += p.numOfEqual + p.numOfNodeInLeftTree;
                        ret.add(numOfSmaller);
                        break;
                    } else {
                        numOfSmaller += p.numOfEqual + p.numOfNodeInLeftTree;
                        p = p.right;
                    }
                }
            }
        }
        
        Collections.reverse(ret);
        return ret;
    }
}


//////////////////////////////
// merge sort
class Solution {
    private class Tuple {
        int val;
        int index;
        int numOfSmaller;
        
        public Tuple(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    private void swap(Tuple[] tuples, int i, int j) {
        Tuple t = tuples[i];
        tuples[i] = tuples[j];
        tuples[j] = t;
    }
    
    private Tuple[] tuples;
    
    private void mergeSort(int l, int r) {
        if(l >= r) return ;
        if(l + 1 == r) {
            if(tuples[l].val > tuples[r].val) {
                tuples[l].numOfSmaller++;
                swap(tuples, l, r);
            }
            return ;
        }
        
        int m = l + (r - l) / 2;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        
        Tuple[] tmp = new Tuple[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;
        while(i <= m && j <= r) {
            if(tuples[i].val == tuples[j].val) {
                int count = j - (m + 1);
                tuples[i].numOfSmaller += count;
                tmp[k++] = tuples[i++];
                while(i <= m && tuples[i].val == tuples[i - 1].val) {
                    tuples[i].numOfSmaller += count;
                    tmp[k++] = tuples[i++];
                }
                tmp[k++] = tuples[j++];
                while(j <= r && tuples[j].val == tuples[j - 1].val) {
                    tmp[k++] = tuples[j++];
                }
            } else if(tuples[i].val < tuples[j].val) {
                tuples[i].numOfSmaller += j - (m + 1);
                tmp[k++] = tuples[i++];
            } else {
                tmp[k++] = tuples[j++];
            }
        }
        while(i <= m) {
            tuples[i].numOfSmaller += r - (m + 1) + 1;
            tmp[k++] = tuples[i++];
            
        }
        while(j <= r) {
            tmp[k++] = tuples[j++];   
        }
        
        k = 0;
        for(int p = l;p <= r;++p) {
            tuples[p] = tmp[k++];
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        tuples = new Tuple[n];
        for(int i = 0;i < n;++i) {
            tuples[i] = new Tuple(nums[i], i);
        }
        
        mergeSort(0, n - 1);
        int[] ret = new int[n];
        for(int i = 0;i < n;++i) {
            ret[tuples[i].index] = tuples[i].numOfSmaller;
        }
        List<Integer> r = new ArrayList<>();
        for(int c: ret) {
            r.add(c);
        }
        return r;
    }
}
