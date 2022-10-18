//{ Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution
{
    public int[] AllPrimeFactors(int N)
    {
        // code here
        ArrayList<Integer>primeFactors=new ArrayList<>();
        for(int i=2;i*i<=N;i++)
        {
            boolean isFactor=(N%i==0)?true:false;
            while(N%i==0)
            {
                N=N/i;
            }
            if(isFactor==true)primeFactors.add(i);
        }
        if(N>1)primeFactors.add(N);
        int []res=new int[primeFactors.size()];
        for(int i=0;i<res.length;i++)
        {
            res[i]=primeFactors.get(i);
        }
        return res;
    }
}