package question30.question32;

import question3.question07.Question07;
import question3.question07.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Question32_01 {
    public static void TraversalBinaryTree(TreeNode head){
        if (head==null) return;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.printf("%d ,",poll.key);
            if (poll.left!=null) queue.add(poll.left);
            if (poll.right!=null) queue.add(poll.right);
        }
    }

    public static void main(String[] args) {
        int[] pre={8,6,5,7,10,9,11};
        int[] mid={5,6,7,8,9,10,11};
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        TraversalBinaryTree(t2);
    }
}
