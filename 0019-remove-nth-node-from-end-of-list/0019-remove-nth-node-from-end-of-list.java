/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head; ListNode slow = head;
        for(int i=0;i<n;i++)
        {
            fast = fast.next; //traverse fast till n
        }
        // edge case when n = length of LL(1st node to be deleted)
        if(fast == null) return head.next;
        while(fast.next != null)
        {
            slow=slow.next; //in the end slow will stand at prev of the node which is to be deleted
            fast=fast.next;
        }
        // ListNode delNode = slow.next;
        slow.next = slow.next.next; //just skip it
        return head;
    }
}