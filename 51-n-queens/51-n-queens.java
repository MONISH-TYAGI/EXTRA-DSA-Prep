class Solution {
    List<List<String>> res;
    public boolean isQueenSafe(boolean [][]vis,int row,int col)
    {

        for(int i=0; i<row; i++){
            if(vis[i][col] == true)
                return false;
        }

        int i=row;
        int j=col;
        while(i>=0&&j>=0)
        {
            if(vis[i][j]==true)
                return false;
            i--;
            j--;
        }
        i=row;
        j=col;
        while(i>=0&&j<vis.length)
        {
if(vis[i][j]==true)
                return false;
            i--;
            j++;
        }
        return true;
    }
    public void findChess(int row,int n,boolean[][]vis)
    {
       if(row==n)
       {
                       List<String> ans=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
String str="";
                for(int j=0;j<n;j++)
                {
                    if(vis[i][j]==true)
                    {
                        str=str+"Q";
                    }else
                    {
                        str=str+".";
                    }
                }
                ans.add(str);
                
            }
            res.add(ans);
            return;
       }
        for(int c=0;c<n;c++)
        {
            if(vis[row][c]==false&&isQueenSafe(vis,row,c)==true)
            {
                vis[row][c]=true;
                findChess(row+1,n,vis);
                vis[row][c]=false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
 boolean [][]vis=new boolean[n][n];
        findChess(0,n,vis);
        return res;
    }
}