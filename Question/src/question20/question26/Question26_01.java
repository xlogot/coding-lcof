package question20.question26;

import com.sun.source.tree.Tree;
import org.w3c.dom.Node;
import question3.question07.TreeNode;
import question30.question37.Question37;

import java.awt.geom.Rectangle2D;

public class Question26_01 {
    static boolean hasSubtree(TreeNode A,TreeNode B){
        if (A==null||B==null) return false;
        int index=0;
        TreeNode node=findNode(A,B,index);
        boolean result=false;
        while (node!=null){
            result=hasSubtreeCore(node.left,B.left);
            result=result&&hasSubtreeCore(node.right,B.right);
            if (result) break;
//            index++;
            node=findNode(A,B,++index);
        }
        return result;
    }

    private static boolean hasSubtreeCore(TreeNode root1, TreeNode root2) {
        if (root1==null&&root2!=null) return false;
        if (root2==null) return true;
        boolean result=false;
        if (root1.key== root2.key){
            result=hasSubtreeCore(root1.left,root2.left);
            result=result&&hasSubtreeCore(root1.right,root2.right);
        }
        return result;
    }

    private static TreeNode findNode(TreeNode root1, TreeNode root2,int index) {
        if (root1==null) return null;
        TreeNode node;
        if (root1.key==root2.key){
            if (--index>=0){
                node= findNode(root1.left,root2,index);
                if (node==null){
                    node=findNode(root1.right,root2,index);
                }
                return node;
            }
            return root1;
        }
        node= findNode(root1.left,root2,index);
        if (node==null){
            node=findNode(root1.right,root2,index);
        }
        return node;
    }

    public static void main(String[] args) {
        String a="889$$24$$7$$7$$";
        TreeNode root1 = Question37.deserialize(a);
        String b="89$$8$$";
//        String b="889$$24$$7$$7$$";

        TreeNode root2 = Question37.deserialize(b);
        boolean b1 = hasSubtree(root1, root2);
        System.out.println(b1);
    }
}
