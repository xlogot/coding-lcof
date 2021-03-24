package question30.question36;

import question3.question07.Question07;
import question3.question07.TreeNode;

import java.util.TooManyListenersException;

public class Question36_01 {
    static TreeNode transform(TreeNode root){
        if (root==null) return null;
        transformCore(root);
        TreeNode head=root;
        while (head!=null&&head.left!=null){
            head=head.left;
        }
        return head;
    }

    private static void transformCore(TreeNode root) {
        if (root==null) return;
        TreeNode max = findMax(root.left);
        TreeNode min = findMin(root.right);
        transformCore(root.left);
        transformCore(root.right);
        if (max!=null&&max.key!=root.key){
            root.left=max;
            max.right=root;
        }
        if (min!=null&&min.key!=root.key){
            root.right=min;
            min.left=root;
        }
    }

    private static TreeNode findMax(TreeNode root) {
        while (root!=null&&root.right!=null){
            root=root.right;
        }
        return root;
    }

    private static TreeNode findMin(TreeNode root) {
        while (root!=null&&root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre={10,6,4,8,14,12,16};
        int[] mid={4,6,8,10,12,14,16};
//        int[] pre={1,2,3};
//        int[] mid={1,2,3};
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        TreeNode convert = transform(t2);
    }
}
