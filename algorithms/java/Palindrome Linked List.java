/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int lengthLinkedList(ListNode head) {
        int l = 0;
        while(head != null) {
            l++;
            head = head.next;
        }
        return l;
    }
    private ListNode reverse(ListNode head) {
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        int l = lengthLinkedList(head);
        ListNode p = head;
        int i = 1;
        while(i < l / 2 && p != null) {
            p = p.next;
            i++;
        }
        ListNode q = p.next;
        p.next = null;
        
        q = reverse(q);
        p = head;
        while(p != null && q != null) {
            if(p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        
        return true;
    }
}