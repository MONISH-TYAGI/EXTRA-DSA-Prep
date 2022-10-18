class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean []primes=new boolean[n];
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;
        int count=0;
        for(int i=2;i<n;i++)
        {
            if(primes[i]==true)
            {
                count++;
                for(long j=1l*i*i;j<n;j=j+i)
                {
                    primes[(int)j]=false;
                }
            }
        }
        return count;
    }
}