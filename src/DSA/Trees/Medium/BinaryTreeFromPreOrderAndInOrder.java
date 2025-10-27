package DSA.Trees.Medium;

import DSA.Trees.Easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreOrderAndInOrder {
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder,
                           Map<Integer, Integer> inorderMap,
                           int inorderStart,
                           int inorderEnd) {
        if(inorderStart>inorderEnd){
            return null;
        }
        int val = preorder[preorderIndex++];
        TreeNode root = new TreeNode(val);
        int inorderRootIndex = inorderMap.get(val);
        root.left = build(preorder, inorderMap, inorderStart, inorderRootIndex - 1);
        root.right = build(preorder, inorderMap, inorderRootIndex + 1, inorderEnd);
        return root;
    }
}
