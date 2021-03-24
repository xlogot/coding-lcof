package question10.question15;

import java.sql.SQLOutput;

public class Question15_1 {
    static int numberOfBit1(int n){
        int count=0;
        int mask=1;
        while (mask!=0){
            if ((n&mask)==mask) count++;
            mask=mask<<1;
        }
        return count;
    }

    static int test1(int n){
        int count=0;
        while (n!=0){
            int x=n-1;
            System.out.println(x);
            System.out.printf("%x\n",x);
            n=n&x;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int i = test1(0x80000001);
        System.out.println(i);
    }
}
