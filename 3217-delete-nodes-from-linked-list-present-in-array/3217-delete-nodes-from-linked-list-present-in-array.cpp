/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        unordered_set<int> mp;
        for(int a:nums)
            mp.insert(a);
        ListNode* curr=head;
        ListNode* prev=head;
        while(head!=nullptr&&mp.find(head->val)!=mp.end())
        {
            head=head->next;
        }
      while(curr!=nullptr)
      {
          int num=curr->val;
          if(mp.find(num)!=mp.end())
          {

              prev->next=curr->next;
              curr=curr->next;
              
          }else
          {
              prev=curr;
              curr=curr->next;
          }
          
      }
        return head;
    }
};