package DSA.Trees.Medium;

import DSA.Trees.Easy.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderWithSum {
    public List<List<Object>> levelOrderWithSum(TreeNode root) {
        List<List<Object>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            List<Object> level = new ArrayList<>();
            int sum = 0;
            for(int i=0; i<size; i++){
                TreeNode curr = qu.poll();
                level.add(curr.val);
                sum+=curr.val;
                if(curr.left!=null) qu.offer(curr.left);
                if(curr.right!=null) qu.offer(curr.right);
            }
            List<Object> levelWithSum = new ArrayList<>();
            levelWithSum.add(level);
            levelWithSum.add(sum);
            res.add(levelWithSum);
        }
        return res;
    }
}
