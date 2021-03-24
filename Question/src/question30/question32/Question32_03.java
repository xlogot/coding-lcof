package question30.question32;

import question3.question07.Question07;
import question3.question07.TreeNode;

import java.util.Stack;

public class Question32_03 {
    static void print(TreeNode head){
        if (head==null) return;
        Stack<TreeNode> oneOrLeftStack=new Stack<>();
        Stack<TreeNode> twoOrRightStack=new Stack<>();
        oneOrLeftStack.push(head);
        while (!oneOrLeftStack.isEmpty()||!twoOrRightStack.isEmpty()){
            if (twoOrRightStack.isEmpty()){
                while (!oneOrLeftStack.isEmpty()){
                    TreeNode pop = oneOrLeftStack.pop();
                    System.out.printf("%d ,", pop.key);
                    if (pop.left!=null) twoOrRightStack.push(pop.left);
                    if (pop.right!=null) twoOrRightStack.push(pop.right);
                }
                System.out.printf("\n");
            }else {
                while (!twoOrRightStack.isEmpty()){
                    TreeNode pop = twoOrRightStack.pop();
                    System.out.printf("%d ,", pop.key);
                    if (pop.right!=null) oneOrLeftStack.push(pop.right);
                    if (pop.left!=null) oneOrLeftStack.push(pop.left);
                }
                System.out.printf("\n");
            }
        }
    }

    public static void main(String[] args) {
        int[] pre={1,2,3,4};
        int[] mid={1,2,3,4};
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        print(t2);
    }
}
