//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String UncommonChars(String A, String B)
    {
        // code here
        HashSet<Character>hm1=new HashSet<>();
        HashSet<Character>hm2=new HashSet<>();
        for(char ch:A.toCharArray())
        hm1.add(ch);
        for(char ch:B.toCharArray())
        hm2.add(ch);
        StringBuilder res=new StringBuilder();
        for(char ch:hm1)
        {
            if(hm2.contains(ch)==false)
            res.append(ch);
        }
        for(char ch:hm2)
        {
            if(hm1.contains(ch)==false)
            res.append(ch);
        }
        char []arr= res.toString().toCharArray();
        Arrays.sort(arr);
           String str = String.copyValueOf(arr);
           if(str.length()==0)
           return "-1";
        return str;
    }
}