package question20.question28;

import question3.question07.Question07;
import question3.question07.Traversal;
import question3.question07.TreeNode;

import java.util.EnumSet;

public class Question28 {
    public  static boolean isSymmetrical(TreeNode head){
        return isSymmetricalCore(head,head);
    }
    private static boolean isSymmetricalCore(TreeNode head1,TreeNode head2){
        if (head1==null){
            if (head2!=null) return false;
            else return true;
        }else {
            if (head2 == null) return false;
            else if (head1.key != head2.key) return false;
            return isSymmetricalCore(head1.left,head2.right)&&isSymmetricalCore(head1.right,head2.left);
        }
    }

    public static void main(String[] args) {
        int[] pre={6,5,7};
        int[] mid={5,6,7};
        int[] a={6,7};
        int[] b={7,6};

        TreeNode t1=new TreeNode(8);

        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        TreeNode t3 = Question07.Construct(a, b, a.length);
        t1.left=t2;
        t1.right=t3;
        Traversal.traversal(t1);

        System.out.println("===============");
        boolean symmetrical = isSymmetrical(t1);
        System.out.println(symmetrical);
    }
}
