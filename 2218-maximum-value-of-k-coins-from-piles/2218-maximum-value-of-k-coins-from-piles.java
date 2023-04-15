class Solution {
    public long helper(int currPile,List<List<Integer>> piles,int k,Long dp[][])
    {
        if(k==0||currPile==piles.size())
            return 0;
        if(dp[currPile][k]!=null) return dp[currPile][k];
        long prefixSum=0;
        long max=0;
        long res=helper(currPile+1,piles,k,dp);
       for(int j=0;j<Math.min(piles.get(currPile).size(),k);j++)
       {
           prefixSum+=piles.get(currPile).get(j);
         res=Math.max(res,prefixSum+helper(currPile+1,piles,k-j-1,dp));           
       }
        return dp[currPile][k]=res;
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        Long [][]dp=new Long[piles.size()+1][k+1];
        return (int)helper(0,piles,k,dp);
    }
}