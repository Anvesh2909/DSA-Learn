package DSA.Graphs.Medium;
import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String,Double>> graph = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            graph.putIfAbsent(a,new HashMap<>());
            graph.putIfAbsent(b,new HashMap<>());
            graph.get(a).put(b,val);
            graph.get(b).put(a,1.0/val);
        }
        double[] res = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String src = queries.get(i).get(0);
            String dis = queries.get(i).get(1);
            if(!graph.containsKey(src) || !graph.containsKey(dis)){
                res[i] = -1.0;
            }else if(src.equals(dis)){
                res[i] = 1.0;
            }else{
                res[i] = dfs(graph,src,dis,new HashSet<>(),1.0);
            }
        }
        return res;
    }
    private double dfs(Map<String, Map<String,Double>> graph, String src, String dis, HashSet<String> seen, double pro){
        if(src.equals(dis)) return pro;
        seen.add(src);
        Map<String,Double> map = graph.get(src);
        for(Map.Entry<String,Double> neigh:map.entrySet()){
            if(seen.contains(neigh.getKey())) continue;
            double cP = pro*neigh.getValue();
            double res = dfs(graph,neigh.getKey(),dis,seen,cP);
            if(res!=-1.0) return res;
        }
        return -1.0;
    }
}