package question50.question59;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.jar.JarEntry;
import java.util.stream.Stream;

public class Question59_1 {
    static int[] slideWindow(int[] array,int size){
        Queue<Integer> queue=new LinkedList<>();
        int count=0;
        int[] maxValues=new int[array.length-size+1];
        int index=0;
        for (int i = 0; i < array.length; i++) {
            if (count==size){
                Integer max = getMax(queue);
                maxValues[index++]=max;
                queue.poll();
                count--;
            }
            queue.offer(array[i]);
            count++;
        }
        Integer max = getMax(queue);
        maxValues[index++]=max;
        return maxValues;
    }

    private static Integer getMax(Queue<Integer> queue) {
        Integer integer = queue.stream().max(Comparator.comparingInt(i -> i)).get();
        return integer;
    }

    public static void main(String[] args) {
        int[] a={2,3,4,2,6,2,5,1};
        int[] ints = slideWindow(a, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
