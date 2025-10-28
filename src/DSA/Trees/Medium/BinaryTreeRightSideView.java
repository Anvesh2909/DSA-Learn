package DSA.Trees.Medium;

import DSA.Trees.Easy.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0; i<size; i++){
                TreeNode node = qu.poll();
                if(i==size-1){
                    res.add(node.val);
                }
                if(node.left!=null) qu.offer(node.left);
                if(node.right!=null) qu.offer(node.right);
            }
        }
        return res;
    }
}
