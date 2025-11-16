package DSA.DynamicProgramming.Medium;

public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0 || s.charAt(0)=='0') return 0;
        int p1 = 1;
        int p2 = 1;
        for(int i=2; i<=n; i++){
            int oneDigit = s.charAt(i-1)-'0';
            int curr = 0;
            if(oneDigit>=1 && oneDigit<=9){
                curr+=p2;
            }
            int twoDigit = (s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0');
            if(twoDigit>=10 && twoDigit<=26){
                curr+=p1;
            }
            p1 = p2;
            p2 = curr;
        }
        return p2;
    }
}
