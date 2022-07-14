// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages
    public static boolean canAllocate(int []arr,int M,int mid)
    {
        int currGroup=1;
        int pages=0;
        for(int i=0;i<arr.length;i++)
        {
            if(pages+arr[i]<=mid)
            {
                pages+=arr[i];
            }
            else
            {
                pages=arr[i];
                currGroup++;
            }
            if(currGroup>M)
            return false;
        }
        return true;
    }
    public static int findLow(int []arr)
    {
        int max=0;
        for(int a:arr)
        {
            if(max<a)
            max=a;
        }
        return max;
    }
    public static int findHigh(int []arr)
    {
        int sum=0;
        for(int a:arr)
        sum+=a;
        return sum;
    }
    public static int findPages(int[]arr,int N,int M)
    {
        //Your code here
        int left=findLow(arr);
        // System.out.println("low"+left);
        int right=findHigh(arr);
                // System.out.println("low"+right);
        int ans=right;
        while(left<=right)
        {
            int mid=left+((right-left)/2);
            if(canAllocate(arr,M,mid)==true)
            {
                 ans=mid;
                right=mid-1;
            }
            else
            left=mid+1;
        
         }
        return ans;
    }
};