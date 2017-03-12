/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int lengthList(ListNode head) {
        int l = 0;
        while(head != null) {
            l++;
            head = head.next;
        }
        return l;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        
        int l = lengthList(head);
        int c = 1;
        ListNode p = head;
        while(c < l / 2) {
            p = p.next;
            c++;
        }
        ListNode q = p.next;
        p.next = null;
        p = head;
        
        TreeNode treeNode = new TreeNode(q.val);
        q = q.next;
        treeNode.left = sortedListToBST(p);
        treeNode.right = sortedListToBST(q);
        
        return treeNode;
    }
}