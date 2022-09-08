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
    public ListNode insertionSortList(ListNode head) {
       ListNode dummy=new ListNode(-1);
ListNode curr=head.next;
        ListNode first=dummy;
        first.next=head;
        head.next=null;
        while(curr!=null)
        {
            first=dummy;
            ListNode temp=curr.next;
            if(curr.val<=first.next.val)
            {
                curr.next=first.next;
                first.next=curr;
                
            }else
            {
            ListNode run=first.next;
                ListNode prev=null;
                while(run!=null&&run.val<curr.val){
                    prev=run;
                    run=run.next;
                }
                curr.next=run;
                prev.next=curr;
            }
                
            curr=temp;
        }
        return dummy.next;
    }
}