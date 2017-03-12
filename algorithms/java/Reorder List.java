/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int lengthList(ListNode head) {
        int l = 0;
        while(head != null) {
            l++;
            head = head.next;
        }
        return l;
    }
    
    private ListNode reverseList(ListNode head) {
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
    
    public void reorderList(ListNode head) {
        int l = lengthList(head);
        if(l <= 2) return ;
        
        ListNode p = head;
        int c = 1;
        while(c < (l + 1) / 2) {
            p = p.next;
            c++;
        }
        ListNode q = p.next;
        p.next = null;
        
        q = reverseList(q);
        
        ListNode d = head;
        p = head.next;
        while(p != null || q != null) {
            if(q != null) {
                d.next = q;
                q = q.next;
                d = d.next;
            }
        
            if(p != null) {
                d.next = p;
                p = p.next;
                d = d.next;
            }
        }
    }
}