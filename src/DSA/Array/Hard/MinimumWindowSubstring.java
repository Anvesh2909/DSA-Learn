package DSA.Array.Hard;
import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int cnt = t.length();
        int i = 0;
        int j = 0;
        int minL = n+1;
        int st = 0;
        while(i<n){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>0){
                map.put(ch,map.get(ch)-1);
                cnt--;
            }else{
                map.putIfAbsent(ch,0);
                map.put(ch,map.get(ch)-1);
            }
            i++;
            while(cnt==0){
                if(i-j<minL){
                    minL = i-j;
                    st = j;
                }
                char temp = s.charAt(j);
                map.put(temp,map.get(temp)+1);
                if(map.get(temp)>0){
                    cnt++;
                }
                j++;
            }
        }
        return minL==n+1?"":s.substring(st,minL+st);
    }
}
