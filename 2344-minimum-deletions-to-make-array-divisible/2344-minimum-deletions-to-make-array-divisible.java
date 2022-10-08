class Solution {
    
    public long GCD(long min,long max)
    {
        if(min==0l)return max;
        return GCD(max%min,min);
    }


    public int minOperations(int[] nums, int[] numsDivide) {
        long gcd=numsDivide[0];
        for(int a:numsDivide){
        gcd=GCD(a,gcd);
        }
      Arrays.sort(nums);
        int count=0;
for(int i=0;i<nums.length;i++)
{
    if(gcd%nums[i]==0)
        return i;
}
        return -1;
    }
}