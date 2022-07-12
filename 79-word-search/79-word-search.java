class Solution {
  public  int []xdir={0,1,0,-1};
 public   int []ydir={-1,0,1,0};
    public boolean findWord(char[][]board,int row,int col,int idx,String word)
    {
        if(idx==word.length())
            return true;
        if(row<0||col<0||row>=board.length||col>=board[0].length||board[row][col]=='0')
            return false;
        
        if(board[row][col]!=word.charAt(idx))
            return false;
        char ch=board[row][col];
        board[row][col]='0';
        for(int i=0;i<4;i++)
        {
           boolean ans=findWord(board,row+ydir[i],col+xdir[i],idx+1,word);
               if(ans==true)
                   return true;
        }
        board[row][col]=ch;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(findWord(board,i,j,0,word)==true)
                    return true;
            }
        }
        return false;
    }
}