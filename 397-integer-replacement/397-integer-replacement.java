class Solution {
    public int integerReplacement(long n) {
int res=0;
        while(n!=1)
        {
            if(n%2==0)
                n=n/2;
            else if(n==3)
                n=n-1;
            else if(n%4==1)
                n=n-1;
            else if(n%4==3)
                n=n+1;
            res++;
        }
        return res;
        
    }
}