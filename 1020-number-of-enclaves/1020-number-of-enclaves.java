class Solution {
    int count=0;
    public void DFS(int row,int col,int [][]grid)
    {
        if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]==0||grid[row][col]==-1)
            return ;
        count++;
        grid[row][col]=-1;
        DFS(row+1,col,grid);
        DFS(row-1,col,grid);
        DFS(row,col-1,grid);
        DFS(row,col+1,grid);
    }
    public int numEnclaves(int[][] grid) {

                   for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               if(i==0||i==grid.length-1||j==0||j==grid[0].length-1)
                   DFS(i,j,grid);
            }
        }
        count=0;
       for(int i=0;i<grid.length;i++)
       {
           for(int j=0;j<grid[0].length;j++)
           {
               if(grid[i][j]==1)
               {
                   DFS(i,j,grid);
                   
               }
           }
       }
        return count;
    }
}