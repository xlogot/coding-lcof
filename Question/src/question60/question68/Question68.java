package question60.question68;

import question3.question07.Question07;
import question3.question07.TreeNode;
import question50.question54.Question54;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Question68 {
    static TreeNode getNodePath(TreeNode root,int nodeValue1,int nodeValue2){
        if (root==null) return null;
        List<TreeNode> list1=new LinkedList<>();
        List<TreeNode> list2=new LinkedList<>();
        //获取每个值的path
        boolean result1 = getNodePath(root, nodeValue1, list1);
        boolean result2 = getNodePath(root, nodeValue2, list2);
        TreeNode commonNode=null;
        if (result1&&result2) {
            //获取公共节点, 类似一道之前的题目, 给定一个链表求其公共节点.
            commonNode = getCommonNode(list1, list2);
        }
        return commonNode;
    }

    private static TreeNode getCommonNode(List<TreeNode> list1, List<TreeNode> list2) {
        int size1 = list1.size();
        int size2 = list2.size();
        Iterator<TreeNode> iterator1 = list1.iterator();
        Iterator<TreeNode> iterator2= list2.iterator();
        boolean a=size1>size2;
        int offset=size1>size2? size1-size2:size2-size1;
        if (a){
            for (;offset>0;offset--) {
                iterator1.hasNext();
                iterator1.next();
            }
        }else {
            for (;offset>0;offset--) {
                iterator2.hasNext();
                iterator2.next();
            }
        }
        while (iterator1.hasNext()&&iterator2.hasNext()){
            TreeNode node1 = iterator1.next();
            TreeNode node2 = iterator2.next();
            if (node1.key==node2.key) return node1;
        }
        return null;
    }

    //使用递归求解, 将大问题分解成可重复求解的小问题.
    /*
    如果这个value在root节点的左右子树中, 那么将这个节点记录下来.
    将上述思想转化为递归的思想.
     */
    static boolean getNodePath(TreeNode root, int value, List<TreeNode> path) {
        boolean found = false;
        if (root == null) return found;
        if (root.key == value) return true;
        found = getNodePath(root.left, value, path);
        if (found) {
            path.add(root);
            return true;
        }
        found = getNodePath(root.right, value, path);
        if (found) {
            path.add(root);
            return true;
        }
        return found;
    }

    public static void main(String[] args) {
//        int[] a={5,3,2,4,7,6,8};
//        int[] b={2,3,4,5,6,7,8};
        int[] a={5,3,2,1,4,7,6,8};
        int[] b={1,2,3,4,5,6,7,8};
//        int[] a={4,6,5,7,1,9,10,8};
//        int[] b={1,7,9,10,5,6,4,8};

        TreeNode construct = Question07.Construct(a, b, a.length);
        List<TreeNode> path=new LinkedList<>();
        TreeNode node = getNodePath(construct, 1, 3  );
        if (node!=null){
            System.out.println(node.key);
        }else {
            System.out.println("not found");
        }
    }
}
