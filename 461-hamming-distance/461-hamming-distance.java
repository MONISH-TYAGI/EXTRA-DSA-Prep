class Solution {
    public int hammingDistance(int x, int y) {
    int N=x^y;
        int count=0;
        while(N>0)
        {
            int rmsb=N&(-N);
            N=N^rmsb;
            count++;
        }
        return count;
    }
}