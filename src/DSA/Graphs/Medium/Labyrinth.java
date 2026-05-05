package DSA.Graphs.Medium;
import java.util.*;
import java.io.*;

public class Labyrinth {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        char[][] grid = new char[n][m];
        for(int i=0; i<n; i++){
            grid[i] = br.readLine().toCharArray();
        }
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        char[] dir = {'R','D','L','U'};
        Queue<int[]> qu = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int si = 0, sj = 0;
        int ei = 0, ej = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='A'){
                    si = i;
                    sj = j;
                }
                if(grid[i][j]=='B'){
                    ei = i;
                    ej = j;
                }
            }
        }
        qu.offer(new int[]{si,sj});
        visited[si][sj] = true;
        boolean found = false;
        int[][][] parent = new int[n][m][3];
        while(!qu.isEmpty()){
            int[] curr = qu.poll();
            int r = curr[0];
            int c = curr[1];
            if(r==ei && c==ej){
                found = true;
                break;
            }
            for(int i=0; i<4; i++){
                int[] d = dirs[i];
                int nr = d[0]+r;
                int nc = d[1]+c;
                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                if(visited[nr][nc] || grid[nr][nc]=='#') continue;
                visited[nr][nc] = true;
                parent[nr][nc] = new int[]{r,c,i};
                qu.offer(new int[]{nr,nc});
            }
        }
        if(!found){
            System.out.println("NO");
            return;
        }
        StringBuilder str = new StringBuilder();
        int r = ei, c = ej;
        while(r!=si || c!=sj){
            int[] p = parent[r][c];
            str.append(dir[p[2]]);
            r = p[0];
            c = p[1];
        }
        System.out.println("YES");
        System.out.println(str.length());
        System.out.println(str.reverse().toString());
    }
}