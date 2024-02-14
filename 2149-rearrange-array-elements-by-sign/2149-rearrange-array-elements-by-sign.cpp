class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
     queue<int> even;
        queue<int> odd;
        for(int a:nums)
        {
            if(a>0)
                even.push(a);
            else
                odd.push(a);
        }
        vector<int> ans;
        for(int i=0;i<nums.size();i++)
        {
            int val;
            if(i%2==0)
            {
                val=even.front();
                even.pop();
            }else
            {
                val=odd.front();
                odd.pop();
            }
            ans.push_back(val);
        }
        return ans;
    }
};