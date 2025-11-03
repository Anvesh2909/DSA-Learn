package DSA.Graphs.Medium;

import java.util.*;
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        int n = deadends.length;
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;
        if (target.equals("0000")) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String s = q.poll();
                if (s.equals(target)) return res;
                if (dead.contains(s)) continue;
                for(String neigh:neighbors(s)){
                    if(!visited.contains(neigh) && !dead.contains(neigh)){
                        q.offer(neigh);
                        visited.add(neigh);
                    }
                }
            }
            res++;
        }
        return -1;
    }
    private List<String> neighbors(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = arr[i];
            arr[i] = (c == '9') ? '0' : (char)(c + 1);
            res.add(new String(arr));
            arr[i] = (c == '0') ? '9' : (char)(c - 1);
            res.add(new String(arr));
            arr[i] = c;
        }
        return res;
    }
}