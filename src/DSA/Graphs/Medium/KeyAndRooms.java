package DSA.Graphs.Medium;
import java.util.*;

public class KeyAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> qu = new LinkedList<>();
        int complete = 0;
        qu.offer(0);
        visited[0] = true;
        while(!qu.isEmpty()){
            int curr = qu.poll();
            List<Integer> cR = rooms.get(curr);
            for(int i:cR){
                if(visited[i]) continue;
                qu.offer(i);
                visited[i] = true;
            }
            complete++;
        }
        return complete==n;
    }
}
