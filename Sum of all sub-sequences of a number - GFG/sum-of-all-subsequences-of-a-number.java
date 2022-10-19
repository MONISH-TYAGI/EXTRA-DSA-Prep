//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.subsequenceSum(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int subsequenceSum(String s) {
        // code here
        long sum=0;
        for(int i=0;i<s.length();i++)
        {
            int val=s.charAt(i)-'0';
            sum+=val;
        }
        return (int)(Math.pow(2,s.length()-1)*1l*sum);
    }
}