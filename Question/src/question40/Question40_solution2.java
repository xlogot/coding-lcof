package question40;

import java.beans.beancontext.BeanContext;
import java.security.KeyManagementException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Question40_solution2 {
    static void findKMinimumNumbers(int[] data,int KNumbers){
        if (data==null||KNumbers <= 0 ) return;
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(KNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1是输入的参数,o2是root的值.
                return o2-o1;
            }
        });
        for (int i = 0; i < KNumbers; i++) {
            if (i>=data.length) break;
            priorityQueue.add(data[i]);
        }
        int index=KNumbers;
        while (index<data.length){
            if (data[index]<priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(data[index]);
            }
            index++;
        }
        while (!priorityQueue.isEmpty()){
            Integer poll = priorityQueue.poll();
            System.out.println(poll);
        }
    }


    public static void main(String[] args) {
        int[] ints={4,5,1,3,2,8,9,0};
        findKMinimumNumbers(ints,3);
    }
}
