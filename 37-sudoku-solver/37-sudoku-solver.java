class Solution {
    ArrayList<HashSet<Character>> rows;
    ArrayList<HashSet<Character>> cols;
    ArrayList<HashSet<Character>> submatrix;
    public char[][]copyBox;
    public boolean isValid(int row,int col,char ch)
    {
                if(rows.get(row).contains(ch) == true){
            return false;
        }
        
        // column element
        if(cols.get(col).contains(ch) == true){
            return false;
        }
        
        int submatrixIdx = ((row/3) * 3) + (col/3);
        // submatrix element
        if(submatrix.get(submatrixIdx).contains(ch) == true){
            return false;
        }
        
        return true;

    }
    public void solveSudoku(char[][]board,int row,int col)
    {
        System.out.println(row+"->"+col);
        if(row==9)
        {
            System.out.println("hello");
         for(int i=0;i<9;i++)
         {
             for(int j=0;j<9;j++)
             {
                 System.out.print(board[i][j]+"->");
                 copyBox[i][j]=board[i][j];
             }
             System.out.println();
         }
            return ;
        }
        int nextRow=(col==8)?row+1:row;
        int nextCol=(col==8)?0:col+1;

        int subIdx=((row/3) * 3) + (col/3);
        if(board[row][col]=='.')
        {
            for(int i=1;i<=9;i++)
            {
                        char ch=(char)(i+'0');
                if(isValid(row,col,ch)==true)
                {
                    board[row][col]=ch;
                    rows.get(row).add(ch);
                    cols.get(col).add(ch);
                    submatrix.get(subIdx).add(ch);
                    solveSudoku(board,nextRow,nextCol);
                     board[row][col]='.';
                    rows.get(row).remove(ch);
                    cols.get(col).remove(ch);
                    submatrix.get(subIdx).remove(ch);
                }
            }
        }else
            solveSudoku(board,nextRow,nextCol);
    }
    public void solveSudoku(char[][] board) {
        cols=new ArrayList<>();
        rows=new ArrayList<>();
        copyBox=new char[9][9];
        submatrix=new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            HashSet<Character> obj=new HashSet<>();
            for(int j=0;j<9;j++)
            {
              if(board[i][j]!='.')
                  obj.add(board[i][j]);
            }
            rows.add(obj);
        }
                for(int j=0;j<9;j++)
        {
            HashSet<Character> obj=new HashSet<>();
            for(int i=0;i<9;i++)
            {
              if(board[i][j]!='.')
                  obj.add(board[i][j]);
            }
            cols.add(obj);
        }
        for(int I=0;I<9;I=I+3)
        {
            for(int J=0;J<9;J=J+3)
            {
                HashSet<Character> obj=new HashSet<>();
                for(int i=0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                       if(board[I+i][J+j]!='.')
                  obj.add(board[I+i][J+j]); 
                    }
                }
            submatrix.add(obj);
            }
        }
        solveSudoku(board,0,0);
           for(int i=0;i<9;i++)
         {
             for(int j=0;j<9;j++)
             {
                 // System.out.print(board[i][j]+"->");
                 board[i][j]=copyBox[i][j];
             }
             // System.out.println();
         }

    }
}