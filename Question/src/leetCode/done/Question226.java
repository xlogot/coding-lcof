package leetCode.done;


import leetCode.common.TreeNode;

public class Question226 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode left=invertTree(root.right);
        TreeNode right=invertTree(root.left);
        root.left=left;
        root.right=right;
        return root;
    }

}
