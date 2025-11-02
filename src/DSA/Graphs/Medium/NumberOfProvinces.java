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

}
