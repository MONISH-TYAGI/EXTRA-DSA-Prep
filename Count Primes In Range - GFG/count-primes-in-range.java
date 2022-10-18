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
            String S[] = read.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            System.out.println(ob.countPrimes(L, R));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
  static  boolean []primes=new boolean[1000000];
   static void createSieve(){
        
       Arrays.fill(primes,2,primes.length,true);
       for(int i=2;i*i<primes.length;i++)
       {
           if(primes[i]==true)
           {
               for(long j=i*i;j<primes.length;j=j+i)
               primes[(int)j]=false;
           }
       }
       
    }
    public ArrayList<Integer> generatePrimes(int N)
    {
        ArrayList<Integer> obj=new ArrayList<>();
        for(int i=2;i<=N;i++)
        {
            if(primes[i]==true)
            obj.add(i);
        }
        return obj;
    }
    int countPrimes(int L, int R) {
        // code here
        if(L==1||L==0)L=2;
        createSieve();
    ArrayList<Integer> obj=generatePrimes((int)Math.sqrt(R));  
    int []dummy=new int[R-L+1];
    
    for(int i=0;i<R-L+1;i++)
    {
        dummy[i]=1;
    }
    for(int pr:obj)
    {
        int firstMultiple=(L/pr)*pr;
        if(firstMultiple<L)firstMultiple+=pr;
        for(int j=Math.max(firstMultiple,pr*pr);j<=R;j+=pr)
        {
            dummy[j-L]=0;
        }
        
    }
    int count=0;
    for(int i=L;i<=R;i++)
    {
        if(dummy[i-L]==1)
        count++;
    }
    return count;
    }
};