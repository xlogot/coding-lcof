package question50.question55;

import question3.question07.Question07;
import question3.question07.Traversal;
import question3.question07.TreeNode;

import java.util.Stack;
import java.util.stream.StreamSupport;

public class Question55_1 {
    public static int getTreeDepth(TreeNode root){
        if (root==null)return 0;
        if (root.left==null&&root.right==null){
            return 1;
        }
        int depth=1;
        int leftDepth=getTreeDepth(root.left);
        int rightDepth=getTreeDepth(root.right);
        return (leftDepth>rightDepth) ? depth+leftDepth:depth+rightDepth;
    }

    static void postTraversal(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null){
            stack.push(root);
            root=root.left;
        }
        TreeNode isTraversal=null;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            //判断节点的右子树的节点是否是已经输出过,没有输出过,则将这个节点进栈, 迭代它的右子树
            if (node.right==null||node.right.equals(isTraversal)){
                isTraversal=node;
                System.out.println(node.key);
            }else {//否则入栈
                stack.push(node);
                //子树根节点的全部左节点,进栈.
                node=node.right;
                while (node!=null){
                    stack.push(node);
                    node=node.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,4,5,7,3,6};
        int[] b={4,2,7,5,1,3,6};
        TreeNode root = Question07.Construct(a, b, a.length);
//        int treeDepth = getTreeDepth(root);
//        System.out.println(treeDepth);
        Traversal.postOrderTraversal(root);
    }
}
