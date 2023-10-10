class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int left=0,right=nums.size()-1;
        int first=-1;
        while(left<=right)
        {
            int mid=left+((right-left)/2);
            if(nums[mid]>=target)
            {
                first=mid;
                right=mid-1;
            }else
            {
                left=mid+1;
            }
        }
        if(first!=-1&&nums[first]!=target) first=-1;
        int second=-1;
        left=0,right=nums.size()-1;
            while(left<=right)
        {
            int mid=left+((right-left)/2);
            if(nums[mid]<=target)
            {
                second=mid;
                left=mid+1;
            }else
            {
                right=mid-1;
            }
        }
        if(second!=-1&&nums[second]!=target) second=-1;
        vector<int> ans;
        ans.push_back(first);
        ans.push_back(second);
        return ans;
    }
};