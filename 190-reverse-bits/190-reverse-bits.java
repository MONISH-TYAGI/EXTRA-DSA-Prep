public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int ans=0;
        boolean flag=false;
        int j=0;
      for(int i=31;i>=0;i--)
      {
int bit=(1<<i);
          if((n&bit)!=0)
          {
              ans|=(1<<j);
              
      }
          j++;

    }
                return ans;
}
}