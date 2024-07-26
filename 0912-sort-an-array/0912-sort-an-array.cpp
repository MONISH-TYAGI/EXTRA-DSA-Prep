class Solution {
public:
    vector<int> helperFunctionMix(vector<int> left,vector<int> right)
    {
        int first=0;
        int second=0;
        vector<int> newArr;
        while(first<left.size()&&second<right.size())
        {
            if(left[first]<=right[second]){
                newArr.push_back(left[first]);
                    first++;
            }
            else
            {
                newArr.push_back(right[second]);
                second++;
            }
        }
        while(first!=left.size())
            newArr.push_back(left[first++]);
        while(second!=right.size())
            newArr.push_back(right[second++]);
            return newArr;
    }
    vector<int> helperFunction(int left,int right,vector<int> &arr)
    {
       // cout<<left<<" "<<right<<endl;
        if(left>=right)
        {
            vector<int> ans;
            if(left==right)
                ans.push_back(arr[left]);
            return ans;
        }
          int mid=left+((right-left)/2);
        vector<int> leftArrSorted=helperFunction(left,mid,arr);
        vector<int> rightArrSorted=helperFunction(mid+1,right,arr);
        vector<int> mixArrSorted=helperFunctionMix(leftArrSorted,rightArrSorted);
        return mixArrSorted;
    }
    vector<int> sortArray(vector<int>& nums) {
      return helperFunction(0,nums.size()-1,nums);
    }
};