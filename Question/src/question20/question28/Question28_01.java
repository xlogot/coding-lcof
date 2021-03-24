package question20.question28;

import question3.question07.TreeNode;
import question30.question37.Question37;

public class Question28_01 {
    static boolean isSymmetrical(TreeNode root){
        if (root==null) return false;
        return isSymmetricalCore(root,root);
    }

    private static boolean isSymmetricalCore(TreeNode root, TreeNode postRoot) {
        if (root == null) {
            if (postRoot == null) return true;
            else return false;
        } else if (postRoot == null) return false;
        else if (root.key != postRoot.key) return false;
        boolean result = true;
        result = result & isSymmetricalCore(root.left, postRoot.right);
        if (!result) return result;
        result = result & isSymmetricalCore(root.right, postRoot.left);
        return result;
    }

    public static void main(String[] args) {
//        String a="865$$7$$97$$5$$";
        String a="12$$";
        TreeNode root = Question37.deserialize(a);
        boolean symmetrical = isSymmetrical(root);
    }
}
