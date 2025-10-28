package DSA.Trees.Easy;
import java.util.*;

public class BinaryTreeAverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            double avg = 0.0;
            int size = qu.size();
            for(int i=0; i<size; i++){
                TreeNode node = qu.poll();
                avg+=node.val;
                if(node.left!=null) qu.offer(node.left);
                if(node.right!=null) qu.offer(node.right);
            }
            res.add(avg/size);
        }
        return res;
    }
}
