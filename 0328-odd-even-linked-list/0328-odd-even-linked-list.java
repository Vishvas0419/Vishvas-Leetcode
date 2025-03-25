/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode odd = head; 
        ListNode even = head.next;
        ListNode evenHead = head.next;//or even
        while(even!=null && even.next!=null)
        {
            odd.next = odd.next.next;
            even.next = even.next.next;
            //move to next odd,even nodes
            odd= odd.next;
            even = even.next;
        }        
        //link the last odd node to first even node(evenHead) to retain the relative order 
        odd.next = evenHead;
        return head;
    }
}