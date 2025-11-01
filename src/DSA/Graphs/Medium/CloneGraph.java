package DSA.Graphs.Medium;
import java.util.*;
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Node clone = new Node(node.val);
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> qu = new LinkedList<>();
        qu.offer(node);
        map.put(node,clone);
        while(!qu.isEmpty()){
            Node curr = qu.poll();
            for(Node neigh: curr.neighbors){
                if(!map.containsKey(neigh)){
                    Node cloneNeigh = new Node(neigh.val);
                    map.put(neigh,cloneNeigh);
                    qu.offer(neigh);
                }
                map.get(curr).neighbors.add(map.get(neigh));
            }
        }
        return clone;
    }
}