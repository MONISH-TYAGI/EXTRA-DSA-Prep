class Solution {
    class Pair{
int row;
    int col;
        int time;
    Pair(int row,int col,int time)
    {
        this.row=row;
        this.col=col;
        this.time=time;
    }}
    int [][]dir={{0,1},{1,0},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        Queue<Pair>q=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            { 
                if(grid[i][j]==2)
                q.add(new Pair(i,j,0));
            }
        }
        int min=0;
        while(q.size()>0)
        {
            Pair front=q.remove();
            if( grid[front.row][front.col]==3) continue;
            min=Math.max(min,front.time);
            grid[front.row][front.col]=3;
            for(int i=0;i<4;i++)
            {
                int nr=front.row+dir[i][0];
                int nc=front.col+dir[i][1];
                if(nr<0||nc<0||nr>=grid.length||nc>=grid[0].length) continue;
                if(grid[nr][nc]==3||grid[nr][nc]==0)
                    continue;
                q.add(new Pair(nr,nc,front.time+1));
            }
        }
                for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            { 
                // System.out.print(grid[i][j]+" ");
                
                if(grid[i][j]==1)
return -1;
            }
                    // System.out.println();
        }
        return min;
    }
}