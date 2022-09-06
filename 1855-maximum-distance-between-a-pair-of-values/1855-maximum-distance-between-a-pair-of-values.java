class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max=0;
        for(int i=0;i<nums1.length;i++)
        {
            int j=binarySearch(i,nums2,nums1[i]);
            if(j!=-1)
        max=Math.max(max,j-i);
        }
        return max;
    }
    public int binarySearch(int left,int []arr,int tar)
    {
        int right=arr.length-1;
        int ans=-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]<tar)
                right=mid-1;
            else
            {
                ans=mid;
                left=mid+1;
            }
        }
        return ans;
    }
}