class Solution {
    public int findLongestChain(int[][] pairs) {
      Arrays.sort(pairs,(a,b)->{
          return a[1]-b[1];
      })  ;
        int len=1;
        int []check=pairs[0];
for(int i=1;i<pairs.length;i++)
{
    int []pair=pairs[i];
    if(check[1]>=pair[0]&&check[1]<=pair[1])continue;
    len++;
    check=pair;
    
}
        return len;
    }
}