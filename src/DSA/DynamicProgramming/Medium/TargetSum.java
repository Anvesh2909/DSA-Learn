package DSA.DynamicProgramming.Medium;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (Math.abs(target) > total || (target + total) % 2 != 0) {
            return 0;
        }
        int positiveSum = (target + total) / 2;
        return countSubsets(nums, positiveSum);
    }
    private int countSubsets(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[sum];
    }
}
