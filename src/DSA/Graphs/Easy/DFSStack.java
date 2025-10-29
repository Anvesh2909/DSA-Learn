package DSA.Graphs.Easy;

import java.util.*;
public class DFSStack {
    void dfsIterative(int start, Map<Integer, List<Integer>> graph){
        Stack<Integer> st = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        st.push(start);
        while(!st.isEmpty()){
            int node = st.pop();
            if(visited.contains(node)) continue;
            visited.add(node);
            for(int neighbor: graph.getOrDefault(node, new ArrayList<>())){
                if(!visited.contains(neighbor)){
                    st.push(neighbor);
                }
            }
        }
    }
}