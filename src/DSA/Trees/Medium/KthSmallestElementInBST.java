package DSA.Trees.Medium;
import  java.util.*;
import DSA.Trees.Easy.TreeNode;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(!st.isEmpty() || curr!=null){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr = st.pop();
            if(--k==0) return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}
