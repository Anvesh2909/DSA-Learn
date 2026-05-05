package DSA.DynamicProgramming.Easy;
import java.util.Arrays;
import java.util.Scanner;

public class BookShop {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] prices = new int[n];
        int[] page = new int[n];
        dp = new int[n+1][x+1];
        for(int i=0; i<n; i++){
            prices[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            page[i] = sc.nextInt();
        }
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=x; j++){
                int skip = dp[i+1][j];
                int take = 0;
                if(prices[i]<=j){
                    take = dp[i+1][j-prices[i]]+page[i];
                }
                dp[i][j] = Math.max(skip,take);
            }
        }
        System.out.println(dp[0][x]);
    }

//    private static int maximumPages(int[] price, int[] pages, int x, int i) {
//        if(x==0 || i>=price.length) return 0;
//        if(dp[i][x]!=-1) return dp[i][x];
//        int skip = maximumPages(price, pages, x, i+1);
//        int take = 0;
//        if(x>=price[i]){
//            take = maximumPages(price, pages, x-price[i], i+1)+pages[i];
//        }
//        return dp[i][x] = Math.max(skip,take);
//    }
}
