package question40.question49;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class Question49_solution2 {
    static int getUglyNumber(int index){
        if (index<=0) return -1;
        int[] uglyNumbers=new int[index];
        uglyNumbers[0]=1;
        int nextUglyIndex=1;
        int Multiply2=0;
        int Multiply3=0;
        int Multiply5=0;
        while (nextUglyIndex<index){
            int min=Math.min(uglyNumbers[Multiply5]*5,Math.min(uglyNumbers[Multiply2]*2,uglyNumbers[Multiply3]*3));
            uglyNumbers[nextUglyIndex]=min;
            while (uglyNumbers[Multiply2]*2<=uglyNumbers[nextUglyIndex]){
                Multiply2++;
            }
            while (uglyNumbers[Multiply3]*3<=uglyNumbers[nextUglyIndex]){
                Multiply3++;
            }
            while (uglyNumbers[Multiply5]*5<=uglyNumbers[nextUglyIndex]){
                Multiply5++;
            }

            nextUglyIndex++;
        }
        int ugly=uglyNumbers[index-1];
        return ugly;
    }

    public static void main(String[] args) {
        int uglyNumber = getUglyNumber(10);
        System.out.println(uglyNumber);
    }
}
