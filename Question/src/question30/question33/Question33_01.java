package question30.question33;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Question33_01 {
    static boolean isPostOrder(int[] data){
        if (data==null) return false;
        return isPostOrderCore(data,0,data.length-1);
    }

    private static boolean isPostOrderCore(int[] data,int sI,int eI) {
        if (sI==eI) return true;
        if (sI>eI) return false;

        int length=eI-sI+1;
        int number=data[eI];
        int leftSI=sI;
        int leftEI=sI;
        int rightSI=sI;
        int rightEI=sI;

        if (number>data[leftSI]){
            for (;number>data[leftEI];leftEI++);
            leftEI-=1;
            rightSI=leftEI+1;
            rightEI=leftEI+1;
            while (rightEI<eI&&number<data[++rightEI]){

            }
            rightEI-=1;
            if (leftEI!=eI-1) if (rightEI!=eI-1) return false;
        }else {
            while (leftEI<eI&&number<data[++leftEI]){
            }
            leftEI-=1;
            if (leftEI!=eI-1) return false;
        }
        return isPostOrderCore(data,leftSI,leftEI)&&isPostOrderCore(data,rightSI,rightEI);
    }

    public static void main(String[] args) {
//        int[] t1={5,7,6,9,11,10,8};
//        int[] t1={4,3,2,1};
        int[] t1={4};
//        int[] t1={7,4,6,5};
        boolean b = isPostOrder(t1);
        System.out.println(b);
    }
}
