package question3;

/*
不修改数组，找出重复的数字，大致的思路类似于二分查找。P42.题目中的条件说至少有一个重复数字。

解法：时间O(nlogn),O(1)
 */
public class question03in2 {
    public static int getDuplication(int[] numbers,int length){

        //输入条件的预判
        if (numbers==null||length<=1) return -1;//为空或者长度为1都无法查找到

        //判断数组内是否有负数。
        for (int i = 0; i < length; i++) {
            if (numbers[i]<=0) return -1;
        }

        int start=1;//这里的start并非数组的下标，
        int end=length-1;
        while (end>=start){ //end==start是这个循环的结束条件，这样的话也能找出重复的那个数
            int middle=(start+end)/2;
            int count=countRange(numbers,length,start,middle);
            if (end==start){
                if (count>1) return start;
                else break;
            }
            if (count>(middle-start+1)) end=middle;
            else start=middle+1;
        }
        return -1;
    }

    private static int countRange(int[] numbers, int length, int start, int end) {
        if (numbers==null) return -1;

        int count=0;

        for (int i = 0; i < length; i++) {
            if (numbers[i]>=start&&numbers[i]<=end) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,5,6,7,9};
        var a=getDuplication(array,array.length);
    }

}
