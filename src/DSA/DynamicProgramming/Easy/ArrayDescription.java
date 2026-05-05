package DSA.DynamicProgramming.Easy;

import java.util.*;

public class ArrayDescription {
    static long[][] dp;
    static final long MOD = 1_000_000_007L;
    private static long countWays(int[] arr, int n, int m){
        dp = new long[n][m+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        long ans = 0;
        for(int i=0; i<n; i++){
            ans+=solve(arr,n,m,i,arr[i]);
            ans%=MOD;
        }
        return ans;
    }

    private static long solve(int[] arr, int n, int m, int i, int v) {
        if(i==arr.length) return 1;
        if(arr[i]!=0 && arr[i]!=v) return 0;
        if(dp[i][v]!=-1) return dp[i][v];
        long ways = 0;
        if(v-1>=1) ways+=solve(arr,n,m,i-1,v-1);
        if(v+1<=m) ways+=solve(arr,n,m,i+1,v+1);
        return dp[i][v] = ways;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(countWays(arr,n,m));
    }
}