class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
           int row = 0, col = matrix[0].length - 1; // Top Right Corner
        
        while(row < matrix.length && col >= 0){
            
            if(matrix[row][col] == target) 
                return true;
            
            else if(matrix[row][col] < target){
                // Discard the current row
                row++;
            }
            
            else {
                // Discard the current col
                col--;
            }
        }
        
        return false;
    }
}