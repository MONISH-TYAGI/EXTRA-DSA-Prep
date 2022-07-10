// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
 public static   int [][]dir={{0,-1},{1,0},{0,1},{-1,0}};
 public static   char[]ch={'U','R','D','L'};
    public static ArrayList<String> Path;
    public static void helper(int row,int col,String psf,int [][]matrix,int n)
    {
        if(row<0||col<0||row>=n||col>=n||matrix[row][col]==0||matrix[row][col]==-1)
        return ;
        
       
        matrix[row][col]=-1;
        if(row==n-1&&col==n-1)
      {  Path.add(psf);
              matrix[row][col]=1;
      return ;
      }
     for(int i=0;i<4;i++)
     {
         row=row+dir[i][1];
         col=col+dir[i][0];
         helper(row,col,psf+ch[i],matrix,n);
          row=row-dir[i][1];
         col=col-dir[i][0];
     }
             
        matrix[row][col]=1;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        Path=new ArrayList<>();
     helper(0,0,"",m,n);
     return Path;
    }
}