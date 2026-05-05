package DSA.Graphs.Medium;
import java.util.*;
import java.io.*;

public class FlightDiscount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        List<long[]>[] adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<m; i++){
            String[] connections = br.readLine().split(" ");
            int u = Integer.parseInt(connections[0]);
            int v = Integer.parseInt(connections[1]);
            long w = Long.parseLong(connections[2]);
            adj[u].add(new long[]{v,w});
        }
        long[][] dist = new long[n+1][2];
        for(long[] row:dist) Arrays.fill(row, Long.MAX_VALUE);
        dist[1][0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0], b[0]));
        pq.offer(new long[]{0,1,0});
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int u = (int)curr[1];
            int used = (int)curr[2];
            long cost = curr[0];
            if(cost>dist[u][used]) continue;
            for(long[] neigh:adj[u]){
                int v = (int)neigh[0];
                long w = neigh[1];
                if(used==0){
                    if(dist[u][0]+w<dist[v][0]){
                        dist[v][0] = dist[u][0]+w;
                        pq.offer(new long[]{dist[v][0], v, 0});
                    }
                    if(dist[u][0]+w/2<dist[v][1]){
                        dist[v][1] = dist[u][0]+w/2;
                        pq.offer(new long[]{dist[v][1], v, 1});
                    }
                }
                if(used==1){
                    if(dist[u][1]+w<dist[v][1]){
                        dist[v][1] = dist[u][1]+w;
                        pq.offer(new long[]{dist[v][1], v, 1});
                    }
                }
            }
        }
        System.out.println(Math.min(dist[n][0], dist[n][1]));
    }
}
