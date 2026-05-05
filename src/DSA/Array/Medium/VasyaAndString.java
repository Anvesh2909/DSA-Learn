package DSA.Array.Medium;

import java.util.*;

public class VasyaAndString {
    public static int longestSubstring(String s, int k){
        int n = s.length();
        int res = 0;
        int i = 0;
        int j = 0;
        int cntA = 0;
        int cntB = 0;
        while(i<n){
            if(s.charAt(i)=='a'){
                cntA++;
            }else{
                cntB++;
            }
            while(Math.min(cntA,cntB)>k){
                if(s.charAt(j)=='a'){
                    cntA--;
                }else{
                    cntB--;
                }
                j++;
            }
            res = Math.max(res,i-j+1);
            i++;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int res = longestSubstring(s,k);
        System.out.println(res);
    }
}
