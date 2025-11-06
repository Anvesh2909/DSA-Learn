package DSA.Array.Hard;
import java.util.*;

public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] pref = new long[n+1];
        pref[0] = 0;
        for(int i=1; i<=n; i++){
            pref[i] = pref[i-1]+nums[i-1];
        }
        Deque<Integer> dq = new LinkedList<>();
        int res = n+1;
        for(int i=0; i<=n; i++){
            while(!dq.isEmpty() && pref[i]-pref[dq.peekFirst()] >=k){
                res = Math.min(res,i-dq.pollFirst());
            }
            while(!dq.isEmpty() && pref[i]<=pref[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offer(i);
        }
        return res==n+1?-1:res;
    }
}
