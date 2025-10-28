package DSA.Trees.Medium;
import java.util.*;
import DSA.Trees.Easy.TreeNode;

public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p.val>root.val && q.val>root.val){
                root=root.right;
            }else if(p.val<root.val && q.val<root.val){
                root=root.left;
            }else{
                return root;
            }
        }
        return null;
    }
}