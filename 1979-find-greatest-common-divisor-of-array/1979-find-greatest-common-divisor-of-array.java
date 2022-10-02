class Solution {
    public int findGCD(int[] nums) {
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
        for(int a:nums)
        {
            min=Math.min(a,min);
            max=Math.max(a,max);
        }
    return GCD(min,max);
    }
    public int GCD(int min,int max)
    {
        if(min==0)return max;
        return GCD(max%min,min);
    }
}