/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        
        ListNode p = head;
        ListNode podd = odd;
        ListNode peven = even;
        while(p != null) {
            podd.next = p;
            podd = podd.next;
            p = p.next;
            
            if(p == null) {
                break;
            } else {
                peven.next = p;
                peven = peven.next;
                p = p.next;
            }
        }
        podd.next = even.next;
        peven.next = null;
        
        return odd.next;
    }
}