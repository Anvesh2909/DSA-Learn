package DSA.Trees.Medium;
import DSA.Trees.Easy.TreeNode;

import java.util.*;

public class BinaryTreeZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> qu = new LinkedList<>();
        int level = 0;
        qu.offer(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            List<Integer> curr = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = qu.poll();
                curr.add(node.val);
                if(node.left!=null) qu.offer(node.left);
                if(node.right!=null) qu.offer(node.right);
            }
            if(level%2==0){
                res.add(curr);
            }else{
                Collections.reverse(curr);
                res.add(curr);
            }
            level++;
        }
        return res;
    }
}