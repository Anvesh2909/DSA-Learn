package DSA.Graphs.Medium;

import java.util.*;
public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> qu = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if (mat[i][j] == 0) {
                    qu.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!qu.isEmpty()){
            int[] curr = qu.poll();
            int x = curr[0];
            int y = curr[1];
            for(int[] dir:dirs){
                int nx = x+dir[0];
                int ny = y+dir[1];
                if(nx>=0 && ny>=0 && nx<rows && ny<cols && mat[nx][ny]==-1){
                    mat[nx][ny] = mat[x][y]+1;
                    qu.offer(new int[]{nx,ny});
                }
            }
        }
        return mat;
    }
}