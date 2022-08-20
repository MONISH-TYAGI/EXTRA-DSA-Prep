class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
int n=nums.length;
        List<Integer> missingNumber=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int idx=nums[i]%(n+1);
            if(idx-1<n)
            nums[idx-1]+=n+1;
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]<n+1)
              missingNumber.add(i+1);  
        }
        return missingNumber;
        
    }
}