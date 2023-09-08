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
        ListNode reverse(ListNode first,ListNode second)
    {
        ListNode prev=null;
        ListNode curr=first;
            
        ListNode ahead=null;
            if(curr!=null)
                ahead=curr.next;
        while(curr!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=ahead;
            if(ahead!=null)
            ahead=ahead.next;
        }
            // System.out.println(prev.val);
        return prev;
        
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==1)
        {
            ListNode rNode=head;
         for(int i=1;i<right;i++)
         {
             rNode=rNode.next;
         }
            ListNode last=rNode.next;
            ListNode first=head;
            rNode.next=null;
            head=reverse(head,rNode);
            first.next=last;
            return head;
            
        }else{
        ListNode one=null,two=null,three=null,four=null;
        ListNode curr=head;
        int start=1;
        while(curr!=null)
        {
            if(start+1==left)
            {
                one=curr;
                two=curr.next;
            }
            if(start==right)
            {
                three=curr;
                four=curr.next;
            }
            start++;
            curr=curr.next;
        }
        // System.out.println(one.val+" "+two.val+" "+three.val+" "+four.val);
        // reverse(two,three);
        if(three!=null)
        three.next=null;
        if(one!=null)
        one.next=reverse(two,three);
        // System.out.println(one.next.val);
        if(two!=null)
        two.next=four;
        return head; 
        }
    }
}