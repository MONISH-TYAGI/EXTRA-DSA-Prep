//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
        int N=arr.length;
        n=N;
        int left=0,right=n-1;
        if(n==1)
        return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!=arr[n-2]) return arr[n-1];
        while(left<=right)
        {
            int mid=left+(right-left);
            int leftVal=(mid-1>=0)?arr[mid-1]:arr[mid];
            int rightVal=(mid+1<n)?arr[mid+1]:arr[mid];
            if(arr[mid]!=leftVal&&arr[mid]!=rightVal)
            return arr[mid];
            // if(arr[left]<arr[mid])
            {
                leftVal=(mid-1>=0)?arr[mid-1]:Integer.MAX_VALUE;
                rightVal=(mid+1<n)?arr[mid+1]:Integer.MAX_VALUE;
                if(leftVal==arr[mid])
                {
                    if((mid-1)%2==0) left=mid+1;
                    else
                    right=mid-1;
                }else 
                {
                    if((mid)%2==0) left=mid+1;
                    else
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}