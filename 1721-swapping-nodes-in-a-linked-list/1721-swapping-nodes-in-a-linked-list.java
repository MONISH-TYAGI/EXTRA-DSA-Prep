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
    public ListNode swapNodes(ListNode head, int k) {
        int size=0;
        ListNode curr=head;
        while(curr!=null)
        {
            size++;
            curr=curr.next;
        }
        int a=0;
        int b=0;
        curr=head;
        int count=1;
        while(curr!=null)
        {
            if(count==k)
                a=curr.val;
            if(count==size-k+1)
                b=curr.val;
            count++;
            curr=curr.next;
        }
        curr=head;
        count=1;
        while(curr!=null)
        {
            if(count==k)
                curr.val=b;
            if(count==size-k+1)
                curr.val=a;
            count++;
            curr=curr.next;
        }
        return head;
    }
}