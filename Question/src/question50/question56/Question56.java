package question50.question56;

import java.nio.file.Path;
import java.time.chrono.IsoChronology;
import java.util.Date;
import java.util.concurrent.RecursiveTask;

public class Question56 {
    static class Data{
        int num;
    }
    static void findNumsAppearOnce(int[] data, int length, Data num1, Data num2){
        if (data==null||length<2) return;
        int resultXOR=0;
        for (int i = 0; i < length; i++) {
            resultXOR ^=data[i];
        }
        int indexOf1=findFirstBit1(resultXOR);

        for (int i = 0; i < length; i++) {
            if (isBit1(data[i],indexOf1)) {
                num1.num^=data[i];
            }else {
                num2.num^=data[i];
            }
        }
    }

    private static boolean isBit1(int datum, int indexOf1) {
        datum=datum>>indexOf1;
        return (datum&1)==1;
    }

    private static int findFirstBit1(int resultXOR) {
        int index=0;
        int result=0;
        while (result!=1 ){
            result=resultXOR&1;
            if (result==0) {
                resultXOR =resultXOR>>1;
                index++;
            }
            else break;
        }
        return index;
    }

    public static void main(String[] args) {
//        int[] a={2,4,3,6,3,2,5,5};
        int[] a={2,4/*,3,6,3,2,5,5*/};
        Data num1=new Data();
        Data num2=new Data();

        findNumsAppearOnce(a,a.length,num1,num2);
        System.out.println(num1.num);
        System.out.println(num2.num);
    }
}
