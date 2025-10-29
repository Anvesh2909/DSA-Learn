package DSA.Graphs.Medium;

public class NoOfIslands {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    dfs(grid,i,j);
                }
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid, int st, int ed){
        if(st<0 || st>=grid.length || ed<0 || ed>=grid[0].length){
            return;
        }
        if(grid[st][ed]!='1'){
            return;
        }
        grid[st][ed] = '0';
        dfs(grid,st-1,ed);
        dfs(grid,st+1,ed);
        dfs(grid,st,ed-1);
        dfs(grid,st,ed+1);
    }
}
