package question3.question08;

/*
第八题的数据结构,能指向父节点的二叉树
 */
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;
    public BinaryTreeNode(){}
    public BinaryTreeNode(int key){
        this.value=key;
    }
    public static BinaryTreeNode construct(int[] preorder, int[] midOrder, int length){
        if (preorder==null||midOrder==null||length<=0) return null;
        return constructCore(preorder, midOrder,0,length-1,0,length-1);//实际从数组下标开始
    }

    private static BinaryTreeNode constructCore(int[] preorderSquential, int[] midorderSequential, int start1, int end1, int start2, int end2) {
        if (start1>end1) return null;
        if (start1==end1) return new BinaryTreeNode(preorderSquential[start1]);
        BinaryTreeNode root=new BinaryTreeNode(preorderSquential[start1]);

        int index=0;
        int num=0;

        for (int i = start2; i < midorderSequential.length; i++,num++) {
            if (midorderSequential[i]==root.value) {
                index=i;
                break;
            }
        }
        root.left= constructCore(preorderSquential,midorderSequential,start1+1,start1+num,start2,index-1);
        if (root.left!=null) root.left.parent=root;
        root.right= constructCore(preorderSquential,midorderSequential,start1+num+1,end1,index+1,end2);
        if (root.right!=null) root.right.parent=root;

        return root;
    }

}
