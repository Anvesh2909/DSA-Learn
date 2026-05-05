package DSA.Graphs.Medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class WaterFlow {
    public static int findCells(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(grid[0][i]==1){
                q.offer(new int[]{0,i});
                visited[0][i] = true;
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int nr = r+1;
            if (nr < m) {
                if (!visited[nr][c] && grid[nr][c] == 1) {
                    visited[nr][c] = true;
                    q.offer(new int[]{nr, c});
                }
                if(c-1>=0 && !visited[nr][c-1] && grid[nr][c-1]==1){
                    visited[nr][c-1] = true;
                    q.offer(new int[]{nr,c-1});
                }
                if(c+1<n && !visited[nr][c+1] && grid[nr][c+1]==1){
                    visited[nr][c+1] = true;
                    q.offer(new int[]{nr,c+1});
                }
            }
        }
        int res = 0;
        for(int i=0; i<n; i++){
            if(visited[m-1][i]){
                res++;
            }
        }
        return res;
    }
}