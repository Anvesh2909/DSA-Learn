package DSA.Graphs.Medium;
import java.util.*;

public class DijkstraAlgorithm {
    class Node {
        int vertex;
        int distance;

        Node(int v, int d) {
            vertex = v;
            distance = d;
        }
    }
    public int[] dijkstra(int n, Map<Integer, List<Node>> graph, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int currVertex = curr.vertex;
            int currDistance = curr.distance;
            if(currDistance > dist[currVertex]) continue;
            for(Node neigh:graph.get(currVertex)){
                int newDist = dist[currVertex] + neigh.distance;
                if(dist[neigh.vertex]>newDist){
                    dist[neigh.vertex] = newDist;
                    pq.offer(new Node(neigh.vertex,newDist));
                }
            }
        }
        return dist;
    }
}