package question3.question07;

public class Question07_1 {
    static TreeNode construct(int[] preOrder,int[] midOrder){
        if(preOrder==null||midOrder==null) return null;
        if (preOrder.length!=midOrder.length) return null;
        return constructCore(preOrder,midOrder,0,preOrder.length-1,0,preOrder.length-1);
    }

    private static TreeNode constructCore(int[] preOrder, int[] midOrder, int preStartIndex, int preEndIndex, int midStartIndex, int midEndIndex) {
        if (preEndIndex==preStartIndex||midEndIndex==midStartIndex)  return new TreeNode(preOrder[preEndIndex]);
        int rootKey=preOrder[preStartIndex];
        int rootKeyIndexInMidOrder = getRootKeyIndexInMidOrder(rootKey, midOrder, midStartIndex, midEndIndex);

        int leftSubTreeNodes=rootKeyIndexInMidOrder-midStartIndex;
        int rightSubTreeNodes=midEndIndex-rootKeyIndexInMidOrder;

        TreeNode root=new TreeNode(rootKey);
        //左右子树的数量为0 ,代表没有左右子树, 不需要迭代
        if (leftSubTreeNodes!=0) {
            root.left = constructCore(preOrder, midOrder, preStartIndex + 1, preStartIndex + leftSubTreeNodes, midStartIndex, midStartIndex + leftSubTreeNodes - 1);
        }
        if (rightSubTreeNodes!=0) {
            root.right = constructCore(preOrder, midOrder, preEndIndex - rightSubTreeNodes + 1, preEndIndex, midEndIndex - rightSubTreeNodes + 1, midEndIndex);
        }
        return root;
    }

    private static int getRootKeyIndexInMidOrder(int rootKey, int[] midOrder,int start,int end) {
        int index=start;
        for (int i=start;i<=end;i++){
            if (rootKey==midOrder[i]) index=i;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] pre={1,2,4,7,3,5,6,8};
        int[] mid={4,7,2,1,5,3,8,6};
        TreeNode construct = construct(pre, mid);

    }
}
