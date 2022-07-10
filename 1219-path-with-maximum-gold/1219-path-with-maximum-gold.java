class Solution {
    public int [][]dir={{0,-1},{1,0},{0,1},{-1,0}};
    public int DFS(int row,int col,int [][]grid)
    {
                if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]==0||grid[row][col]==-1)
        return 0;
        int val=grid[row][col];
        grid[row][col]=-1;
        int max=0;
         for(int i=0;i<4;i++)
     {
         row=row+dir[i][1];
         col=col+dir[i][0];
        max=Math.max(max,DFS(row,col,grid));
          row=row-dir[i][1];
         col=col-dir[i][0];
     }
        grid[row][col]=val;
        return max+val;
    }
    public int getMaximumGold(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                max=Math.max(max,DFS(i,j,grid));
            }
        }
        return max;
    }
}