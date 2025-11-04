package DSA.Graphs.Medium;
import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return List.of(0);
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new HashSet<>());
        }
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(adj.get(i).size()==1){
                leaves.add(i);
            }
        }
        int rem = n;
        while(rem>2){
            rem-=leaves.size();
            List<Integer> temp = new ArrayList<>();
            for(int leaf:leaves){
                int neigh = adj.get(leaf).iterator().next();
                adj.get(neigh).remove(leaf);
                if(adj.get(neigh).size()==1){
                    temp.add(neigh);
                }
            }
            leaves = temp;
        }
        return leaves;
    }
}
