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
    class Pair{
        int val;
        int idx;
        Pair(int val,int idx)
        {
            this.val=val;
            this.idx=idx;
        }
    }
    public int[] nextLargerNodes(ListNode head) {
  int size=0;
        ListNode curr=head;
        while(curr!=null)
        {
            size++;
            curr=curr.next;
        }
        int []arr=new int[size];
    curr=head;
        int idx=0;
    Stack<Pair> stk=new Stack<>();
while(curr!=null)
{
    while((stk.size()>0)&&(stk.peek().val<curr.val))
    {
        arr[stk.peek().idx]=curr.val;
        stk.pop();
    }
    
    stk.push(new Pair(curr.val,idx));
    idx++;
    curr=curr.next;
}
        return arr;
    }
}