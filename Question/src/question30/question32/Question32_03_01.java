package question30.question32;

import question3.question07.Question07;
import question3.question07.TreeNode;

import javax.swing.*;
import java.util.Stack;

public class Question32_03_01 {
    static void  print(TreeNode root){
        if (root==null) return;
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            if (stack1.isEmpty()){
                while (!stack2.isEmpty()){
                    TreeNode node=stack2.pop();
                    System.out.printf("%d ,",node.key);
                    if (node.right!=null){
                        stack1.push(node.right);
                    }if (node.left!=null){
                        stack1.push(node.left);
                    }
                }
                System.out.printf("\n");
            }else {//stack1不为空,从右子树进栈
                while (!stack1.isEmpty()){
                    TreeNode node=stack1.pop();
                    System.out.printf("%d ,",node.key);
                    if (node.left!=null){
                        stack2.push(node.left);
                    }if (node.right!=null){
                        stack2.push(node.right);
                    }
                }
                System.out.printf("\n");
            }
        }
    }

    public static void main(String[] args) {
//        int[] pre={1,2,3,4};
//        int[] mid={1,2,3,4};
        int[] pre={8,6,5,12,7,10,9,11};
        int[] mid={12,5,6,7,8,9,10,11};
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        print(t2);
    }
}
