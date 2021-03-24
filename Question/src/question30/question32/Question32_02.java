package question30.question32;

import question3.question07.Question07;
import question3.question07.TreeNode;

import javax.sql.PooledConnection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Question32_02 {
    public static void print(TreeNode head){
        if (head==null) return;
        int currentNode=0;
        int nextNode=0;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(head);
        nextNode++;
        while (!queue.isEmpty()){
            currentNode=nextNode;
            nextNode=0;
            for (int i = 0; i < currentNode; i++) {
                TreeNode poll = queue.poll();
                System.out.printf("%d ,", poll.key);
                if (poll.left!=null){
                    nextNode++;
                    queue.add(poll.left);
                }
                if (poll.right!=null) {
                    nextNode++;
                    queue.add(poll.right);
                }
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        int[] pre={8,6,5,7,10,9,11};
        int[] mid={5,6,7,8,9,10,11};
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        print(t2);
    }
}
