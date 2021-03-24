package question30.question34;

import com.sun.tools.javac.Main;
import question3.question07.Question07;
import question3.question07.TreeNode;

import java.util.Stack;

public class Question34 {
    static void findPath(TreeNode head,int expectedNum){
        if (head==null) return;
        if (expectedNum<0) return;
        Stack<TreeNode> stack=new Stack<>();
        findPathCore(head,expectedNum,stack);
    }

    private static void findPathCore(TreeNode head, int expectedNum, Stack<TreeNode> stack) {
        if (head==null)return;
        stack.push(head);
        int numLeft=expectedNum-head.key;
        if (numLeft==0){
            printPath(stack);
            stack.pop();
            return;
        }
        if (numLeft<0){
            stack.pop();
            return;
        }
        findPathCore(head.left,numLeft,stack);
        findPathCore(head.right,numLeft,stack);
        if (!stack.isEmpty()) stack.pop();
    }

    private static void printPath(Stack<TreeNode> stack) {
        stack.forEach((treeNode -> {
            System.out.printf("%d ,", treeNode.key);
        }));
        System.out.println("\n");
    }

    public static void main(String[] args) {
//        int[] pre={10,5,4,7,12};
//        int[] mid={4,5,7,10,12};
        int[] pre={8,6,4,7,10,9,11};
        int[] mid={4,6,7,8,9,10,11};
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        findPath(t2,100);
    }
}
