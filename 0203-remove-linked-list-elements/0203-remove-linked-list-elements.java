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
    public ListNode removeElements(ListNode head, int val) {
        // Remove all occurrences of 'val' at the beginning of the list
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            if (temp.val == val) {
                prev.next = temp.next; // Remove the node
            } else {
                prev = temp; // Move prev forward only when no deletion
            }
            temp = temp.next; // Move temp forward
        }
        return head;
    }
}
