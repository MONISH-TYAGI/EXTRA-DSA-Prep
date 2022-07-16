class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low=0;
        int high=arr.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int tar=arr[mid];
            int lval=(mid-1>=0)?arr[mid-1]:Integer.MIN_VALUE;
            int rval=(mid+1<arr.length)?arr[mid+1]:Integer.MIN_VALUE;
            if(tar>lval&&tar>rval)
                return mid;
           else if(lval<tar&&tar<rval)
                low=mid+1;
          else   if(lval>tar&&tar>rval)
                high=mid-1;
            else
            {
                if(lval<=tar)low++;
                else high--;
            }
        }
        return -1;
    }
}