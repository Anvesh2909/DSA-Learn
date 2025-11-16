package DSA.DynamicProgramming.Medium;

public class NumberofSubstringsWithOnly1s {
    public int numSub(String s) {
        int n = s.length();
        long res = 0;
        long cnt = 0;
        long mod = 1_000_000_007;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1'){
                cnt++;
            }else{
                res = (res + cnt * (cnt + 1) / 2) % mod;
                cnt = 0;
            }
        }
        res = (res + cnt * (cnt + 1) / 2) % mod;
        return (int)res;
    }
}
