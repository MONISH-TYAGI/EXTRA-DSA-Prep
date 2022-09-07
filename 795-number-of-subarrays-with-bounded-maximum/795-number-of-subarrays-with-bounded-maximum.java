class Solution {
    public int numSubarrayBoundedMax(int[] arr, int left, int right) {
     int start=0;
        int end=0;
        int prev=0;
        int count=0;
        while(end<arr.length)
        {
            
            if(arr[end]<left)
            {
                count+=prev;
            }
            else if(left<=arr[end]&&arr[end]<=right)
            {
                prev=end-start+1;
                count+=prev;
                
            }else if(right<arr[end])
            {
                prev=0;
                start=end+1;
            }
            end++;
        }
        return count;
    }
}