class Solution {
public:
    int upper_bound(vector<vector<int>>& arr,int element)
    {
        int lo=0,hi=arr.size()-1;
        int mid;
        while(hi-lo>1)
        {
             mid=lo+((hi-lo)/2);
            if(arr[mid][0]<=element)
                lo=mid+1;
            else
                hi=mid;
        }if(arr[lo][0]>element)
            return lo;
        if(arr[hi][0]>element)
            return hi;
        return arr.size();
    }
        int upper_bound2(vector<int>arr,int element)
    {
        int lo=0,hi=arr.size()-1;
        int mid;
        while(hi-lo>1)
        {
             mid=lo+((hi-lo)/2);
            if(arr[mid]<=element)
                lo=mid+1;
            else
                hi=mid;
        }if(arr[lo]>element)
            return lo;
        if(arr[hi]>element)
            return hi;
        return arr.size();
    }
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int idx=upper_bound(matrix,target);
        cout<<"idx-> "<<idx;
        if(idx==0) return false;
        if(matrix[idx-1][0]==target)return true;
        if(matrix[idx-1][0]<target)
        {
          int otherIdx=upper_bound2(matrix[idx-1],target);
            if(matrix[idx-1][otherIdx-1]==target)return true;
            else
                return false;
        }else
            return false;
    }
};