class Solution {
    long mod = 1000000007l;
    public int numWays(String[] words, String target) {
        int[][] cache = new int[words[0].length()][26];
        
        //make one 2 d array where you'll store all the count of character in that column 
        for(int i=0;i<words.length;i++){
            
            for(int j=0;j<words[i].length();j++){
            
                cache[j][words[i].charAt(j)-'a']+=1;
            
            }
        
        }
        
        return (int)(helper(0,0,words,target,new Long[target.length()+1][words[0].length()+1],cache)%mod);
        
    }
    
    public long helper(int targetInd , int kthInd , String[] words , String target,Long dp[][],int[][] cache){
        
      if(targetInd == target.length() ){
          return 1;
      }
        
     if(kthInd == words[0].length()){
          return 0;
      }
        
        if(dp[targetInd][kthInd]!=null){
            return (dp[targetInd][kthInd])%mod;
        }
        
        //not take
        long notTake = helper(targetInd,kthInd+1,words,target,dp,cache)%mod;
        
        long take = 0L;
       // max = helper(targetInd,kthInd+1,words,target,dp,cache);
        //take if freq of that character is greater than 1 in that poistion
        if((cache[kthInd][target.charAt(targetInd) - 'a'] >= 1)){
             take =
                    ((cache[kthInd][target.charAt(targetInd) - 'a']%mod)*
                     helper(targetInd+1,kthInd+1,words,target,dp,cache)%mod)%mod;
        }
               

        
       return dp[targetInd][kthInd]=(take + notTake)%mod;
        
        
        
    }
}