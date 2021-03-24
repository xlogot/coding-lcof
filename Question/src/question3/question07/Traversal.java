package question3.question07;
/*
    用非递归的形式实现树的遍历
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
    //出栈的时候打印是中序遍历
    public static void midOrderTraversal(TreeNode root){
        if (root==null) return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        while (!stack.isEmpty()||temp!=null){
            while (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            if (!stack.isEmpty()){
                temp=stack.pop();
                System.out.println(temp.key);
                temp=temp.right;
            }
        }
    }
    //进栈的时候打印是前序遍历
    public static void preOrderTraversal(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                System.out.println(root.key);
                stack.push(root);
                root=root.left;
            }
            if (!stack.isEmpty()){
                root=stack.pop().right;
            }
        }
    }
    //是中序遍历的变形，也是出栈的时候打印，但要记录已经打印过的节点，出站的是子树的根节点还要判断是否有右子树。
    public static void postOrderTraversal(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode leftTree=null;
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root= root.left;
            }
            if (!stack.isEmpty()){
                root=stack.pop();
                if (root.right==null||root.right.equals(leftTree)){
                    System.out.println(root.key);
                    leftTree=root;//记录打印过的节点
                    root=null;//打印过的节点需要将其设为null，防止进入下一个循环时，进入死循环。
                }else {
                    stack.push(root);
                    root=root.right;
                }
            }
        }
    }

    //层序遍历
    public static void traversal(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//linkedList实现了队列接口
        TreeNode i = tree;
        queue.add(i);
        while (!queue.isEmpty()) {//结束条件是队列是不是空的
            var t = queue.remove();
            System.out.println(t.key);
            if (t.left != null)
                queue.add(t.left);
            if (t.right != null)
                queue.add(t.right);
        }
    }
}
