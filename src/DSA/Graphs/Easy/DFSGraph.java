package DSA.Graphs.Easy;

import java.util.*;
public class DFSGraph {
    public void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited){
        visited.add(node);
        for(int neighbor: graph.getOrDefault(node, new ArrayList<>())){
            if(!visited.contains(neighbor)){
                dfs(neighbor, graph, visited);
            }
        }
    }
}
