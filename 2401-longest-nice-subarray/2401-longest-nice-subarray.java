class Solution {
    public int longestNiceSubarray(int[] nums) {
int left=0;
        int []bit=new int[32];
        int ans=0;
        for(int right=0;right<nums.length;right++)
        {
            boolean flag=false;
         int curr=nums[right];
            for(int i=0;i<32;i++)
            {
                if((curr & (1<<i))!=0)
                    bit[i]++;
                if(bit[i]>1)
                    flag=true;
            }
            while(flag==true)
            {
                int val=nums[left];
            for(int i=0;i<32;i++)
            {
                if((val & (1<<i))!=0)
                    bit[i]--;
            }
                boolean check=false;
                            for(int i=0;i<32;i++)
            {
                if(bit[i]>1)
                check=true;
            }
                left++;
                if(check==false)
                    break;
                
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
        
    }
}