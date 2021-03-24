package question30.question34;

import question3.question07.Question07;
import question3.question07.TreeNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;


public class Question34_01 {
    static void findPath(TreeNode root,int number){
        if (root==null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        findPath(root,number,stack);
    }

    private static void findPath(TreeNode root, int number, Stack<TreeNode> stack) {
        if (root.left==null&&root.right==null) {
            int count=number-root.key;
            if (count==0){
                print(stack);
            }
            return;
        }
        int left=number-root.key;
        if (root.left!=null){
            stack.push(root.left);
            findPath(root.left,left,stack);
        }
        stack.pop();
        if (root.right!=null){
            stack.push(root.right);
            findPath(root.right,left,stack);
        }
        stack.pop();
    }
    static void print(Stack<TreeNode> stack){
        Iterator<TreeNode> iterator = stack.iterator();
        while (iterator.hasNext()){
            TreeNode next = iterator.next();
            System.out.printf("%d, ", next.key);
        }
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        //        int[] pre={10,5,4,7,12};
//        int[] mid={4,5,7,10,12};
//        int[] pre={8,6,4,7,10};
//        int[] mid={4,6,7,8,10};
        int[] pre={8};
        int[] mid={8};
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        findPath(t2,8);
    }
}
