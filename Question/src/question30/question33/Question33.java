package question30.question33;

import java.util.Stack;

public class Question33 {
    static boolean verifySequenceOfBST(int[] sequence,int length){

        return verifySequenceOfBSTCore(sequence,0,length-1,length);

    }

    private static boolean verifySequenceOfBSTCore(int[] sequence, int start, int end, int length) {
        if (sequence==null||length<=0)  return false;
        if (start==end) return true;
        int root=sequence[end];
        int indexOfRightSubTree=0;
        for (int i = start; i <= end; i++) {
            if (sequence[i]>root) {
                indexOfRightSubTree=i;
                break;
            }
            if (i==end) indexOfRightSubTree=i-1;
        }


        //考虑到至于只有左子树和只有右子树的情况，只有左子树时，是不需要见过下面的循环的，会出错，前面已经检测过了
        if (indexOfRightSubTree != end - 1) {
            for (int i = indexOfRightSubTree; i <= end - 1; i++) {
                if (sequence[i] < root) return false;
            }
        }
        if (indexOfRightSubTree==0) return verifySequenceOfBSTCore(sequence,indexOfRightSubTree,end-1,length);
        else return verifySequenceOfBSTCore(sequence,start,indexOfRightSubTree-1,length)&&verifySequenceOfBSTCore(sequence,indexOfRightSubTree,end-1,length);
    }

    public static void main(String[] args) {
//        int[] t1={5,7,6,9,11,10,8};
        int[] t1={4,3,2,1};
        boolean b = verifySequenceOfBST(t1, t1.length);
        System.out.println(b);
    }
}
