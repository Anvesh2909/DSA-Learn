package DSA.Graphs.Medium;

public class RedundantConnection {
    class UnionFind{
        int[] parent;
        int components;
        public UnionFind(int n){
            parent = new int[n+1];
            components = n;
            for(int i=1; i<=n; i++){
                parent[i] = i;
            }
        }
        int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX==rootY){
                return false;
            }
            if(rootX!=rootY){
                parent[rootX] = rootY;
                components--;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uni = new UnionFind(n);
        for(int i=0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(!uni.union(u,v)){
                return new int[]{u,v};
            }
        }
        return new int[0];
    }
}
