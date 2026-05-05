package DSA.Array.Easy;

import java.util.HashMap;
import java.util.HashSet;

public class FindPairs {
    public static long findPairs(int[] nums, int k){
        long[] freq = new long[k];
        long res = 0;
        for(int i:nums){
            int x = ((i % k) + k) % k;
            int comp = (k - x) % k;
            res += freq[comp];
            freq[x]++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 5;
        long res = findPairs(nums,k);
        System.out.println(res);
    }
}
