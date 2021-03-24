package question40.question45;

import java.util.*;

public class Question45_01 {
    static String minimumNumber(int[] nums){
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //字典序列小的放在堆顶
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        for (int num : nums) {
            queue.add(String.valueOf(num));
        }
        StringBuilder res = new StringBuilder();
        while (! queue.isEmpty()){
            res.append(queue.poll());
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        int[] a={222,222,222,1};
//        int[] a={3,32,321,222};
        int[] a={3,30,34,5,9};
        String s = minimumNumber(a);
        System.out.println(s);
    }
}
