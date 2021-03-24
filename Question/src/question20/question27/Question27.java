package question20.question27;

import question3.question07.Question07;
import question3.question07.Traversal;
import question3.question07.TreeNode;

import java.util.HashMap;

public class Question27 {
    public static  void MirrorRecursively(TreeNode head){
        if (head==null) return;
        TreeNode temp=head.right;
        head.right=head.left;
        head.left=temp;
        MirrorRecursively(head.left);
        MirrorRecursively(head.right);
    }

    public static void main(String[] args) {
        int[] pre={8,6,5,7,10,9,11};
        int[] mid={5,6,7,8,9,10,11};
        int[] a={8,6,5,7,10};
        int[] b={5,6,7,8,10};

        TreeNode t1=new TreeNode(1);

        TreeNode tree = Question07.Construct(a, b, a.length);
        Traversal.traversal(tree);
        System.out.println("===============");
        MirrorRecursively(tree);
        Traversal.traversal(tree);
    }
}
