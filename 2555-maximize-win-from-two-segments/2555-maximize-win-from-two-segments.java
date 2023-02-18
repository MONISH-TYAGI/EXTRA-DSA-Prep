class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int []dp=new int[prizePositions.length+1];
        int res=0;
        int n=prizePositions.length;
        int j=0;
        for(int i=0;i<n;i++)
        {
            
            while(prizePositions[i]-prizePositions[j]>k)
                j++;
           // if(j!=0){
            dp[i]=Math.max(i-j+1,(i-1>=0)?dp[i-1]:0);
            res=Math.max(res,(j-1>=0)?i-j+1+dp[j-1]:i-j+1);
           // }else{
            // dp[i]=i-j+1;
            // res=Math.max(res,i-j+1);
           // }
            //        ans = max(ans, i - start + 1 + (start > 0 ? dp[start - 1] : 0));
            // dp[i] = max((i > 0 ? dp[i - 1] : 0), i - start + 1);
            
        }
        return res;
        
    }
}