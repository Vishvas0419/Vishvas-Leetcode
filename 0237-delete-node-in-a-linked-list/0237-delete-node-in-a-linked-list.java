/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val; //simply overwrite the value of delNode with the next node of delNode to bypass it 
        node.next = node.next.next; //ignore the next node
    }
}