/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode p = head.next;
        ListNode q = reverseList(p);
        p.next = head;
        head.next = null;
        
        return q;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode p = dumpHead;
        int c = 1;
        while(c < m) {
            c++;
            p = p.next;
        }
        //System.out.println("p: " + p.val);
        ListNode reverseHead = p.next;
        p.next = null;
        ListNode q = reverseHead;
        
        while(c < n) {
            c++;
            q = q.next;
        }
        ListNode lastHead = q.next;
        q.next = null;
        System.out.println("q: " + q.val);
        q = reverseList(reverseHead);
        
        p.next = q;
        reverseHead.next = lastHead;
        
        return dumpHead.next;
    }
}