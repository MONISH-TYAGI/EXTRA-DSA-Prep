class Solution {
    public int findPeakElement(int[] arr) {
        int low=0;
        int high=arr.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int tar=arr[mid];
            long lval=(mid-1>=0)?arr[mid-1]:Long.MIN_VALUE;
            long rval=(mid+1<arr.length)?arr[mid+1]:Long.MIN_VALUE;
            if(tar>lval&&tar>rval)
                return mid;
            if(lval<tar)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
        
    }
}