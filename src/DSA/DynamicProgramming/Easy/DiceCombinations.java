package DSA.DynamicProgramming.Easy;

import java.util.Arrays;
import java.util.Scanner;

public class DiceCombinations {
    static int mod = (int)1e9+7;
    public static int numOfWays(int n){
        int[]  dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=6; j++){
                if(i>=j){
                    dp[i]+=dp[i-j];
                    dp[i]%=mod;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numOfWays(n));
    }
}
