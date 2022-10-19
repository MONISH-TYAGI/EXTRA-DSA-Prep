//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap<String,Integer>hm=new HashMap<>();
        for(String str:arr)
        {
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        int firstMax=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        String ans="";
        for(String str:hm.keySet())
        {
            int val=hm.get(str);
            // System.out.println(val+" - "+str);
            if(val>firstMax){
                secondMax=firstMax;
            firstMax=val;
            
            }
            if(val>secondMax&&val<firstMax){
                secondMax=val;

            }
        }
        for(String a:hm.keySet())
        {
            int val=hm.get(a);
            if(val==secondMax)
            ans=a;
        }
        return ans;
    }
}