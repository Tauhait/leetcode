/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public class Pair implements Comparable<Pair> {
        public Pair(int v, int i) {
            val = v;
            id = i;
        }
        
        public int compareTo(Pair obj) {
            return Integer.compare(this.val, obj.val);
        }
        
        int val;
        int id;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k == 0) return null;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(k);
        for(int i = 0;i < k;++i) {
            if(lists[i] != null) {
                pq.add(new Pair(lists[i].val, i));
            }
        }
        
        ListNode dumpHead = new ListNode(-1);
        ListNode p = dumpHead;
        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            p.next = lists[top.id];
            p = p.next;
            lists[top.id] = lists[top.id].next;
            if(lists[top.id] != null) {
                pq.add(new Pair(lists[top.id].val, top.id));
            }
        }
        p.next = null;
        return dumpHead.next;
    }
}