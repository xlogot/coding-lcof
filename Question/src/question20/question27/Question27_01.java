package question20.question27;

import question3.question07.TreeNode;
import question30.question37.Question37;

public class Question27_01 {
    static TreeNode mirror(TreeNode root){
        if (root==null) return null;
        return mirrorCore(root);
    }

    private static TreeNode mirrorCore(TreeNode root) {
        //结束条件
        if (root==null) return null;
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode nodeLeft = mirrorCore(root.left);
        TreeNode nodeRight = mirrorCore(root.right);
        root.right=nodeLeft;
        root.left=nodeRight;
        return root;
    }

    public static void main(String[] args) {
//        String a="1$2$3$4$";
        String a="865$$7$$19$$2$$";
        TreeNode root = Question37.deserialize(a);
        TreeNode mirror = mirror(root);
        TreeNode root1 = mirror(mirror);
        String serialize = Question37.serialize(root1);
        System.out.println(serialize.equals(a));
    }
}
