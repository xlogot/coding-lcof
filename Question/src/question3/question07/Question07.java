package question3.question07;



/*
    输入某二叉树的前序遍历和中序遍历的结果，重建该二叉树。

 */
public class Question07 {
    public  static TreeNode Construct(int[] preorder, int[] midorder, int length){
        if (preorder==null||midorder==null||length<=0) return null;
        return constructCore(preorder, midorder,0,length-1,0,length-1);//实际从数组下标开始
    }

        private static TreeNode constructCore(int[] preorderSquential, int[] midorderSequential, int start1, int end1, int start2, int end2) {
            if (start1>end1) return null;
            if (start1==end1) return new TreeNode(preorderSquential[start1]);
            TreeNode root=new TreeNode(preorderSquential[start1]);

            int index=0;
            int num=0;
            /*
            这里需要两个变量，其中index记录中序序列的下标，用于中序序列数组的开始和边界。分析出中序序列中左子树和右子树
                                num用于记录中序序列数组中从开始到根节点有几个左子树节点，根据这个num的值，在前序序列中分许出左子树和右子树
             */

            for (int i = start2; i < midorderSequential.length; i++,num++) {
                if (midorderSequential[i]==root.key) {
                    index=i;
                    break;
                }
            }
            root.left= constructCore(preorderSquential,midorderSequential,start1+1,start1+num,start2,index-1);
            root.right= constructCore(preorderSquential,midorderSequential,start1+num+1,end1,index+1,end2);

            return root;
        }

    public static void main(String[] args) {
        //不完全二叉树
        int[] a={1,2,4,7,3,5,6,8};
        int[] b={4,7,2,1,5,3,8,6};
        //完全二叉树
        int[] c={1,2,4,5,3,6,7};
        int[] d={4,2,5,1,6,3,7};
        TreeNode root= Construct(c,d,c.length);
//        Traversal.preOrderTraversal(root);
        Traversal.traversal(root);

    }
}
