/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        HashMap<ListNode,Integer>mpp = new HashMap<>();
        while(temp!=null)
        {
            if(mpp.containsKey(temp)) //if node is already visited loop ends
            {
                return true;
            }
            mpp.put(temp,1); //else add current node to HashMap
            temp = temp.next; //and move to next node to check
        }
        return false;
    }
}