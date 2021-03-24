package question30.question39;

import javax.sound.midi.MidiChannel;
import java.time.chrono.MinguoChronology;
import java.util.Random;

public class Question39_01 {
    static int findNumber(int[] array){
        //利用二分查找进行排查
        //主要的目的就是查找中位数
        if (array==null) return -1;
        int startIndex=0;
        int lastIndex=array.length-1;
        int index=partition(array,startIndex,lastIndex);
        int mid=(lastIndex+startIndex)/2;
        while (index>=0&&index<array.length&&index!=mid){
            if (index> mid){
                index=partition(array,startIndex,index-1);
            }else {
                index=partition(array,index+1,lastIndex);
            }
        }
        return array[index];
    }
    static int partition(int[] arrays, int si, int ei){
        int pivotIndex= new Random().nextInt(ei-si);
        int pivot=arrays[pivotIndex];
        exchange(arrays,pivotIndex,ei);
        int smallIndex=si;
        for (int i=si;i<ei;i++){
            if (arrays[i]<pivot){
                exchange(arrays,smallIndex,i);
                smallIndex++;
            }
        }
        exchange(arrays,smallIndex,ei);
        return smallIndex;
    }

    private static void exchange(int[] arrays, int source, int target) {
        int temp=arrays[target];
        arrays[target]= arrays[source];
        arrays[source]=temp;
    }

    public static void main(String[] args) {
//        int[] arrays={1,2,3,2,2,2,5,4,2};
        int[] arrays={1,1,1,1,3,4,5};
        int index = findNumber(arrays);
        System.out.println(index);
    }
}
