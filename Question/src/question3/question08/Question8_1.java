package question3.question08;

import java.util.TooManyListenersException;

public class Question8_1 {
    static BinaryTreeNode nextNode(BinaryTreeNode node){
        if (node==null) return null;
        if (node.right!=null){//如果它有右子树
            BinaryTreeNode temp=node.right;
            while (temp.left!=null){
                temp= temp.left;
            }
            return temp;
        }else {//没有右子树
            if (node.parent.left==node){
                //这个节点是父节点左子树的节点
                return node.parent;
            }else { //找到一个父节点, 这个节点是父节点的左子树
                BinaryTreeNode temp=node.parent;
                BinaryTreeNode temp1=node;
                while (temp.left!=temp1){
                    if (temp.parent==null) return null;
                    temp1=temp;
                    temp=temp.parent;
                }
                return temp;
            }
        }
    }
}
