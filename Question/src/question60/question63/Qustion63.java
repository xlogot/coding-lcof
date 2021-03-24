package question60.question63;

import java.util.Iterator;

public class Qustion63 {
    static int maxDiff(int[] numbers,int length){
        if (numbers==null||length<2) return -1;
        int max=Integer.MIN_VALUE;
        int minNumber=numbers[0];
        for (int i = 1; i < length; i++) {
            if (numbers[i]<minNumber) minNumber=numbers[i];
            int temp=numbers[i]-minNumber;
            if (temp>max) max=temp;
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a={9,11,8,5,7,12,16,18};
        int i = maxDiff(a, a.length);
        System.out.println(i);
    }
}
