package DSA.Graphs.Medium;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1){
                    int area = dfs(grid,i,j);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int st, int ed){
        if(st<0 || ed<0 || st>=grid.length|| ed>=grid[0].length){
            return 0;
        }
        if(grid[st][ed]!=1){
            return 0;
        }
        grid[st][ed] = -1;
        int area = 1;
        area+=dfs(grid,st+1,ed);
        area+=dfs(grid,st-1,ed);
        area+=dfs(grid,st,ed+1);
        area+=dfs(grid,st,ed-1);
        return area;
    }
}
