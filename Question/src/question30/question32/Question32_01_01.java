package question30.question32;

import question3.question07.Question07;
import question3.question07.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Question32_01_01 {
    static void  print(TreeNode root){
        ArrayList<Integer> a=new ArrayList<>();
        if (root==null) return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node==null) continue;
            System.out.printf("%d , ",node.key);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        int[] pre={8,6,5,7,10,9,11};
        int[] mid={5,6,7,8,9,10,11};
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        print(t2 );
    }
}
