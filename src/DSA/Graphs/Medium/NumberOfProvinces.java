package DSA.Graphs.Medium;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isC) {
        int n = isC.length;
        boolean[] isVisited = new boolean[n];
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(!isVisited[i]){
                dfs(isC,i,isVisited);
                cnt++;
            }
        }
        return cnt;
    }
    private void dfs(int[][] isC, int num, boolean[] visited){
        visited[num] = true;
        for(int i=0; i<isC.length; i++){
            if(isC[num][i]==1 && !visited[i]){
                dfs(isC,i,visited);
            }
        }
    }

    //Union Find Approach
    /*
    class UnionFind{
        int[] parent;
        int components;

        public UnionFind(int n){
           parent = new int[n];
           components = n;
           for(int i=0; i<n; i++){
            parent[i] = i;
           }
        }
        int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX!=rootY){
                parent[rootX] = rootY;
                components--;
            }
        }
        int getComponents(){
            return components;
        }
    }
    public int findCircleNum(int[][] isC) {
        int n = isC.length;
        UnionFind uni = new UnionFind(n);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isC[i][j]==1) uni.union(i,j);
            }
        }
        return uni.getComponents();
    }

     */
}