package DSA.Graphs.Easy;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        dfs(image,sr,sc,color,originalColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int oC){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length){
            return;
        }
        if(image[sr][sc]!=oC){
            return;
        }
        image[sr][sc] = color;
        dfs(image,sr+1,sc,color,oC);
        dfs(image,sr-1,sc,color,oC);
        dfs(image,sr,sc+1,color,oC);
        dfs(image,sr,sc-1,color,oC);
    }
}
