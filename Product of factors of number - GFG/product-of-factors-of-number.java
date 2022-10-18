//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.factorProduct(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long mod=1000000007;
    int factorProduct(int N) {
        // code here
               long prod=1;
        for(long i=1;i*i<=N;i++)
        {
            if(N%i==0)
            {
                prod=((prod%mod)*(i%mod))%mod;
                if(i!=N/i)prod=((prod%mod)*((N*1l)%mod/(i%mod))%mod)%mod;
            }
        }
        return (int)(prod%mod);
    }
}