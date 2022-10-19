class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long A=a,B=b;
        long mod=1000000007;
        long left=Math.min(a,b);
        long right=(long)n*Math.min(a,b);
        while(B>0)
        {
            long temp=A;
            A=B;
            B=temp%A;
        }
        long lcm=(a*b)/A;
        while(left<right)
        {
            long m=left+(right-left)/2;
            if((m/a)+(m/b)-(m/lcm)<n)
                left=m+1;
            else right=m;
            
        }
        return (int)(left%mod);
    }
}