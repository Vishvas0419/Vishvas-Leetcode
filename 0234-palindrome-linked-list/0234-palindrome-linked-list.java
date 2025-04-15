/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 1. Find middle node
 2.reverse from middle.next node till last node
 3.now check for both halves data if not equal then first reverse the ll to its orginal form then return false else return true if any of the heads reaches null
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = head; 
        ListNode newHead = reverse(slow.next);
        ListNode second = newHead; 
        while(second!=null)
        {
            if(first.val!=second.val)
            {
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }        
        reverse(newHead);
        return true;
    }
     public ListNode reverse(ListNode head)
    {
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null)
        {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front; //or temp.next
        }
        return prev;
    }
  
}