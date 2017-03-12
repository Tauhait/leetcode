# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = ListNode(-1)
        p = head
        c = 0
        while l1 != None or l2 != None:
            s = c
            if l1 != None:
                s += l1.val
                l1 = l1.next
            if l2 != None:
                s += l2.val
                l2 = l2.next
            
            node = ListNode(s % 10)
            c = s // 10
            p.next = node
            p = p.next
        
        if c != 0:
            node = ListNode(c)
            p.next = node;
        
        return head.next
