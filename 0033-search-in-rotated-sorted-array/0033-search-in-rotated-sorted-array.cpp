class Solution {
public:
    int search(vector<int>& arr, int target) {
        int lo=0,hi=arr.size()-1;
        while(lo<=hi)
        {
            int mid=lo+((hi-lo)/2);
            if(arr[mid]==target) return mid;
         else if(arr[lo]<=arr[mid])
         {
             if(arr[lo]<=target&&target<=arr[mid])
                 hi=mid;
             else
                 lo=mid+1;
         }else if(arr[mid]<=arr[hi])
         {
           if(arr[mid]<=target&&target<=arr[hi])
                 lo=mid;
             else
                 hi=mid-1;  
         }
        }
        return -1;
    }
};