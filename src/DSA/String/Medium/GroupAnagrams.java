package DSA.String.Medium;
import  java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String temp = belongsTo(strs[i]);
            map.putIfAbsent(temp,new ArrayList<>());
            map.get(temp).add(strs[i]);
        }
        for(Map.Entry<String,List<String>> ent:map.entrySet()){
            res.add(ent.getValue());
        }
        return res;
    }
    private String belongsTo(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}