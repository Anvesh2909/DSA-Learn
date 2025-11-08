package DSA.Graphs.Medium;
import java.util.*;

public class PacificAtlanicWaterFlow {
    private static final int[][] DIRS = {{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();
        for(int i=0; i<m; i++){
            pq.offer(new int[]{i, 0});
            aq.offer(new int[]{i, n-1});
            pac[i][0] = true;
            atl[i][n-1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new int[]{0, j});
            aq.offer(new int[]{m-1, j});
            pac[0][j] = true;
            atl[m-1][j] = true;
        }
        bfs(heights,pq,m,n,pac);
        bfs(heights,aq,m,n,atl);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    private void bfs(int[][] h, Queue<int[]> q, int m, int n, boolean[][] visited){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (h[nr][nc] >= h[r][c]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
