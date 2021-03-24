package question30.question36;

import com.sun.source.tree.Tree;
import question3.question07.Question07;
import question3.question07.TreeNode;

import java.awt.*;

public class Question36 {
//    static TreeNode convertIntoLinkedList(TreeNode head){
//        if (head==null) return null;
//        TreeNode convert = convert(head.left, 0);
//        if (convert != null) {
//            head.left = convert;
//            convert.right = head;
//        }
//        TreeNode convert1 = convert(head.right, 1);
//        if (convert1 != null) {
//            head.right = convert1;
//            convert1.left = head;
//        }
//        return head;
//    }
//
//    static TreeNode convert(TreeNode head,int index){
//        if (head==null) return null;
//        if (head.right==null&&head.left==null) return head;
//        if(isMinimumSubTree(head)){
//            if (head.right==null){
//                head.left.right=head;
//                return head;
//            }else if (head.left==null){
//                head.right.left=head;
//                return head.right;
//            }else {
//                head.left.right=head;
//                head.right.left=head;
//            }
//            if (index==0) return head.right;
//            else return head.left;
//        }
//        TreeNode convert = convert(head.left, 0);
//        head.left=convert;
//        convert.right=head;
//        TreeNode convert1 = convert(head.right, 1);
//        head.right=convert1;
//        convert1.left=head;
//        return head;
//    }
//
//    private static boolean isMinimumSubTree(TreeNode head) {
//        if (head.left!=null){
//              TreeNode left=head.left;
//              if (left.left==null&&left.right==null) return true;
//        }
//        if (head.right!=null){
//            TreeNode right=head.right;
//            if (right.left==null&&right.right==null) return true;
//        }
//        return false;
//    }

    static TreeNode convert(TreeNode head){
        TreeNode lastNode=null;
        convertNode(head,lastNode);
        TreeNode headOfList=lastNode;
        while (headOfList!=null&&headOfList.left!=null)
            headOfList=headOfList.left;
        return headOfList;
    }

    private static void convertNode(TreeNode head, TreeNode lastNode) {
        if (head==null) return;
        TreeNode current=head;
        if (current.left!=null){
            convertNode(current.left,lastNode);
        }
        //两个节点进行连接
        current.left=lastNode;
        if (lastNode!=null){
            lastNode.right=current;
        }
        //将根节点作为最后一个节点,
        lastNode=current;
        if (current.right!=null){
            convertNode(current.right,lastNode);
        }
    }

    public static void main(String[] args) {
        int[] pre={10,6,4,8,14,12,16};
        int[] mid={4,6,8,10,12,14,16};
//        int[] pre={1,2,3};
//        int[] mid={1,2,3};
        TreeNode t2 = Question07.Construct(pre, mid, pre.length);
        TreeNode convert = convert(t2);

    }
}
