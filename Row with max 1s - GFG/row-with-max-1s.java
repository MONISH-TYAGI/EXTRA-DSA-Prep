// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
     public int findFirstOcc(int []nums,int target,int high)
    {
            int low=0;
        // int high=nums.length-1;
        while(low<=high)
        {
           int mid=low+((high-low)/2);
            if(nums[mid]>=target)
                high=mid-1;
            else if(nums[mid]<target)
                low=mid+1;
        }
        if(low==-1||low==nums.length||nums[low]!=target)
        return -1;
        return low;
    }
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        // int low=0;
        int maxIdx=-1;
        int max=0;
        int high=m-1;
        for(int i=0;i<arr.length;i++)
        {
       int currIdx=findFirstOcc(arr[i],1,high);    
    //   System.out.println("curr->"+currIdx);
            if(currIdx!=-1)
            {
             if(max<arr[0].length-currIdx)
             {
                 maxIdx=i;
                 max=arr[0].length-currIdx;
                 high=currIdx-1;
              }
                }
        }
        return maxIdx;
    }
}