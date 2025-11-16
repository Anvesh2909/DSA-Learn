package DSA.DynamicProgramming.Medium;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for(int i=1; i<n; i++){
            int temp = min;
            min = Math.min(nums[i],Math.min(min*nums[i],max*nums[i]));
            max = Math.max(nums[i],Math.max(max*nums[i],temp*nums[i]));
            res = Math.max(res,max);
        }
        return res;
    }
}
