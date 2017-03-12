/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        int carry = 0;
        ListNode p = head;
        while(l1 != null && l2 != null) {
            int s = l1.val + l2.val + carry;
            p.next = new ListNode(s % 10);
            p = p.next;
            carry = s / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
            int s = l1.val + carry;
            p.next = new ListNode(s % 10);
            p = p.next;
            carry = s / 10;
            l1 = l1.next;
        }
        while(l2 != null) {
            int s = l2.val + carry;
            p.next = new ListNode(s % 10);
            p = p.next;
            carry = s / 10;
            l2 = l2.next;
        }
        
        if(carry != 0) {
            p.next = new ListNode(carry);
        }
        
        return head.next;
    }
}