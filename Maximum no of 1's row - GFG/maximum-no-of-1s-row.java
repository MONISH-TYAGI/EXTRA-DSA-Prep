//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][]arr = new int[n][m];
            
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    arr[i][j] = sc.nextInt ();

    		System.out.println (new Sol().maxOnes (arr, n, m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{ public static int findOnePos(int arr[])
{
    int left=0,right=arr.length-1;
    if(arr[0]==1) return 0;
    while(left<=right)
    {
        int mid=left+(right-left)/2;
        int leftVal=(mid-1>=0)?arr[mid-1]:Integer.MAX_VALUE;
        int rightVal=(mid+1<arr.length)?arr[mid+1]:Integer.MAX_VALUE;
        if(leftVal==0&&arr[mid]==1)
        return mid;
        if(arr[mid]==0&&rightVal==1)
        return mid+1;
        else if(arr[mid]==0)
        left=mid+1;
        else
    right=mid-1;
    }
    return arr.length;
}
    public static int maxOnes (int Mat[][], int N, int M)
    {
        // your code here
        int max=0;
        int ansIdx=-1;
        for(int i=0;i<N;i++)
        {
            int idx=findOnePos(Mat[i]);
            int count=M-idx;
            // System.out.print(count+" ");
            if(count>max)
            {
                max=count;
                ansIdx=i;
            }
        }
        return ansIdx;
    }
}