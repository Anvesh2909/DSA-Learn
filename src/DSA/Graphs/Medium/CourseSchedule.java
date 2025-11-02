package DSA.Graphs.Medium;

import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] preq:prerequisites){
            int curr = preq[0];
            int preqs = preq[1];
            map.get(preqs).add(curr);
        }
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, map, state)) {
                return false;
            }
        }
        return true;
    }
    public boolean hasCycle(int num, Map<Integer,List<Integer>> map, int[] st){
        if(st[num]==1){
            return true;
        }
        if(st[num]==2){
            return false;
        }
        st[num] = 1;
        for(int i:map.get(num)){
            if(hasCycle(i,map,st)){
                return true;
            }
        }
        st[num] = 2;
        return false;
    }
}
