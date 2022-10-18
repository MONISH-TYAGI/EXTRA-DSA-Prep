//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = new String[2];
            S = read.readLine().split(" "); 
            long a = Integer.parseInt(S[0]);
            long b = Integer.parseInt(S[1]);
            Solution ob = new Solution();

            System.out.println(ob.commDiv(a, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    static long GCD(long a,long b)
    {
        if(a==0) return b; 
        return GCD(b%a,a);
    }
    static ArrayList<Long> getFactorization(long z)
    {
        ArrayList<Long>obj=new ArrayList<>();
        for(int i=2;i*i<=z;i++)
        {
            while(z%i==0)
            {
                obj.add(i*1l);
                z=z/i;
            }
        }
        if(z>1)obj.add(z);
        return obj;
    }
    static long commDiv(long a, long b){
        // code here
        long gcd=GCD(a,b);
        
        if(gcd==1) return 1;
        ArrayList<Long>list =getFactorization(gcd);
        long ans=1;
        long count=1;
        for(int i=1;i<list.size();i++)
        {
            if(list.get(i)==list.get(i-1))
            count++;
            else{
            ans=ans*(count+1);
            count=1;
            }
    }
    ans=ans*(count+1);
    return ans;
}
}