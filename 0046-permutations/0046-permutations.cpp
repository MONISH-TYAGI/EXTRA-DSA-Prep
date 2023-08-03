class Solution {
public:
    vector<vector<int>> helper(vector<int>&nums,vector<bool> &check)
    {
        vector<vector<int>> main;

        for(int i=0;i<nums.size();i++)
        { 
            if(check[i]==false){
                check[i]=true;
            vector<vector<int>> obj=helper(nums,check);
                if(obj.size()==0)
                {
                    vector<int> curr;
                    obj.push_back(curr);
                }
                for(int j=0;j<obj.size();j++)
                {
                    vector<int> temp=obj[j];
                    temp.insert(temp.begin(), nums[i]);
                      main.push_back(temp);
                }
                check[i]=false;
                }
        }
   return main;
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<bool> check(nums.size(),false);
        return helper(nums,check);
    }
};