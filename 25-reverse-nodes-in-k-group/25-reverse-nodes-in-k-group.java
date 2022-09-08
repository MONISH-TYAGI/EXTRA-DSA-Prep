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
      public ListNode reverseList(ListNode head) {
    ListNode prev=null;
    ListNode curr=head;
       
        while(curr!=null)
        {
             ListNode ahead=curr.next;
            curr.next=prev;
            prev=curr;
            curr=ahead;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==1)
        {
            int count=0;
            ListNode curr=head;
            ListNode first=head;
            while(count+1!=right)
            {curr=curr.next;
             count++;}
            ListNode second=curr.next;
            curr.next=null;
            ListNode prev=reverseList(head);
            first.next=second;
            return prev;
        }else
        {
           ListNode curr=head;
            int count=0;
            while(count+2!=left)
            {
                curr=curr.next;
                count++;
            }
            ListNode first=curr;
            ListNode third=curr.next;
            curr=head;
            count=0;
            while(count+1!=right)
            {
                curr=curr.next;
                count++;
            }
            ListNode second=curr.next;
            curr.next=null;
            first.next=reverseList(first.next);
            third.next=second;
            return head;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int size=0;
        ListNode curr=head;
        while(curr!=null)
        {
            size++;
            curr=curr.next;
        }
        int num=size/k;
        int start=1;
        ListNode prev=head;
        for(int i=1;i<=num;i++)
        {
            int end=k*i;
           head= reverseBetween(head,start,end);
            start=end+1;
            // return head;
        }
        return head;
    }
}