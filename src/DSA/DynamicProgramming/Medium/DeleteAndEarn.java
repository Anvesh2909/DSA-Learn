package DSA.DynamicProgramming.Medium;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int max = nums[0];
        for(int i=1; i<n; i++){
            max = Math.max(nums[i],max);
        }
        int[] points = new int[max+1];
        for(int num:nums){
            points[num]+=num;
        }
        int p1 = points[0];
        int p2 = Math.max(points[0],points[1]);
        for(int i=2; i<=max; i++){
            int temp = p2;
            p2 = Math.max(p2,p1+points[i]);
            p1 = temp;
        }
        return p2;
    }
}
