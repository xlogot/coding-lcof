package question40.question41;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Question41 {

    private static PriorityQueue<Integer> maxHeap=new PriorityQueue<>((o1,o2)-> o2-o1);

    private static PriorityQueue<Integer> minHeap=new PriorityQueue<>();

    public static void insert(int num){
        if (((maxHeap.size()+minHeap.size())&1)==0){
            //偶数插入到最小堆,
            //当这个数比最大堆的根元素要大时,将根元素插入到最小堆,num进最大堆
            if (maxHeap.size()>0&&num<maxHeap.peek()){
                Integer poll = maxHeap.poll();
                maxHeap.add(num);
                minHeap.add(poll);
            }
            //正常情况将num插入最小堆
            minHeap.add(num);
        }
        else{
            //为奇数的情况,将num插入到最大堆
            //当num比最小堆的根元素要大时, 将根元素插入到最大堆,然后将num插入到最小堆
            if (minHeap.size()>0&&num>minHeap.peek()){
                Integer poll = minHeap.poll();
                minHeap.add(num);
                maxHeap.add(poll);
            }
            maxHeap.add(num);
        }
    }

    public static int getMedian(){
        int size=minHeap.size()+maxHeap.size();
        if (size==0) return -1;
        int median=0;
        if ((size&1)==0){
            median=(maxHeap.peek()+minHeap.peek())/2;
        }else {
            median=maxHeap.peek();
        }
        return median;
    }




    public static void main(String[] args) {

    }
}
