package DSA.DynamicProgramming.Medium;

public class MaximumAbsoluteSumofAnySubarray {
    public int maxAbsoluteSum(int[] nums) {
        int currMax = 0;
        int currMin = 0;
        int max = 0;
        int min = 0;
        for(int num:nums){
            currMax = Math.max(num+currMax,0);
            max = Math.max(max,currMax);
            currMin = Math.min(0,num+currMin);
            min = Math.min(min,currMin);
        }
        return Math.max(max,-min);
    }
}
