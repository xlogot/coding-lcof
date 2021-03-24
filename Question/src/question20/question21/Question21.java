package question20.question21;


import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class Question21 {
    private static void reorderOddEven(int[] data,int length){
        if (data==null||length<=0) return;
        int startIndex=0;
        int endIndex=length-1;
        while (startIndex<endIndex){
            while (startIndex< endIndex&&((data[startIndex]&0x1)!=0))
                startIndex++;
            while (startIndex<endIndex&&((data[endIndex]&0x1)==0))
                endIndex--;
            if (startIndex<endIndex){
                int temp=data[startIndex];
                data[startIndex]=data[endIndex];
                data[endIndex]=temp;
            }
        }
    }

    //加入函数式接口, 增加健壮性.
    private static void reorder(int[] data, int length, Predicate<Integer> func){
        if (data==null||length<=0) return;
        int startIndex=0;
        int endIndex=length-1;
        while (startIndex<endIndex){
            while (startIndex< endIndex&&!func.test(data[startIndex]))
                startIndex++;
            while (startIndex<endIndex&&func.test(data[endIndex]))
                endIndex--;
            if (startIndex<endIndex){
                int temp=data[startIndex];
                data[startIndex]=data[endIndex];
                data[endIndex]=temp;
            }
        }
    }

    static volatile int num=0;
    public static void main(String[] args) {
        int[] data={1,2,3,4,5};

        reorderOddEven(data,data.length);
        reorder(data,data.length,integer -> integer>=0);
//
//        for (int datum : data) {
//            System.out.printf("%d ,", datum);
//        }
//        System.out.printf("\n");
        final int THREADS_COUNT=20;

        //AtomicInteger num=new AtomicInteger(0);

//        Thread[] threads = new Thread[THREADS_COUNT];
//        for (int i = 0; i < THREADS_COUNT; i++) {
//            threads[i] = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 10000; i++) {
//                        //num.incrementAndGet();
//                        num=i;
//                    }
//                }
//            });
//            threads[i].start();
//        }
//        while (Thread.activeCount() > 1)
//        Thread.yield();
        System.out.println(num);
    }
}
