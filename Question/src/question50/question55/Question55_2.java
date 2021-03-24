package question50.question55;

import question3.question07.Question07;
import question3.question07.TreeNode;

public class Question55_2 {
    static boolean isBalancedTree(TreeNode root){
        if (root==null) return true;
        int leftDepth=Question55_1.getTreeDepth(root.left);
        int rightDepth=Question55_1.getTreeDepth(root.right);
        int diff=leftDepth-rightDepth;
        if (diff>1||diff<-1){
            return false;
        }
        return isBalancedTree(root.left)&&isBalancedTree(root.right);
    }

    static class Depth{
        int num;
    }
    static boolean isBalanced(TreeNode root){
        Depth depth=new Depth();
        return isBalanced(root,depth);
    }
    static boolean isBalanced(TreeNode root, Depth depth){
        if (root==null) {
            depth.num=0;
            return true;
        }
        Depth left=new Depth(),right=new Depth();
        //记录子树的深度, 从而减少对子树的重复访问
        if (isBalanced(root.left,left)&&isBalanced(root.right,right)){
            int diff=left.num-right.num;
            if (diff<=1&&diff>=-1){
                depth.num=1+(left.num>right.num? left.num:right.num);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] a={1,2,4,5,7,3,6};
//        int[] b={4,2,7,5,1,3,6};
        int[] a={1,2,3};
        int[] b={1,2,3};
        TreeNode root = Question07.Construct(a, b, a.length);
        boolean balanced = isBalanced(root);
        System.out.println(balanced);
    }
}
