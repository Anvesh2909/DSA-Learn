package DSA.DynamicProgramming.Medium;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int case1 = roblinear(0,n-2,nums);
        int case2 = roblinear(1,n-1,nums);
        return Math.max(case1,case2);
    }
    private int roblinear(int st, int ed, int[] nums){
        int p1 = nums[st];
        int p2 = Math.max(nums[st],nums[st+1]);
        for(int i=st+2; i<=ed; i++){
            int temp = p2;
            p2 = Math.max(p1+nums[i],p2);
            p1 = temp;
        }
        return p2;
    }
}
