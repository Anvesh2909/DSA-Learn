package DSA.Graphs.Hard;

import java.util.*;
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> present = new HashSet<>(wordList);
        if(!present.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> qu = new LinkedList<>();
        qu.offer(beginWord);
        int t = 1;
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0; i<size; i++){
                String word = qu.poll();
                if(word.equals(endWord)) return t;
                for(String neigh:neighbors(word,present)){
                    if(!visited.contains(neigh)){
                        qu.offer(neigh);
                        visited.add(neigh);
                    }
                }
            }
            t++;
        }
        return 0;
    }
    private List<String> neighbors(String word, Set<String> dict){
        List<String> res = new ArrayList<>();
        char[] arr = word.toCharArray();
        for(int i=0; i<word.length(); i++){
            char old = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                arr[i] = c;
                String next = new String(arr);
                if (dict.contains(next)) res.add(next);
            }
            arr[i] = old;
        }
        return res;
    }
}
