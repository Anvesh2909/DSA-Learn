package DSA.Graphs.Medium;

import java.util.*;
public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0){
            return -1;
        }
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{0,0});
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        int len = 1;
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0; i<size; i++){
                int[] curr = qu.poll();
                int x = curr[0];
                int y = curr[1];
                if(x==n-1 && y==n-1) return len;
                for(int[] dir:dirs){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(nx>=0 && ny>=0 && ny<n && nx<n && grid[nx][ny]==0){
                        grid[nx][ny] = 1;
                        qu.offer(new int[]{nx,ny});
                    }
                }
            }
            len++;
        }
        return -1;
    }
}
