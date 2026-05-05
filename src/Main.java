import java.util.*;
public class Main{
    static int[][][] dp;
    static int T = 0, N = 0;
    static final int NEG_INF = Integer.MIN_VALUE / 2;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        T = t;
        N = n;
        int[] pages = new int[n];
        int[] enjoy = new int[n];
        for (int i = 0; i < n ; i++) {
            pages[i] = sc.nextInt();
        }
        for (int i = 0; i < n ; i++) {
            enjoy[i] = sc.nextInt();
        }
        dp = new int[n][2][(n/2)+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        System.out.println(solve(pages,enjoy,0,0,0));
    }
    static int solve(int[] pages, int[] enjoy, int i, int n, int hold){
        if(i>=pages.length){
            if(n>=(N/2)) return 0;
            else return NEG_INF;
        }
        int read = Math.min(n,N/2);
        if(dp[i][hold][read]!=-1) return dp[i][hold][read];
        int best = 0;
        if(hold==1){
            best = solve(pages,enjoy,i+1,n,0);
        }else{
            int skip = solve(pages,enjoy,i+1,n,0);
            int take = 0;
            if(pages[i]>=T){
                take = solve(pages,enjoy,i+1,n+1,1)+enjoy[i];
            }else{
                take = solve(pages,enjoy,i+1,n+1,0)+enjoy[i];
            }
            best = Math.max(skip,take);
        }
        return dp[i][hold][read] = best;
    }
}