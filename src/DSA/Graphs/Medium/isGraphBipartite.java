package DSA.Graphs.Medium;
import java.util.*;

public class isGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0; i<n; i++){
            if(color[i]==-1){
                if(!bfs(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(int[][] graph, int st, int[] color){
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(st);
        color[st] = 0;
        while(!qu.isEmpty()){
            int curr = qu.poll();
            for(int neigh:graph[curr]){
                if(color[neigh]==-1){
                    color[neigh] = 1-color[curr];
                    qu.offer(neigh);
                }else if(color[neigh]==color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}
