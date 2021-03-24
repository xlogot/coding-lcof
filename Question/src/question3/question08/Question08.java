package question3.question08;
/*
    给定一颗二叉树和其中的一个节点。如何找出中序遍历序列的下一个节点。树中的节点除了有两个分别指向左右指结点的指针，还有一个指向父节点的指针。
    总共有4种情况，根据这4种情况来编写相对应的算法。
 */
public class Question08 {
    public static BinaryTreeNode getNext(BinaryTreeNode node) {
        //首先判断是否非空
        if (node == null) return null;
        if (node.right != null) {
            BinaryTreeNode right = node.right;
            while (right != null) {
                if (right.left != null) right = right.left;
                else break;
            }
            return right;
        } else {
            if (node.parent.right != node) {//节点的父节点，是下一个输出
                return node.parent;
            } else {
                BinaryTreeNode temp=node.parent;
                BinaryTreeNode temp1=node.parent;
                while (temp!=null&&temp.left!=temp1){
                    temp1=temp;//循环向上找父节点,空节点或者找到了就退出
                    temp=temp.parent;
                }
                if (temp==null){
                    return null;
                }
                else return temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,4,7,3,5,6,8};
        int[] b={4,7,2,1,5,3,8,6};

        BinaryTreeNode tree= BinaryTreeNode.construct(a,b,a.length);
        BinaryTreeNode node5=tree.right.right;
        BinaryTreeNode test=getNext(node5);
        System.out.println(test.value);
    }
}
