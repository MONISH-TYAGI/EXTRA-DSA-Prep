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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode curr=head;

        while(curr!=null)
        {
            int sum=0;
                    ListNode run=curr.next;
            while(run!=null)
            {
                sum+=run.val;
                if(sum==0)
                 curr.next=run.next;
                
                run=run.next;
            }
            curr=curr.next;
        }
        curr=head;
        int sum1=head.val;
        while((head!=null&&head.val==0)||(curr!=null&&sum1!=0))
        {
            curr=curr.next;
            if(curr==null)break;
            sum1+=curr.val;
            if(sum1==0)
            head=curr.next;
        }
        if(head!=null&&head.val==0) return head.next;
        
        return head;
    }
}