/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private void printOutList(ListNode head) {
        while(head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }
        System.out.println();
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dumpHead = new ListNode(-1);
        
        ListNode p = dumpHead;
        ListNode q = head;
        while(q != null && q.next != null) {
            System.out.println(q.val + " " + q.next.val);
            ListNode t = q.next.next;
            p.next = q.next;
            q.next.next = q;
            q.next = null;
            
            p = q;
            q = t;
            printOutList(dumpHead.next);
        }
        if(q != null) {
            p.next = q;
        }
        
        
        return dumpHead.next;
    }
}