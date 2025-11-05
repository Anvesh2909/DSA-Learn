package DSA.Stack.Medium;

import java.util.*;
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i:asteroids){
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek()>0 && i<0){
                int top = st.peek();
                if(top>Math.abs(i)){
                    destroyed = true;
                    break;
                }else if(top<Math.abs(i)){
                    st.pop();
                }else{
                    st.pop();
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                st.push(i);
            }
        }
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = st.pop();
        return res;
    }
}
