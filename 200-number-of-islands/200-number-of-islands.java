class Solution {
    public void DFS(int row,int col,char [][]grid)
    {
        if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]=='0'||grid[row][col]=='D') return ;
        grid[row][col]='D';//Done
        DFS(row+1,col,grid);
        DFS(row,col+1,grid);
        DFS(row-1,col,grid);
        DFS(row,col-1,grid);
    }
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                   count++;
                    DFS(i,j,grid);
                }
            }
        }
        return count;
    }
}