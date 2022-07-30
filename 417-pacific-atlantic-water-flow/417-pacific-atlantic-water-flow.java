class Solution {
    int [][]dir={{1,0},{-1,0},{0,1},{0,-1}};
        public void DFS(int row,int col,boolean [][]grid,int [][]heights)
    {
        if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]==true)
            return ;
        // count++;
        grid[row][col]=true;
        for(int i=0;i<4;i++)
        {
            int nr=row+dir[i][0];
            int nc=col+dir[i][1];
            if(nr<0||nc<0||nr>=grid.length||nc>=grid[0].length)
            continue;
            if(heights[row][col]<=heights[row+dir[i][0]][col+dir[i][1]])
                DFS(row+dir[i][0],col+dir[i][1],grid,heights);
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
       boolean [][]pacific=new boolean[n][m];
        for(int i=0;i<n;i++)
            DFS(i,0,pacific,heights);
        for(int j=0;j<m;j++)
            DFS(0,j,pacific,heights);
        boolean [][]atlantic=new boolean[n][m];
        for(int i=0;i<n;i++)
            DFS(i,m-1,atlantic,heights);
        for(int j=0;j<m;j++)
            DFS(n-1,j,atlantic,heights);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(pacific[i][j]==true&&atlantic[i][j]==true)
                {
                    ArrayList<Integer> obj=new ArrayList<>();
                    obj.add(i);
                    obj.add(j);
                    ans.add(obj);
                }
            }
        }
        return ans;
    }
}