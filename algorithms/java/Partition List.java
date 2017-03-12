/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode less = new ListNode(-1);
        ListNode more = new ListNode(-1);
        ListNode p = head;
        ListNode lessP = less;
        ListNode moreP = more;
        while(p != null) {
            if(p.val < x) {
                lessP.next = p;
                lessP = lessP.next;
                p = p.next;
            } else {
                moreP.next = p;
                moreP = moreP.next;
                p = p.next;
            }
        }
        moreP.next = null;
        lessP.next = more.next;
        
        return less.next;
    }
}