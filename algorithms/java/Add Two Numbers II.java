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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = lengthList(l1);
        int len2 = lengthList(l2);
        
        ListNode dumpHead = new ListNode(-1);
        ListNode p = dumpHead;
        while(len1 > len2) {
            p.next = new ListNode(l1.val);
            p = p.next;
            l1 = l1.next;
            len1--;
        }
        
        while(len2 > len1) {
            p.next = new ListNode(l2.val);
            p = p.next;
            l2 = l2.next;
            len2--;
        }
        
        while(l1 != null && l2 != null) {
            p.next = new ListNode(l1.val + l2.val);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode head = reverseList(dumpHead.next);
        
        int c = 0;
        p = head;
        while(p != null) {
            int s = p.val + c;
            System.out.println("s: " + s);
            p.val = s % 10;
            c = s / 10;
            if(p.next == null) break;
            p = p.next;
        }
        if(c != 0) {
            p.next = new ListNode(c);
        }
        
        return reverseList(head);
    }
}