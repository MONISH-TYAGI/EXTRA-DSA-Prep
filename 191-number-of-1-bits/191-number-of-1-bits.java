public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int N) {

                int count=0;
        while(N!=0)
        {
            N=N&(N-1);
            count++;
        }
        return count;
    }
}