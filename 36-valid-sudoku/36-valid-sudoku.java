class Solution {
    public boolean isValid(char[][]board,int row,int col,char ch)
    {
        for(int i=0;i<board.length;i++)
        {
            if(board[i][col]==ch&&i!=row)
                return false;
        }
        for(int j=0;j<board[0].length;j++)
        {
            if(board[row][j]==ch&&j!=col)
                return false;
        }
        int boxRow=(row/3)*3;
        int boxCol=(col/3)*3;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i+boxRow][j+boxCol]==ch&&i+boxRow!=row&&j+boxCol!=col)
                    return false;
            }
        }
        return true;
        
    }
    public boolean valid(char[][]board,int row,int col)
    {
        if(row==9)
        {
            return true;
        }
        if(board[row][col]!='.')
        {
            if(isValid(board,row,col,board[row][col])==false)
                return false;
        }
                if(col==8)
                 return   valid(board,row+1,0);
                else
                 return   valid(board,row,col+1);
            
        }
    
    public boolean isValidSudoku(char[][] board) {
         return valid(board,0,0);
    }
}