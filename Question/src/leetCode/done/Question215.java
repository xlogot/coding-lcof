package leetCode.done;

import java.util.PriorityQueue;

public class Question215 {

//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        int res=0;
//        k--;
//        for (int i=nums.length-1;i>=0&&k>=0;i--,k--){
//            if (k==0){
//                res=nums[i];
//            }
//        }
//        return res;
//    }
    public int findKthLargest(int[] nums, int k) {
        //compare为false时, 这个值会进行交换, 默认为实现为
       PriorityQueue<Integer> queue=new PriorityQueue<>();
       for (int i=0;i<nums.length;i++){
           if (queue.size()<k){
               queue.offer(nums[i]);
           }else{
               if (queue.peek()<nums[i]){
                   queue.remove();
                   queue.offer(nums[i]);
               }
           }
       }
        return  queue.poll();
    }

    public static void main(String[] args) {
        Question215 t1=new Question215();
//        int[] a={3,2,3,1,2,4,5,5,6};
        int[] a={3,2,1,5,6,4};
        int kthLargest = t1.findKthLargest(a, 4);
        System.out.println(kthLargest);
    }
}
