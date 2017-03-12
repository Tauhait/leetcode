/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int LengthLinkedList(ListNode head) {
        int l = 0;
        while(head != null) {
            l++;
            head = head.next;
        }
        return l;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        int lA = LengthLinkedList(headA);
        int lB = LengthLinkedList(headB);
        
        
        
        ListNode p = headA;
        ListNode q = headB;
        while(lA > lB) {
            p = p.next;
            lA--;
        }
        while(lB > lA) {
            q = q.next;
            lB--;
        }
        
        while(p != null && q != null) {
            if(p == q) return q;
            p = p.next;
            q = q.next;
        }
        
        return null;
    }
}