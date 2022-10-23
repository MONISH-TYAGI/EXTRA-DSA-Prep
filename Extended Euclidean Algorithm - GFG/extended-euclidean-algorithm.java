//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            Solution ob = new Solution();
            int v[] = ob.gcd(a,b);
            System.out.println(v[0] + " " + v[1] + " " + v[2]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
static int[]euclid(int a,int b)
{
if(b==0)
{
    return new int[]{1,0,a};
}
int []dash=euclid(b,a%b);
return new int[]{dash[1],dash[0]-(a/b)*dash[1],dash[2]};
}
    static int[] gcd(int a,int b){
        // code h
        int []ans=euclid(a,b);
        int temp=ans[2];
        ans[2]=ans[0];
        ans[0]=temp;
        temp=ans[1];
        ans[1]=ans[2];
        ans[2]=temp;
        return ans;
    }
}