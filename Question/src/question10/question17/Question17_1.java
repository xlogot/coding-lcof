package question10.question17;

import com.sun.source.tree.IfTree;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;


public class Question17_1 {
    //long类型最多支持18个9的出现
    static void printNumber(int n){
        if (n<=0) return;
        if (n<=18){
            long maxNumber = getMaxNumber(n);
            for (long i=0;i<=maxNumber;i++){
                System.out.println(i);
            }
        }
        else {
            printNumberString(n);
        }
    }

    private static void printNumberString(int n) {
        char[] s=new char[n];
        for (int i=0;i<n;i++){
            s[i]='0';
        }
        while (printTheLastNumber(s)){
            boolean flag=false;
            if (s[0]==9)
            s[0]=(char)(s[0]+1);
        }
    }

    static void  printNumberRecursive(int n){
        if (n<=0) return;
        StringBuilder sb=new StringBuilder();
        sb.setLength(n);
//        for (int i=0;i<=10;i++){
            print(sb,n,0);
//        }

    }
    static void print(StringBuilder sb,int n,int index){
        if (index==n) {
            System.out.println(sb);
            return;}
        for (int i=0;i<=9;i++){
            char i1 =(char) ('0'+ i);
            sb.setCharAt(index,i1);
            print(sb,n,index+1);
        }
    }

    private static boolean printTheLastNumber(char[] s) {
        if (s[s.length-1]!='9') return false;
        else {
            for (int i=0;i<s.length;i++){
                if (s[i]!=9) return false;
            }
            return true;
        }
    }

    private static long getMaxNumber(int n) {
        long result=1;
        for (int i=1;i<=n;i++){
            result=result*10;
        }
        return result-1;
    }

    public static void main(String[] args) {
        printNumberRecursive(3);
    }
}
