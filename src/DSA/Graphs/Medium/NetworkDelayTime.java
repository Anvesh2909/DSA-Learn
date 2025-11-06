package DSA.Graphs.Medium;
import  java.util.*;

public class NetworkDelayTime {
    class Node {
        int vertex;
        int distance;

        Node(int v, int d) {
            vertex = v;
            distance = d;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Map<Integer,List<Node>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int i=0; i<times.length; i++){
            int[] curr = times[i];
            int src = curr[0];
            int tar = curr[1];
            int weight = curr[2];
            graph.get(src).add(new Node(tar,weight));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        dist[k] = 0;
        pq.offer(new Node(k,0));
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int vertex = curr.vertex;
            int distance = curr.distance;
            if(distance>dist[vertex]) continue;
            for(Node neigh:graph.get(vertex)){
                int ver = neigh.vertex;
                int dis = neigh.distance;
                int newDis = dis+dist[vertex];
                if(newDis<dist[ver]){
                    dist[ver] = newDis;
                    pq.offer(new Node(ver,dis));
                }
            }
        }
        int min = 0;
        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            min = Math.max(dist[i],min);
        }
        return min;
    }
}
