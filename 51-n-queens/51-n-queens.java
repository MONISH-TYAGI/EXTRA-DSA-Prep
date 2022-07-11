class Solution {
    public List<List<String>> res;
    public void findChess(int r,int n,boolean [][]chess,BitSet leftDiagonal,BitSet rightDiagonal,BitSet column )
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
                chess[r][c]=true;
                leftDiagonal.set(r-c+n-1,true);
                rightDiagonal.set(r+c,true);
                column.set(c,true);
                findChess(r+1,n,chess,leftDiagonal,rightDiagonal,column);
                chess[r][c]=false;
                leftDiagonal.set(r-c+n-1,false);
                rightDiagonal.set(r+c,false);
                column.set(c,false);
            }
        }
    }
    public boolean isQueenSafe(int r,int c,BitSet leftDiagonal,BitSet rightDiagonal,BitSet column ,int n)
    {
        return ((leftDiagonal.get(r-c+n-1)==true)||(rightDiagonal.get(r+c)==true)||(column.get(c)==true))?false:true;
    }
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
boolean [][]chess=new boolean[n][n];
        BitSet leftDiagonal=new BitSet(2*n-1)   ;
        BitSet rightDiagonal=new BitSet(2*n-1);
        BitSet column=new BitSet(n);
        findChess(0,n,chess,leftDiagonal,rightDiagonal,column);
        return res;
    }
}