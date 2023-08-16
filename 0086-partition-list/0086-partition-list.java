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
    public ListNode partition(ListNode head, int x) {
     ListNode dummy1=new ListNode(-1);
        ListNode dummy2=new ListNode(-1);
        ListNode h1=dummy1;
        ListNode h2=dummy2;
        while(head!=null)
        {
            if(head.val<x)
            {
                h1.next=head;
                h1=h1.next;
            }else
            {
                h2.next=head;
                h2=h2.next;
            }
            head=head.next;
        }
        h1.next=dummy2.next;
        h2.next=null;
        return dummy1.next;
    }
}