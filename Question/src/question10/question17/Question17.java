package question10.question17;

import javax.swing.event.TreeWillExpandListener;
import java.util.Spliterator;

public class Question17 {

    //n小于小于18,一般用long就可以了,递归或者循环实在是浪费性能.

    //这种解法没有注意到n的范围.
    public static void Print1ToMaxOfN_1(int n){
        if (n<=0) return;
        int i=0;
        int temp=1;
        //这种判断方法会比n大一个数
        while (i++<n){
            temp*=10;
        }
        for (int j = 1; j < temp; j++) {
            System.out.println(j);
        }
    }

    //用字符串进行表示
    public static void Print1ToMaxOfN_2(int n){
        if (n<=0) return;
        char[] str=new char[n];
        for (int i = 0; i < n; i++) {
            str[i]='0';
        }
        while (!increment(str)){
            printNumber(str);
        }
    }
    private static void printNumber(char[] str) {
        boolean endOfZero=false;
        for (int i = 0; i < str.length; i++) {
            if (str[i]!='0') endOfZero=true;
            if (endOfZero) System.out.printf("%c",str[i]);
        }
        System.out.printf("\n");
    }
    //整个数据的表示是数组的低位表示这个数字的高位.
    //可以用数组的低位对应数组的低位,这种对应方式进行实现.
    private static boolean increment(char[] str) {
        boolean isOverflow=false;
        //进位标识
        int nTakeOver=0;
        int nLength=str.length;
        for (int i = nLength-1; i >= 0; i--) {
            int nSum=str[i]-'0'+nTakeOver;
            if (i==nLength-1) nSum++;
            if (nSum>=10){
                if (i==0)
                    isOverflow=true;
                else {
                    nSum-=10;
                    nTakeOver=1;
                    str[i]= (char) ('0'+nSum);
                }
            }else {
                str[i]= (char) ('0'+nSum);
                break;
            }
        }
        return isOverflow;
    }

    public static void Print1ToMaxOfN_3(int n){
        if (n<=0) return;
        char[] number=new char[n];
        for (int i = 0; i < 10; i++) {
            number[0]= (char) (i+'0');
            print1ToMaxOfNRecursively(number,n,0);
        }
    }

    private static void print1ToMaxOfNRecursively(char[] number, int length, int index) {
        if (index==length-1) {
            //printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index+1]= (char) (i+'0');
            print1ToMaxOfNRecursively(number,length,index+1);
        }
    }

    public static void main(String[] args) {
        Print1ToMaxOfN_3(18);
    }
}
