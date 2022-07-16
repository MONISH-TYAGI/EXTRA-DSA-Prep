class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int n=nums1.length+nums2.length;
        int nby2=(n+1)/2;
        int low=0;
        int high=nums1.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int aleft=(mid-1>=0)?nums1[mid-1]:Integer.MIN_VALUE;
            int aright=(mid<nums1.length)?nums1[mid]:Integer.MAX_VALUE;
            int bleft=(nby2-mid-1>=0)?nums2[nby2-mid-1]:Integer.MIN_VALUE;
            int bright=(nby2-mid<nums2.length)?nums2[nby2-mid]:Integer.MAX_VALUE;
            if(aleft<=bright&&bleft<=aright)
            {
                if(n%2==1)
                    return Math.max(aleft,bleft);
                else
                {
int[] arr = {aleft, bleft, aright, bright};
                    Arrays.sort(arr);
                    return (arr[1] + arr[2]) / 2.0;

                }
            }else
            {
                if(aleft>bright)
                    high=mid-1;
                else
                    low=mid+1;
            }
        }
        return 0.0;
    }
}