class Solution {
    public List<List<String>> res;
    public void findChess(int r,int n,boolean [][]chess,boolean[]leftDiagonal,boolean[]rightDiagonal,boolean[]column )
    {
            // System.out.println("hello");
        if(r==n)
        {
            // System.out.println("hello");
            List<String> subans=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String curr="";
                for(int j=0;j<n;j++)
                {
                   if(chess[i][j]==true)
                       curr=curr+"Q";
                    else
                        curr=curr+".";
                }
                subans.add(curr);
            }
            res.add(subans);
            return ;
        }
        for(int c=0;c<n;c++)
        {
            if(isQueenSafe(r,c,leftDiagonal,rightDiagonal,column,n)==true)
            {
                chess[r][c]=leftDiagonal[r-c+n-1]=rightDiagonal[r+c]=column[c]=true;
                findChess(r+1,n,chess,leftDiagonal,rightDiagonal,column);
                chess[r][c]=leftDiagonal[r-c+n-1]=rightDiagonal[r+c]=column[c]=false;
            }
        }
    }
    public boolean isQueenSafe(int r,int c,boolean[]leftDiagonal,boolean[]rightDiagonal,boolean[]column ,int n)
    {
        return ((leftDiagonal[r-c+n-1]==true)||(rightDiagonal[r+c]==true)||(column[c]==true))?false:true;
    }
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
boolean [][]chess=new boolean[n][n];
        boolean []leftDiagonal=new boolean[(2*n)-1];
        boolean []rightDiagonal=new boolean[(2*n)-1];
        boolean []column=new boolean[n];
        findChess(0,n,chess,leftDiagonal,rightDiagonal,column);
        return res;
    }
}