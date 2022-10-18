//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            long L = Long.parseLong(a[0]);
            long R = Long.parseLong(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.primeProduct(L, R));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     static  boolean []primes=new boolean[1000001];
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
        static public ArrayList<Integer> generatePrimes(int N)
    {
        ArrayList<Integer> obj=new ArrayList<>();
        for(int i=2;i<=N;i++)
        {
            if(primes[i]==true)
            obj.add(i);
        }
        return obj;
    }
    static long primeProduct(long L, long R){
        // code here
        if(L==1||L==0)L=2;
        createSieve();
    ArrayList<Integer> obj=generatePrimes((int)Math.sqrt(R));  
    int []dummy=new int[(int)(R-L+1)];
    
    for(int i=0;i<R-L+1;i++)
    {
        dummy[i]=1;
    }
    for(int pr:obj)
    {
        int firstMultiple=((int)(L/pr))*pr;
        if(firstMultiple<L)firstMultiple+=pr;
        for(int j=Math.max(firstMultiple,pr*pr);j<=R;j+=pr)
        {
            dummy[(int)(j-L)]=0;
        }
        
    }
    // for(int a:dummy)
    // {
    //     System.out.print(a+" - ");
    // }
    long count=1;
    int mod=1000000007;
    for(long i=L;i<=R;i++)
    {
        if(dummy[(int)(i-L)]==1)
        count=((count%mod)*(i%mod))%mod;
    }
    return count;
    }
}