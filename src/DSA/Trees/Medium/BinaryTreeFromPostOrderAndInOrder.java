package DSA.Trees.Medium;

import DSA.Trees.Easy.TreeNode;

import java.util.*;

public class BinaryTreeFromPostOrderAndInOrder {
    int postorderIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        postorderIndex = inorder.length-1;
        return build(postorder, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, Map<Integer, Integer> inorderMap, int st, int ed) {
        if(st>ed){
            return null;
        }
        int val = postorder[postorderIndex--];
        TreeNode root = new TreeNode(val);
        int inorderRootIndex = inorderMap.get(val);
        root.right = build(postorder,inorderMap,inorderRootIndex+1,ed);
        root.left = build(postorder,inorderMap,st,inorderRootIndex-1);
        return root;
    }
}