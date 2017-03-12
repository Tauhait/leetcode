/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        int n = 0;
        ListNode p = head;
        while(p != null) {
            n++;
            p = p.next;
        }
        int ss = 0;
        p = head;
        ListNode q = head.next;
        while(ss < n / 2 - 1) {
            p = p.next;
            q = q.next;
            ss++;
        }
        p.next = null;
        p = sortList(head);
        q = sortList(q);
        
        //merge
        ListNode s = new ListNode(-1);
        ListNode t = s;
        while(p != null && q != null) {
            if(p.val <= q.val) {
                t.next = p;
                p = p.next;
                t = t.next;
            } else {
                t.next = q;
                q = q.next;
                t = t.next;
            }
        }
        while(p != null) {
            t.next = p;
            t = t.next;
            p = p.next;
        }
        while(q != null) {
            t.next = q;
            t = t.next;
            q = q.next;
        }
        
        return s.next;
    }
}