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
        ListNode curr=head;
        if(curr==null) return head;
        ListNode prev=null;
        while(curr!=null)
        {
            if(curr.val==val)
            {
                while(curr!=null&&curr.val==val)
                    curr=curr.next;
                if(prev!=null)
                prev.next=curr;
                 }
            prev=curr;
            if(curr==null) break;
            curr=curr.next;
                
        }
        while(head!=null&&head.val==val)
            head=head.next;
        return head;
    }
}