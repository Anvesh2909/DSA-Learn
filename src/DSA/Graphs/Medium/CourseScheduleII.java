package DSA.Graphs.Medium;

import java.util.*;
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] i:prerequisites){
            int course = i[0];
            int preq = i[1];
            map.get(preq).add(course);
        }
        int[] state = new int[numCourses];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, map, state, result)) {
                return new int[0];
            }
        }
        Collections.reverse(result);
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
    public boolean hasCycle(int num, Map<Integer,List<Integer>> map, int[] state, List<Integer> res){
        if(state[num]==1){
            return true;
        }
        if(state[num]==2){
            return false;
        }
        state[num] = 1;
        for(int i:map.get(num)){
            if(hasCycle(i,map,state,res)){
                return true;
            }
        }
        state[num] = 2;
        res.add(num);
        return false;
    }
    public int[] findOrderBFS(int n, int[][] prerequisites) {
        int[] inorder = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] i:prerequisites){
            int course = i[0];
            int preq = i[1];
            map.get(preq).add(course);
            inorder[course]++;
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inorder[i]==0){
                qu.offer(i);
            }
        }
        int[] order = new int[n];
        int idx = 0;
        while(!qu.isEmpty()){
            int curr = qu.poll();
            order[idx++] = curr;
            for(int num:map.get(curr)){
                inorder[num]--;
                if(inorder[num]==0){
                    qu.offer(num);
                }
            }
        }
        return idx==n?order:new int[0];
    }
}