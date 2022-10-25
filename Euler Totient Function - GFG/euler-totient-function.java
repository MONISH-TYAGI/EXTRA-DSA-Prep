//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.ETF(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static long ETF(long n) {
        // code here
        long count=n;
        for(long i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                count=count-(count/i);
                while(n%i==0)
                {
                    n=n/i;
                }
            }
        }
        if(n>1)
        count=count-count/n;
        return count;
    }
}