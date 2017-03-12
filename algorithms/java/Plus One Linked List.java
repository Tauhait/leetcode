/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode p = head;
        ListNode q = head.next;
        while(q != null) {
            ListNode t = q.next;
            q.next = p;
            
            p = q;
            q = t;
        }
        head.next = null;
        
        return p;
    }
    
    public ListNode plusOne(ListNode head) {
        if(head == null) return head;
        
        head = reverseLinkedList(head);
        
        int c = 1;
        ListNode p = head;
        while(p != null) {
            int s = p.val + c;
            p.val = s % 10;
            c = s / 10;
            p = p.next;
        }
        
        p = reverseLinkedList(head);
        
        if(c != 0) {
            ListNode newHead = new ListNode(c);
            newHead.next = p;
            return newHead;
        }
        
        return p;
    }
}