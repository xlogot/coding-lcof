package question30.question32;

import question3.question07.Question07;
import question3.question07.TreeNode;
import question30.question37.Question37;

import java.util.LinkedList;
import java.util.Queue;

public class Question32_02_01 {
    static void  print(TreeNode root){
        if (root==null) return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=1;
        int nextCount=0;
        while (!queue.isEmpty()){
            for (int i=1;i<=count;i++){
                TreeNode node = queue.poll();
                if (node == null) continue;
                System.out.printf("%d , ", node.key);
                if (node.left != null) {
                    queue.add(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextCount++;
                }
            }
            System.out.printf("\n");
            count=nextCount;
            nextCount=0;
        }
    }

    public static void main(String[] args) {
        int[] pre={8,6,5,12,7,10,9,11};
        int[] mid={12,5,6,7,8,9,10,11};
//                String a="8657$$7$$97$$5$$";
//                String a="8657$$7$$97$$5$$";
//        String a="123$$$";
//        TreeNode root = Question37.deserialize(a);
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        print(t2);
    }
}
