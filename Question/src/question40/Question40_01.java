package question40;

import java.net.Inet4Address;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Question40_01 {
    static void getNumbers(int[] array,int k){
        if (k<=0||array.length<=0) return;
        if (k>=array.length){
            for (int a:array){
                System.out.println(a);
            }
            return;
        }
        int si=0;
        int ei=array.length-1;
        int index=partition(array,si,ei);
        while (index!=(k-1)){
            if (index>(k-1)){
                ei=index-1;
                index=partition(array,si,index-1);
            }else {
                si=index+1;
                index=partition(array,index+1,ei);
            }
        }
        for (int i=0;i<=index;i++){
            System.out.println(array[i]);
        }
    }
    static int partition(int[] a, int si, int ei){
        if (si==ei) return si;
        int num=new Random().nextInt(ei-si+1);
        int tempIndex=si+num;
        exchange(a,tempIndex,ei);
        int smallIndex=si;
        for (int i=si;i<=ei-1;i++){
            if (a[i]<a[ei]){
                exchange(a,smallIndex,i);
                smallIndex++;
            }
        }
        exchange(a,smallIndex,ei);
        return smallIndex;
    }
    private static void exchange(int[] a, int target, int ei) {
        if (target==ei) return;
        int temp=a[target];
        a[target]=a[ei];
        a[ei]=temp;
    }

    static void getNumbers1(int[] array,int k){
        if (k<=0||array.length<=0) return;
        if (k>=array.length){
            for (int a:array){
                System.out.println(a);
            }
            return;
        }
        PriorityQueue<Integer> max=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i=0;i<k;i++){
           max.add(array[i]);
        }
        for (int i=k;i<array.length;i++){
            if (array[i]<max.peek()){
                max.remove();
                max.add(array[i]);
            }
        }
        Iterator<Integer> iterator = max.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        int[] ints={4,5,1,3,2,8,9,0};
        getNumbers1(ints,90);
    }
}
