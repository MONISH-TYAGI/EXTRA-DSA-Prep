class Solution {
    public void swap(int []nums1,int i,int j)
    {
        int temp=nums1[i];
        nums1[i]=nums1[j];
        nums1[j]=temp;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m;i<nums1.length;i++)
            nums1[i]=nums2[i-m];
        for(int i=m;i<nums1.length;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(nums1[j]>nums1[j+1])
                {
                    swap(nums1,j,j+1);
                }else
                    break;
            }
        }
    }
}