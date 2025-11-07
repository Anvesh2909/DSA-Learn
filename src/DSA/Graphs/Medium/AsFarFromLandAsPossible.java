package DSA.Graphs.Medium;
import java.util.*;

public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int water = 0;
        int land = 0;
        int n = grid.length;
        Queue<int[]> qu = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    water++;
                    grid[i][j] = -1;
                }else{
                    qu.offer(new int[]{i,j});
                    grid[i][j] = 0;
                    land++;
                }
            }
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        if(land==0 || water==0) return -1;
        int max = 0;
        while(!qu.isEmpty()){
            int[] curr = qu.poll();
            int x = curr[0];
            int y = curr[1];
            for(int[] dir:dirs){
                int nx = x+dir[0];
                int ny = y+dir[1];
                if(nx>=0 && ny>=0 && nx<n && ny<n && grid[nx][ny]==-1){
                    grid[nx][ny] = grid[x][y]+1;
                    max = Math.max(max,grid[nx][ny]);
                    qu.offer(new int[]{nx,ny});
                }
            }
        }
        return max;
    }
}
