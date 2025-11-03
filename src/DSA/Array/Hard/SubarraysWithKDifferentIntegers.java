package DSA.Array.Hard;
import java.util.*;

public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }
    public int atMost(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while(i<n){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(j<n && map.size()>k){
                map.put(nums[j],map.get(nums[j])-1);
                if(map.get(nums[j])==0){
                    map.remove(nums[j]);
                }
                j++;
            }
            res+=i-j+1;
            i++;
        }
        return res;
    }
}
