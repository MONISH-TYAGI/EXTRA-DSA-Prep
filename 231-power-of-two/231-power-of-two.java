class Solution {
    public boolean isPowerOfTwo(int n) {
        long a=n;
        if(n==0) return false;
     return ((a&(a-1l))==0);
    }
}