class Solution {
    List<List<String>> res;
    public boolean isQueenSafe(boolean [][]vis,int cellNo,int n)
    {
        int row=cellNo/n;
        int col=cellNo%n;
        for(int i=0;i<row;i++)
        {
            if(vis[i][col]==true)
                return false;
        }
        for(int j=0;j<col;j++)
        {
            if(vis[row][j]==true)
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
        while(i>=0&&j<n)
        {
if(vis[i][j]==true)
                return false;
            i--;
            j++;
        }
        return true;
    }
    public void findChess(boolean [][]vis,int cellNo,int n,int k)
    {
        if(cellNo==n*n&&k==0)
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
        if(cellNo==n*n) return ;
        int row=cellNo/n;
        int col=cellNo%n;
        if(isQueenSafe(vis,cellNo,n)==true)
        {
            vis[row][col]=true;
            findChess(vis,cellNo+1,n,k-1);
            vis[row][col]=false;
        }
        findChess(vis,cellNo+1,n,k);
    }
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
 boolean [][]vis=new boolean[n][n];
        findChess(vis,0,n,n);
        return res;
    }
}