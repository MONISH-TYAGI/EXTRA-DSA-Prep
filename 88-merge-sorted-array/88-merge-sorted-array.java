class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m;i<nums1.length;i++)
            nums1[i]=nums2[i-m];
        int prev=0;
       for(int gap=(n+m)/2;gap>=1;gap=(gap)/2)
       {
          if(prev%2==1) gap++;
           System.out.println("gap->"+gap);
           for(int i=0;i<nums1.length;i++)
           {
               if(i+gap<nums1.length)
               {
                  if(nums1[i]>nums1[i+gap])
                  {
                      int temp=nums1[i];
                      nums1[i]=nums1[i+gap];
                      nums1[i+gap]=temp;
                  }
               }else
               {
                   prev=gap;
                   break;
               }
           }
           prev=gap;
       }
        // return 0.0;
    }
}