class Solution {
    public void swap(int arr[],int i, int j)
    {
int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int removeElement(int[] nums, int val) {
        int idx=nums.length-1;
        for(int j=nums.length-1;j>=0;j--)
        {
            if(nums[j]==val)
            {
                swap(nums,idx,j);
                idx--;
            }
                
        }
        // System.out.println(idx+1);
        return idx+1;
    }
}