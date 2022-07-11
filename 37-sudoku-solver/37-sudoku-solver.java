class Solution {
    ArrayList<HashSet<Character>> submatrix = new ArrayList<>();
    ArrayList<HashSet<Character>> cols = new ArrayList<>();
    ArrayList<HashSet<Character>> rows = new ArrayList<>();
    
    public boolean isSudokuValid(char[][] board, int row, int col, char ch){
        // row element
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
       public char[][]copyBox=new char[9][9];

    public void solveSudoku(char[][] board, int row, int col){
        if(row == 9)
        {
            for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                copyBox[i][j]=board[i][j];
            return ; 
        }
        // positive base case -> all boxes are filled
        
        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;
        int subMatrixIdx = ((row/3) * 3) + (col/3);
            
//         if(board[row][col] != '.'){
//             // already filled
//             boolean res = solveSudoku(board, nextRow, nextCol);
//             if(res == true) return true;
            
//         } else {
               if(board[row][col] == '.'){  
            // empty fill -> explore all valid options
            for(int i=1; i<=9; i++){
                if(isSudokuValid(board, row, col, (char)(i + '0')) == true){
                    board[row][col] = (char)(i + '0');
                    rows.get(row).add((char)(i + '0'));
                    cols.get(col).add((char)(i + '0'));
                    submatrix.get(subMatrixIdx).add((char)(i + '0'));
                    
                     solveSudoku(board, nextRow, nextCol);
        
                    
                    rows.get(row).remove((char)(i + '0'));
                    cols.get(col).remove((char)(i + '0'));
                    submatrix.get(subMatrixIdx).remove((char)(i + '0'));
                    
                    board[row][col] = '.';
                }
            }
            
        }
        else
          solveSudoku(board, nextRow, nextCol); // sudoku is not solvable
        // return true;
    }
    
    public void solveSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            HashSet<Character> hm = new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    hm.add(board[i][j]);
                }
            }
            rows.add(hm);
        }
        
        for(int j=0; j<9; j++){
            HashSet<Character> hm = new HashSet<>();
            for(int i=0; i<9; i++){
                if(board[i][j] != '.'){
                    hm.add(board[i][j]);
                }
            }
            cols.add(hm);
        }
        
        
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                HashSet<Character> hm = new HashSet<>();
                for(int ii=0; ii<3; ii++){
                    for(int jj=0; jj<3; jj++){
                        if(board[i + ii][j + jj] != '.'){
                            hm.add(board[i + ii][j + jj]);
                        }
                    }
                }                
                submatrix.add(hm);  
            }
        }

        
        
        solveSudoku(board, 0, 0);
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                board[i][j]=copyBox[i][j];
    }
}