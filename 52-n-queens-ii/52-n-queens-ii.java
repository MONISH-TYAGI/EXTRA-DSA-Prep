class Solution {
    int count=0;
        public  boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // write your code here
        int i=row,j=col;
        while(--i>=0)
        {
            if(chess[i][j]==true)return false;
        }
        i=row;j=col;
        while(--j>=0)
        {
            if(chess[i][j]==true) return false;
        }
        i=row;j=col;
        while(--i>=0&&--j>=0)
        {
            if(chess[i][j]==true)return false;
        }
        i=row;
        j=col;
        while(--i>=0&&++j<chess[0].length)
        {
         if(chess[i][j]==true)return false;   
        }
        return true;
    }

    public  void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
          count++;
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }
    public int totalNQueens(int n) {
        boolean[][] chess = new boolean[n][n];
count=0;
        nqueens(0, n, chess, -1);
        return count;
    }
}