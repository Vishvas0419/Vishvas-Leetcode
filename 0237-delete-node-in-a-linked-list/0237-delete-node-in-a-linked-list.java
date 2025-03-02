class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return; 
        }
        node.val = node.next.val;  // Copy next node's value into current node
        node.next = node.next.next; // Bypass the next node
    }
}
