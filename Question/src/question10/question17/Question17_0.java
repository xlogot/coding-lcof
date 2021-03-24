package question10.question17;

import java.nio.file.attribute.AclEntry;
import java.util.Arrays;

public class Question17_0 {
    public static void Print1ToMaxOfN_1(int n){
        if (n<=0)return;
        int temp=1;
        int i=0;
        while (i++<n){
            temp*=10;
        }
        for (int j = 1; j < temp; j++) {
            System.out.println(j);
        }
    }

    public static void Print1ToMaxOfN_2(int n){
        if (n<=0)return;
        char[] number=new char[n];
//        for (int i = 0; i < number.length; i++) {
//            number[i]='0';
//        }
        Arrays.fill(number,'0');
        while (!isOverflow(number)){
            printNumber(number);
        }
    }
    private static boolean isOverflow(char[] number) {
        int nTakeOver=0;
        int num;
        int end=number.length-1;
        for (int i = end; i >= 0; i--) {
            num=number[i]-'0'+nTakeOver;
            if (i==end) num++;
            if (i==0){
                if (num>=10) return true;
                else{
                    number[i]= (char) ('0'+num);
                }
            }else {
                if (num>=10){
                    num-=10;
                    nTakeOver=1;
                    number[i]= (char) ('0'+num);
                }else {
                    number[i]= (char) ('0'+num);
                    nTakeOver=0;
                }
            }
        }
        return false;

    }
    private static void printNumber(char[]  str) {
        boolean endOfZero=false;
        for (int i = 0; i < str.length; i++) {
            if (str[i]!='0') endOfZero=true;
            if (endOfZero) System.out.printf("%c",str[i]);
        }
        System.out.printf("\n");
    }

    public static void Print1ToMaxOfN_3(int n){
        if (n<=0) return;
        char[] number=new char[n];
        Arrays.fill(number,'0');
        int length=number.length;
        for (int i = 0; i < 10; i++) {
            number[length-1]= (char) ('0'+i);
            printNumberRecursively(number,length,length-1);
        }
    }

    private static void printNumberRecursively(char[] number, int length, int index) {
       if (index==0){
           printNumber1(number);
           return;
       }
        for (int i = 0; i < 10; i++) {
            number[index-1]= (char) ('0'+i);
            printNumberRecursively(number,length,index-1);
        }
    }
    private static void printNumber1(char[]  str) {
        boolean endOfZero=false;
        int highBit=str.length-1;
        for (int i = highBit; i >= 0; i--) {
            if (str[i]!='0') endOfZero=true;
            if (endOfZero) System.out.printf("%c",str[i]);
        }
        System.out.printf("\n");
    }

    public static void Print1ToMaxOfN_4(int n){
        if (n<=0)return;
        long temp=1;
        int i=0;
        while (i++<n){
            temp*=10;
        }
        for (int j = 1; j < temp; j++) {
            //System.out.println(j);
        }
    }

    public static void main(String[] args) {
        Print1ToMaxOfN_4(18);
    }
}
