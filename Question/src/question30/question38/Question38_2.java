package question30.question38;

import java.sql.Connection;

public class Question38_2 {
    static void combine(char[] string){
        if (string==null) return;
        int index = 0;
        for (int i = 1; i <= string.length; i++) {
            System.out.printf("前 %d \n",i);
            combine(string, index, i);
            System.out.printf("\n");
        }

    }
    static void combine(char[] string , int index,int lengthToCombine){
        if (index>=string.length) return;
        int endIndex=string.length-1;
        int leftNums=endIndex-index;
        if (leftNums-lengthToCombine<-1) {
            return;
        }
        if (lengthToCombine<=0) {
            return;
        }
        System.out.printf("%c",string[index]);
        combine(string,index+1,lengthToCombine-1);
        System.out.printf("\n");
        combine(string,index+1,lengthToCombine);

    }

    public static void main(String[] args) {
        char[] string={'a','b','c','d','e'};
        combine(string);
    }
}
