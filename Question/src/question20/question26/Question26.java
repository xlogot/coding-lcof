package question20.question26;


import question3.question07.Question07;
import question3.question07.Traversal;
import question3.question07.TreeNode;


public class Question26 {
    static boolean hasSubtree(TreeNode root,TreeNode test){
        if (root==null||test==null)  return false;
        return hasSubtreeCore(root, test);
    }

    static  boolean hasSubtreeCore(TreeNode root1, TreeNode subTree){
        if (root1==null) return false;
        boolean res=false;
        if (root1.key==subTree.key) {
            res=reallyHasTree(root1,subTree);
        }else {
            res= hasSubtreeCore(root1.left,subTree)||hasSubtreeCore(root1.right,subTree);
        }
        return res;
    }

    private static boolean reallyHasTree(TreeNode root, TreeNode subTree) {
        if (root==null) return false;
        if (subTree==null) return true;
        boolean res=false;
        if ((subTree.left==null&&subTree.right==null)&&subTree.key==root.key) return true;
        res=reallyHasTree(root.left,subTree.left);
        res=res&&reallyHasTree(root.right,subTree.right);
        return res;
    }

    public static void main(String[] args) {
        int[] pre={6,8,9,2,4,7,7};
        int[] mid={9,8,4,2,7,6,7};

        int[] a={7,6};
        int[] b={7,6};
        //148
        TreeNode tree = Question07.Construct(pre, mid, mid.length);
        TreeNode test = Question07.Construct(a, b, a.length);
        //Traversal.traversal(tree);
        boolean b1 = hasSubtree(tree, test);
        System.out.println(b1);
    }
}
