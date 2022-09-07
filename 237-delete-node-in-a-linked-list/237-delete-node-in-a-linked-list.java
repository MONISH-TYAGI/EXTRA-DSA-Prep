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
        ListNode prev=node;
        ListNode curr=node.next;
        while(curr!=null)
        {
            prev.val=curr.val;
            if(curr.next!=null)
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;
        
    }
}