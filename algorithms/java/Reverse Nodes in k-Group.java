/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode reverseListIterative(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode p = head;
        ListNode q = head.next;
        while(p != null && q != null) {
            ListNode t = q.next;
            q.next = p;
            p = q;
            q = t;
        }
        head.next = null;
        return p;
    }
    
    private ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode right = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return right;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
       /* int n = 0;
        ListNode p = head;
        while(p != null) {
            n++;
            p = p.next;
        }
        if(n == 0 || n == 1 || k == 0 || k == 1 || k > n) return head;*/
        
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        
        ListNode preHead = dumpHead;
        ListNode q = dumpHead;
        int cnt = 0;
        while(cnt < k && q != null && q.next != null) {
            q = q.next;
            cnt++;
            
            if(cnt == k) {
                ListNode first = preHead.next;
                ListNode last = q;
                ListNode temp = q.next;
                q.next = null;
                
                reverseListRecursive(first);
                preHead.next = last;
                first.next = temp;
               
                preHead = first;
                q = first;
                cnt = 0;
            }
        }
        return dumpHead.next;    
    }
}