package DSA.Trees.Medium;


import DSA.Trees.Easy.TreeNode;

public class CountGoodNodesInBinaryTrees {
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        return count(root,root.val);
    }
    private int count(TreeNode root, int val){
        if(root==null) return 0;
        int good = 0;
        if(root.val>=val) good++;
        val = Math.max(root.val,val);
        good+=count(root.left,val);
        good+=count(root.right,val);
        return good;
    }
}
