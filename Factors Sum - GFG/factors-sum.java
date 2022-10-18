//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int N = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.factorSum(N));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long factorSum(int N) 
    { 
       //code here.
       long sum=0;
        for(int i=1;i*i<=N;i++)
        {
            if(N%i==0)
            {
                sum=sum+i;
                if(i!=N/i)sum+=N/i;
            }
        }
        return sum;
    } 
}