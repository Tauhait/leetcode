/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
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
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head; 
        int l = lengthList(head);
        k = k % l;
        if(k == 0) return head;
        
        int c = 1;
        ListNode p = head;
        while(c < l - k) {
            c++;
            p = p.next;
        }
        
        ListNode res = p.next;
        p.next = null;
        ListNode q = res;
        while(q.next != null) {
            q = q.next;
        }
        q.next = head;
        
        return res;
    }
}