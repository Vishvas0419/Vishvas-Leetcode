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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return mergeTwoLists(leftHead,rightHead);
    }

    ListNode findMiddle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode mergeTwoLists(ListNode list1,ListNode list2)
    {
        ListNode t1 = list1; //temp 1
        ListNode t2 = list2; //temp 2
        ListNode dNode = new ListNode(-1);  //dummy node
        ListNode temp = dNode;
        while(t1 != null && t2 != null)
        {
            if(t1.val < t2.val)
            {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        // if t1 or t2 still have any nodes remaining
        if(t1!=null) temp.next = t1; //just pick it up
        else temp.next = t2;
        return dNode.next; //new Head 
    }
}