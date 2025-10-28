package DSA.Trees.Medium;
import DSA.Trees.Easy.TreeNode;
import java.util.*;

public class BInaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            List<Integer> curr = new ArrayList<>();
            int size = qu.size();
            for(int i=0; i<size; i++){
                TreeNode node = qu.poll();
                curr.add(node.val);
                if(node.left!=null) qu.offer(node.left);
                if(node.right!=null) qu.offer(node.right);
            }
            res.add(curr);
        }
        return res;
    }
}
