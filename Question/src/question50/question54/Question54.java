package question50.question54;

import question3.question07.Question07;
import question3.question07.TreeNode;

import java.util.concurrent.SynchronousQueue;

public class Question54 {
    static TreeNode KthNode(TreeNode head,Kth k){
        if (head==null||k.k==0) return null;
        return kthNodeCore(head,k);
    }

    private static TreeNode kthNodeCore(TreeNode head, Kth k) {
        TreeNode target=null;
        if (head.left!=null){
            target=kthNodeCore(head.left,k);
        }
        if (target==null){
            if (k.k==1) target=head;
            k.k--;
        }
        if (target==null&&head.right!=null){
            target=kthNodeCore(head.right,k);
        }
        return target;
    }

    public static void main(String[] args) {
        int[] a={5,3,2,4,7,6,8};
        int[] b={2,3,4,5,6,7,8};

//        SynchronousQueue

        Kth k=new Kth(3);
        TreeNode construct = Question07.Construct(a, b, a.length);
        TreeNode treeNode = KthNode(construct, k);
        System.out.println(treeNode.key);
    }
    static  class  Kth{
        public Kth(int k) {
            this.k = k;
        }

        int k;
    }
}
