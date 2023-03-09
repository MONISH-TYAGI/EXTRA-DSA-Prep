class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n=word.length();
        int []ans=new int[n];
        long val=0;
        for(int i=0;i<word.length();i++)
        {
            int dig=word.charAt(i)-'0';
            val=val*10+dig;
            if(val%m==0)
                ans[i]=1;
            else
                ans[i]=0;
            val=val%m;
        }

        return ans;
    }
}