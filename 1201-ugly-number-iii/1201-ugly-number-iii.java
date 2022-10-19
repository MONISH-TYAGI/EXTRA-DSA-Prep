class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lo = Math.min(Math.min(a,b),c), hi = lo*1l*n;
        long ab = lcm(a, b), ac = lcm(a, c), bc = lcm(b, c), abc = lcm(ab, c);
        while(lo < hi){
            long mid = lo + (hi - lo)/2;
            long count = 0L + mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (count >= n)
                hi = mid;
            else
                lo = mid + 1;
        }
        return (int)lo;
    }

    private long gcd(long a, long b){
        return b == 0? a : gcd(b, a % b);
    }

    private long lcm(long a, long b){
        return a * b / gcd(a, b);
    }
}