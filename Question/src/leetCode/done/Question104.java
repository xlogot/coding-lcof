package leetCode.done;

import leetCode.common.TreeNode;

public class Question104 {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int dept=0;
        dept=Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        return dept;
    }
}
