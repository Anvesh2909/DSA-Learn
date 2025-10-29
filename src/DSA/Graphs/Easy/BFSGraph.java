package DSA.Graphs.Easy;
import java.util.*;

public class BFSGraph {
    void bfs(int start, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor: graph.getOrDefault(node, new ArrayList<>())){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
    /*
```

        ## BFS Step-by-Step Example

**Graph:**
            ```
            0 --- 1
            |     |
            2 --- 3

     */
}
