package question50.question57;

import com.sun.source.tree.IfTree;

public class Question57_1 {
    static boolean findNumbersEqualSum(int[] data,int num){
        if (data==null) return false;
        int tailIndex=data.length-1;
        int headIndex=0;
        while (headIndex<tailIndex){
            int sum=data[headIndex]+data[tailIndex];
            //如果这两个数的和大于num, 则尾指针向前移动一个位置
            if (sum>num){
                tailIndex--;
            }else if (sum<num){//比num小则头指针向后移动一个位置.
                headIndex++;
            }else {
                System.out.println("first number is:"+data[headIndex]+" and second number is: "+data[tailIndex]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a={1,2,4,7,11,15};
        boolean res = findNumbersEqualSum(a, 1);
        System.out.println(res);
    }
}
