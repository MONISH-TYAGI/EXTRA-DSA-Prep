class Solution {
    public void fillColor(int [][]image,int sr,int sc,int oldColor,int newColor)
    {
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=oldColor)
            return ;
        image[sr][sc]=newColor;
        fillColor(image,sr+1,sc,oldColor,newColor);
        fillColor(image,sr,sc+1,oldColor,newColor);
        fillColor(image,sr-1,sc,oldColor,newColor);
        fillColor(image,sr,sc-1,oldColor,newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;
        
            fillColor(image,sr,sc,image[sr][sc],color);
        return image;
    }
}