package question20.question21;

import java.util.function.Function;
import java.util.function.Predicate;

public class Question21_1 {
    static void sort(int[] array){
        if (array==null) return;
        int evenIndex=-1;
        for (int i=0;i<array.length;i++){
            if ((array[i]&1)==1){
                //是奇数
                evenIndex++;
                exhange(array,evenIndex,i);
            }
        }
    }
    static void exhange(int[] array,int evenIndex,int i){
        if (evenIndex<0) return;
        if (evenIndex==i) return;
        int temp=array[evenIndex];
        array[evenIndex]=array[i];
        array[i]=temp;
    }

    static void sort(int[] array, Predicate<Integer> func){
        if (array==null) return;
        int evenIndex=-1;
        for (int i=0;i<array.length;i++){
            if (func.test(array[i])){
                //是奇数
                evenIndex++;
                exhange(array,evenIndex,i);
            }
        }
    }

    public static void main(String[] args) {
        int[] a={1,-2,3,4,-5};
//        int[] a={2};
        sort(a,integer -> integer>=0);

    }
}
