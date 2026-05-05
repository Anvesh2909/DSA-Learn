package DSA.DynamicProgramming.Easy;

import java.util.*;

public class RemovingDigits {

    public int removeDigits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=num; i++){
            int min = Integer.MAX_VALUE;
            int temp = i;
            while(temp>0){
                int d = temp%10;
                if(d != 0){
                    min = Math.min(dp[i-d]+1, min);
                }
                temp/=10;
            }
            dp[i] = min;
        }
        return dp[num];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        RemovingDigits obj = new RemovingDigits();
        System.out.println(obj.removeDigits(n));
    }

}