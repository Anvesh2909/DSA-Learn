package DSA.DynamicProgramming.Medium;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int p1 = nums[0];
        int p2 = Math.max(nums[0],nums[1]);
        for(int i=2; i<n; i++){
            int temp = p2;
            p2 = Math.max(p1+nums[i],p2);
            p1 = temp;
        }
        return p2;
    }
}
