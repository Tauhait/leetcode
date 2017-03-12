/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode copyHead = new RandomListNode(head.label);
        RandomListNode p = head;
        RandomListNode q = copyHead;
        map.put(p, q);
        
        while(p.next != null) {
            q.next = new RandomListNode(p.next.label);
            p = p.next;
            q = q.next;
            map.put(p, q);
        }
        
        p = head;
        q = copyHead;
        while(p != null) {
            if(p.random == null) q.random = null;
            else q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        
        return copyHead;
    }
}